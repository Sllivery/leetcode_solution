package microsoft_q.arrays_strings;

public class ReverseWordsinaString {
    public static void main(String[] args) {
        String s = "a good   example";
        Solution solution = new Solution();
        String result = solution.reverseWords(s);
        System.out.println(result);
    }

    static class Solution{
        public String reverseWords(String s) {
            s = s.trim();
            String[] array = s.split(" ");
            StringBuffer buffer = new StringBuffer();
            for (int i = array.length - 1; i >= 0; i--){
                if (!array[i].equals("")) {
                    buffer.append(array[i].trim());
                    if (i != 0){
                        buffer.append(" ");
                    }
                }
            }
            return buffer.toString();
        }

    }
}
