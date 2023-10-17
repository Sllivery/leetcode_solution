package daily_problems;

public class EditDistance72 {
    public static void main(String[] args) {
        String tset = "123";
        System.out.println(tset.substring(0));
    }

    static class Solution {
        public int minDistance(String word1, String word2) {
            if (word1.length() == 0 || word2.length() == 0){
                return Math.abs(word1.length() - word2.length());
            }
            //keep word1 as the samller one
            if (word1.length() > word2.length()) {
                return minDistance(word2, word1);
            }

            return dp(word1, word2, 0, 0);
        }

        private int dp(String word1, String word2, int index1, int index2){
            if (word1.equals(word2)) return 0;
            if (index1 >= word1.length() - 1 && index2 < word2.length() - 1){
                return word2.length() - word1.length();
            }

            int minCost = Integer.MAX_VALUE;
            if (word1.charAt(index1) == word2.charAt(index2)){
                return dp(word1, word2, index1 + 1, index2 + 1);
            } else {
                //insert before index1, index2 are equals
                String insert = word1.substring(0, index1 + 1);
                insert += word2.substring(index2, index2 + 1);
                insert += word1.substring(index1 + 1);
                minCost = Math.min(dp(insert, word2, index1 + 1, index2), minCost) + 1;
                //delete
                String delete = word2.substring(0, index2);
                delete += word2.substring(index2 + 1);
                minCost = Math.min(dp(word1, delete, index1 + 1, index2), minCost) + 1;
                //replace
                String replace = word2.substring(0, index2 + 1);
                replace += word1.substring(index1, index1 + 1);
                replace += word2.substring(index2 + 1);
                minCost = Math.min(dp(word1, replace, index1 + 1, index2 + 1), minCost) + 1;
            }
            return minCost;
        }
    }
}
