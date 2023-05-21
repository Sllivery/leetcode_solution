package daily_problems;

import java.util.HashMap;

public class MultiplyStrings43 {
    public static void main(String[] args) {
        String test1 = "2";
        String test2 = "3";
        Solution solution = new Solution();
        String result = solution.multiply(test1, test2);
        System.out.println(result);
    }

    static class Solution{
        public String myMultiply(String num1, String num2) {
            //with this method, the number will be out of bound. But string type won't have this problem.
            //so how to perform mulitply without using * ?
            int num1Integer = 0;
            int num2Integer = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(48, 0);
            map.put(49, 1);
            map.put(50, 2);
            map.put(51, 3);
            map.put(52, 4);
            map.put(53, 5);
            map.put(54, 6);
            map.put(55, 7);
            map.put(56, 8);
            map.put(57, 9);
            for (int i = 0; i < num1.length(); i++) {
                num1Integer = num1Integer * 10 + map.get((int)num1.charAt(i));
            }

            for (int i = 0; i < num2.length(); i++) {
                num2Integer = num2Integer * 10 + map.get((int)num2.charAt(i));
            }

            int result = num1Integer * num2Integer;
            StringBuilder builder = new StringBuilder();
            if (result == 0) {
                builder.append(0);
            }
            while (result > 0) {
                builder.append(result % 10);
                result /= 10;
            }
            builder.reverse();
            return builder.toString();
        }

        public String multiply(String num1, String num2) {
            //一开始我思路里滑过用竖式计算，但是我想一般这种直接套人类计算方法行不通，我就没接着想
            //题解里有这个方法，值得思考一下他的算法
            //至少每次乘不会越界，加的话也不会
            int length1 = num1.length();
            int length2 = num2.length();
            int[] result = new int[length1 + length2];
            for (int i = length1 - 1; i >= 0; i--) {
                for (int j = length2 - 1 ; j >= 0; j--) {
                    int multiplier = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                    int sum = multiplier + result[i + j + 1];
                    result[i + j] += sum/10;
                    result[i + j + 1] = sum % 10;
                    //how to tackle the carrying
                    /*if (result[i + j] + unit > 10) {
                        result[i + j] = 0;
                    }
                    for (int k = ; k < ; k++) {

                    }*/
                }
            }
            StringBuilder builder = new StringBuilder();
            int sum = 0;
            for (int i = 0; i < result.length; i++) {
                if (!(i == 0 && result[0] == 0)) builder.append(result[i]);

            }
            return sum == 0 ? "0": builder.toString();
        }
    }
}
