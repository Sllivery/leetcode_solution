package extra.basic;

public class BubbleSort{
    public static void main(String[] args) {
        //oolean flag = false;
        //nt[] a = {6, 2, 4, 8, 11, 2, 1, 9};
        //o {
        //   for (int i = 0; i < a.length - 1; i++) {

        //       if (a[i] > a[i + 1]) {
        //           int temp = a[i + 1];
        //           a[i + 1] = a[i];
        //           a[i] = a[i + 1];
        //           flag = true;
        //       } else {
        //           flag = false;
        //       }
        //   }
        // while (flag);
        //or (int i = 0; i < a.length; i++) {
        //   System.out.println(a[i]);
        //

        int[] b = {6, 2, 4, 8, 11, 2, 1, 9};
        while (true) {
            boolean flagb = false;
            for (int i = 0; i < b.length - 1; i++) {
                if (b[i] > b[i + 1]) {
                    int tempb = b[i + 1];
                    b[i + 1] = b[i];
                    b[i] = tempb;
                    flagb = true;
                }
            }
            if (!flagb) {
                break;
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
