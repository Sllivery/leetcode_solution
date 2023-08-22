package daily_problems;

public class GasStation140 {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};

        Solution so = new Solution();
        int i = so.canCompleteCircuit(gas, cost);
        System.out.println(i);
        int i2 = so.canCompleteCircuit(gas2, cost2);
        System.out.println(i2);
    }

    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            //所见即所得方法
            int startPoint = -1;
            int currentPoint = -1;
            int leftGas = 0;
            for (int i = 0; i < gas.length; i++) {
                startPoint = i;
                currentPoint = i;
                leftGas = gas[i];
                while (leftGas > 0) {
                    leftGas -= cost[currentPoint];
                    if (leftGas >= 0) {
                        if (currentPoint == gas.length - 1) {
                            currentPoint = 0;
                        } else {
                            currentPoint++;
                        }
                        leftGas += gas[currentPoint];
                    }
                    if (leftGas >= 0 && currentPoint == startPoint) {
                        return startPoint;
                    }
                }
            }
            return -1;
        }

        public int canCompleteCircuit2(int[] gas, int[] cost) {
            int total = 0, current = 0, answer = 0;
            for (int i = 0; i < gas.length; i++) {
                total += gas[i] - cost[i];
                current += gas[i] - cost[i];
                if (current < 0) {
                    answer = i + 1;
                    current = 0;
                }
            }
            return total >= 0 ? answer : -1;
        }
    }
}
