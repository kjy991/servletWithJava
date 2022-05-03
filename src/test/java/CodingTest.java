
import org.springframework.boot.SpringApplication;

import java.util.Arrays;


public class CodingTest {

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {3, 1}, {3, 5}, {2, 5}, {5, 3}};
        int result = 0;
        int i;
        int j = 0;
//
//        System.out.println(a.length);
//
//        for (i = 0; i < a.length; i++) {
//
//            for (j = 0; j < 2; j++) {
//                if (a[i][0] < a[i][1]) {
//                    a[i][0] = a[i][1];
//
//                    System.out.println();
//                }
//            }
//        }

        int k = 0, start = -1, end = 2;
        int r, c;
        short sw = 1;

        for (r = 1; r <= 5; r++) {
            if (sw == 1) {
                for (c = 1; c <= end; c++) {
                    k = k + 1;
                    a[r][c] = k;
                }
                sw = 2;
            } else {
                for (c = 5; c >= start; c--) {
                    k = k + 1;
                    a[r][c] = k;
                }
                sw = 1;
            }
        }
        for (r = 1; r <= 5; r++) {
            for (c = 1; c <= 5;c++){
                System.out.println(a[r][c]);
            }
        }


    }
}











