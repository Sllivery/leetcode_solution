package extra.basic;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        char[] test = {'a', 'b', 'c', 'a', 'b', 'd', 'd', 'd', 'a', 'b', 'c', 'a', 'b', 'c'};
        int[] ints = buildNext(test);
        System.out.println(Arrays.toString(ints));
    }

    static int KMP (char[] mainString, char[] subString){
        int[] next = buildNext(subString);
        int j = 0;
        for (int i = 0; i < mainString.length; i++) {
            while (j < subString.length) {
                if (mainString[i] == subString[j]) {
                    j++;
                } else if (mainString[i] != subString[j]) {
                    j = next[j - 1];
                } else if (j == subString.length - 1) {
                    return i - j;
                }
            }
        }
        return -1;
    }

    private static int[] buildNext(char[] subString){
        //明确next数组的定义
        //明确next数组下标的定义
        //明确next数组元素的定义 到目前为止，最长的公共前后缀的长度为多少 {a} 0 {a, b} 0, 0 {a,b,a}0, 0, 1? {a,b,a,b}0,0,1,2
        int[] next = new int[subString.length];
        int left = 0;
        int right = 1;
        next[0] = 0;
        while (right < subString.length) {
            if (subString[left] == subString[right]) {
                next[right] = next[right - 1] + 1;
                right++;
                left++;
            } else if (left > 0) {
                left = next[left - 1];
            } else {
                next[right] = 0;
                right++;
            }
        }
        return next;
    }

    private static int[] buildNextWrong(char[] subString) {
        //这是我现在写代码最大的问题，面对一个特殊情况写。
        //我怎么面对一般情况写，并且证明呢？
        //不明确
        int[] next = new int[subString.length];
        int left = 0;
        int right = 1;
        next[0] = 0;
        while (right < subString.length) {
            if (subString[left] == subString[right]) {
                next[right] = left;
                right++;
                left++;
            } else {
                if (next[right - 1] > 0) {
                    next[right] = next[right - 1] - 1;
                } else {
                    next[right] = 0;
                }
                right++;
            }
        }
        return next;
    }
}
