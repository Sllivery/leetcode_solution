package extra.basic;

import utils.TreeNode;

import java.util.ArrayList;

public class Trie {
    private TrieNode root;

    //constructor
    public Trie() {
        this.root = new TrieNode('1');
    }

    /**
     * @return success true. already existed return false;
     */
    public boolean insert(String str) {
        //check curr char whether it exist in current level
        TrieNode root = this.root;
        insertHelper(root, str, 0);
        return true;
    }

    public boolean search(String str) {
        TrieNode root = this.root;
        return searchHelper(root, str, 0);
    }

    private boolean searchHelper(TrieNode node, String str, int index) {
        if (node.end && index == str.length()) {
            return true;
        }

        if (index == str.length()){
            return false;
        }

        char currChar = str.charAt(index);
        ArrayList<TrieNode> children = node.children;
        if (index < str.length() - 1 && children.size() == 0) {
            return false;
        }
        for (int i = 0; i < children.size(); i++) {
            if (currChar == '.'){
                if ((searchHelper(children.get(i), str, index + 1))) {
                    return true;
                }
            } else if (children.get(i).aChar == currChar) {
                if ((searchHelper(children.get(i), str, index + 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void insertHelper(TrieNode node, String str, int index) {
        if (index == str.length()) {
            //set terminal node
            node.end = true;
            return;
        }

        char currChar = str.charAt(index);
        ArrayList<TrieNode> children = node.children;
        int childrenSize = children.size();

        //initialize a new node.
        if (childrenSize == 0) {
            children.add(new TrieNode(currChar));
            insertHelper(children.get(0), str, index + 1);
            return;
        }

        boolean flag = false;
        for (int i = 0; i < childrenSize; i++) {
            TrieNode nextNode = children.get(i);
            if (nextNode.aChar == currChar) {
                insertHelper(nextNode, str, index + 1);
                flag = true;
            }
        }

        if (flag) {
            return;
        } else {
            children.add(new TrieNode(currChar));
            insertHelper(children.get(children.size() - 1), str, index + 1);
        }
    }

    //print

    //dataStruct
    class TrieNode {
        boolean end;
        char aChar;
        ArrayList<TrieNode> children = new ArrayList<>();

        public TrieNode(char aChar) {
            this.aChar = aChar;
        }
    }
}
