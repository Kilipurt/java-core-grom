package lesson18.homework;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();

        System.out.println(Arrays.toString(solution1.findNumbers("2t g3g34g 34gg   456 58 9 321 32f ")));
        System.out.println();
        System.out.println(Arrays.toString(solution2.findNumbers("2t g3g34g 34gg   456 58 9 321 32f ")));
    }
}
