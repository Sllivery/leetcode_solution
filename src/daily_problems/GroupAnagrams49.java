package daily_problems;

import java.util.*;

public class GroupAnagrams49 {
    /*
    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] test = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = solution.groupAnagrams(test);
        System.out.println(lists.toString());
    }

    static class Solution{
        public List<List<String>> groupAnagramsV1(String[] strs) {
            //Time Limit Exceeded
            int[] checked = new int[strs.length];
            ArrayList<List<String>> result = new ArrayList<>();
            for (int j = 0; j < strs.length; j++) {
                if (checked[j] != 1) {
                    checked[j] = 1;
                    ArrayList<String> innerList = new ArrayList<>();
                    char[] checker = strs[j].toCharArray();
                    Arrays.sort(checker);
                    innerList.add(strs[j]);
                    for (int i = 0; i < strs.length; i++) {
                        if (checked[i] != 1){
                            char[] checkee = strs[i].toCharArray();
                            Arrays.sort(checkee);
                            if (Arrays.compare(checker, checkee) == 0 && i != j) {
                                checked[i] = 1;
                                innerList.add(strs[i]);
                            }
                        }
                    }
                    result.add(innerList);
                }
            }
            return result;
        }

        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            ArrayList<List<String>> result = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                String currentString = new String(chars);
                if (map.containsKey(currentString)) {
                    map.get(currentString).add(strs[i]);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    map.put(currentString, list);
                }
            }
            for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                result.add(entry.getValue());
            }
            return result;
        }
    }
}
