
package com.example

import org.junit.jupiter.api.Test

internal class SolutionTest

@Test
fun main(args: Array<String>) {

    var idList = arrayOf("muzi", "frodo", "apeach", "neo")
    var report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi")
    val k = 2


    val result = solution(idList, report, k)
    println(result)

}

fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val size = id_list.size
    val answer = IntArray(size)

    // 유저가 신고한 Id 정보 저장 맵. 중복을 허용하지 않으므로 Set 으로 저장 함
    val userReportMap = mutableMapOf<String, MutableSet<String>>()

    // 유저가 신고한 Id 개수 저장
    val banUserMap = mutableMapOf<String, Int>()

    // 초기화
    for (id in id_list) {
        userReportMap[id] = mutableSetOf()
        banUserMap[id] = 0
    }

    for (r in report) {
        val (key, result) = r.split(" ").map { it }
        userReportMap[key]?.let { map ->
            if (map.add(result)) {
                banUserMap[result]?.let {
                    banUserMap[result] = it + 1
                }
            }
        }
    }
    // 정지당한 ID 리스트
    for (r in report) {
        val (key, result) = r.split(" ").map { it }
        banUserMap[result]?.let { it ->
            if (it < k) {
                userReportMap[key]?.remove(result)
            }
        }
    }
    //정지당한 ID 가 몇 개 있는 지 확인
    for ((index, id) in id_list.withIndex()) {
        userReportMap[id]?.let {
            answer[index] = it.size
        }
    }
    return answer
}