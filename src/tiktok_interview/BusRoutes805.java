package tiktok_interview;

import java.util.*;

public class BusRoutes805 {
    public static void main(String[] args) {
        int[][] test = {{1, 2, 7}, {3, 6, 7}};

    }

    static class Solution {
        public int numBuesToDestination(int[][] routes, int source, int target) {
            if(source == target) return 0;
            //optimized---start
            boolean foundS = false, foundT = false;
            for (int[] route : routes) {
                for (int i : route) {
                    if(!foundS && i == source) foundS = true;
                    if(!foundT && i == target) foundT = true;
                }
            }
            if (!foundS || !foundT) return -1;
            //optimized---end
            boolean[] visit = new boolean[routes.length];
            Map<Integer, List<Integer>> map = new HashMap<>();
            //build graph
            for(int i = 0; i < routes.length; i++){
                for(int x : routes[i]){
                    List<Integer> list = map.getOrDefault(x, new ArrayList<>());
                    list.add(i);
                    map.put(x, list);
                }
            }
            //bfs
            int step = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(source);
            while(!q.isEmpty()){
                step++;
                int size = q.size();
                while(size-- > 0){
                    int cur = q.poll();
                    if(!map.containsKey(cur)) continue;
                    for(int x : map.get(cur)){
                        if(visit[x]) continue;
                        visit[x] = true;
                        for(int y : routes[x]){
                            if(y == target) return step;
                            q.add(y);
                        }
                    }
                }
            }
            return -1;
        }
        public int numBusesToDestinationMy(int[][] routes, int source, int target) {
            //1.build graph
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
            for (int[] route : routes) {
                for (int i = 0; i < route.length; i++) {
                    for (int j = 0; j < route.length; j++) {
                        if (i == j) {
                            continue;
                        }
                        if (!graph.containsKey(i)) {
                            ArrayList<Integer> inner = new ArrayList<>();
                            inner.add(j);
                            graph.put(i, inner);
                        } else {
                            ArrayList<Integer> inner = graph.get(i);
                            inner.add(j);
                        }
                    }
                }
            }
            //2.bfs
            boolean flag = false;
            int min = Integer.MAX_VALUE;
            int cost = 1;
            ArrayList<Integer> value = graph.get(source);
            Queue<Integer> queue = new LinkedList<>(value);
            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                cost += 1;
                if (poll == target) {
                    flag = true;
                    break;
                }
                ArrayList<Integer> integers = graph.get(poll);
                queue.addAll(integers);
            }
            if (flag) {
                //3.update route cost;
                min = cost;
            }
            return flag ? min : -1;
        }
    }
}
