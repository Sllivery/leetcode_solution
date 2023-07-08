package daily_problems;

import java.util.*;

public class Combinations77 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4,2);
        for (List<Integer> integers : combine) {
            System.out.println(integers.toString());
        }
    }

    static class Solution {
        private int k;
        private int n;
        public List<List<Integer>> myCombine(int n, int k) {
            //the logic is completely chaos
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> inner = new ArrayList<>();
            HashSet<String> set = new HashSet<>();
            boolean flag = false;
            if (n == 1 && k == 1) {
                inner.add(1);
                result.add(inner);
                return result;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }
                    inner.add(i);
                    if (inner.size() < k) {
                        flag = true;
                        inner.add(j);
                        Collections.sort(inner);
                        if (set.contains(inner.toString())) {
                            //inner.remove(inner.size() - 1);//但是这里如果只清一个，那么当前i会重复
                            inner = new ArrayList<>();
                        } else {
                            set.add(inner.toString());
                        }
                    }
                    if (inner.size() == k) {
                        if (flag == false) {
                            Collections.sort(inner);
                            if (set.contains(inner.toString())) {
                                //inner.remove(inner.size() - 1);//但是这里如果只清一个，那么当前i会重复
                                inner = new ArrayList<>();
                            } else {
                                set.add(inner.toString());
                                result.add(inner);
                                inner = new ArrayList<>();
                            }
                        } else {
                            result.add(inner);
                            inner = new ArrayList<>();
                        }
                    }
                }
            }
            return result;
        }

        public List<List<Integer>> combine(int n, int k) {
            this.k = k;
            this.n = n;
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> current = new ArrayList<>();
            backtrack(current, 1, result);
            return result;
        }

        private void backtrack(List<Integer> current, int firstNum, List<List<Integer>> result) {
            if (current.size() == this.k){
                result.add(new ArrayList<>(current));//深拷贝一下，不然别的引用到current的地方，会修改current。
                return;
            }

            //这是精髓
            int need = k - current.size();
            int remain = n - firstNum + 1;
            int available = remain - need;

            for (int i = firstNum; i <= firstNum + available; i++) {
                current.add(i);
                backtrack(current, i + 1, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
