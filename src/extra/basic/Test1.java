package extra.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Trie tree = new Trie();
        tree.insert("bad");
        tree.insert("dad");
        tree.insert("mad");
        boolean test = tree.search("pad");
        boolean test2 = tree.search("bad");
        boolean test3 = tree.search(".ad");
        boolean test4 = tree.search("b..");
        System.out.println(test + " " + test2 + " " + test3 + " " + test4);
    }

    private static void shift(List<Integer> list, int target){
        int targetIndex = list.indexOf(target);
        int i = 0;
        while (i < targetIndex) {
            if (list.get(i) > target){
                boolean flag = false;
                for (int j = targetIndex + 1; j < list.size(); j++){
                    if (list.get(j) < target){
                        int temp = list.get(i);
                        list.set(i, list.get(j));
                        list.set(j, temp);
                        flag = true;
                        i++;
                        break;
                    }
                }
                if (!flag){
                    //insert list(i) at the taretIndex + 1 position
                    int temp = list.get(i);
                    for (int k = i + 1; k <= targetIndex; k++){
                        list.set(k - 1, list.get(k));
                    }
                    list.set(targetIndex, temp);
                }
            } else {
                i++;
            }
        }
    }
}
