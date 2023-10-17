package daily_problems;

public class CompareVersionNumbers165 {
    public static void main(String[] args) {
        String test = "1.2.2.3";
        String[] split = test.split("\\.");
        for (String s : split) {
            System.out.println(s);
        }
    }
    static class Solution {
        public int compareVersion(String version1, String version2) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");

            if (v1.length > v2.length){
                String s1 = String.join(".", v1);
                String s2 = String.join(".", v2);
                return -1 * compareVersion(s2, s1);
            }

            //v1 is the shorter
            int index1 = 0;
            int index2 = 0;

            while (index1 < v1.length) {
                int curr1 = Integer.parseInt(v1[index1]);
                int curr2 = Integer.parseInt(v2[index2]);
                if (curr1 > curr2) {
                    return 1;
                } else if (curr1 < curr2) {
                    return -1;
                } else {
                    index1++;
                    index2++;
                }
            }

            while (index2 < v2.length) {
                if (Integer.parseInt(v2[index2]) != 0) {
                    return -1;
                }
                index2++;
            }

            return 0;
        }

        public int mysillyVersion(String version1, String version2) {
            if (version1.length() > version2.length()) {
                return -1*compareVersion(version2, version1);
            }
            //version1 is the shorter
            int index1 = 0;
            int index2 = 0;
            boolean flag1 = false;
            boolean flag2 = false;
            while (index1 < version1.length()) {
                if (version1.charAt(index1) == '.' && version2.charAt(index2) != '.' && !flag2) {
                    return -1;
                }
                if (version2.charAt(index2) == '.' && version1.charAt(index1) != '.' && !flag1) {
                    return 1;
                }
                if (version1.charAt(index1) == version2.charAt(index2) && version1.charAt(index1) == '.') {
                    index1++;
                    index2++;
                }
                if (version1.charAt(index1) == '0' && !flag1) {
                    index1++;
                    continue;
                }
                if (version2.charAt(index2) == '0' && !flag2) {
                    index2++;
                    continue;
                }
                flag1 = true; flag2 = true;
                if (version1.charAt(index1) == version2.charAt(index2)) {
                    index1++;
                    index2++;
                    continue;
                } else if (version1.charAt(index1) > version2.charAt(index2)) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return 0;
        }
    }
}
