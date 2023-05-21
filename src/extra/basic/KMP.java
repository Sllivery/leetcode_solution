package extra.basic;

public class KMP {
    public static void main(String[] args) {

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

    private static int[] buildNext(char[] subString) {
        return new int[0];
    }
}
