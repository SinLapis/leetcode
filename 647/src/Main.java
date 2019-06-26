public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstrings("abc"));
    }
}

class Solution {
    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        int sum = 0;
        // 间隔对称
        int mid1 = 0;
        int i = mid1, j = mid1 + 1;
        while (mid1 < cs.length - 1) {
            if (i >= 0 && j < cs.length && cs[i] == cs[j]) {
                sum++;
                i--;
                j++;
            } else {
                mid1++;
                i = mid1;
                j = mid1 + 1;
            }
        }
        // 字符对称
        int mid2 = 0;
        i = mid2 - 1;
        j = mid2 + 1;
        while (mid2 < cs.length) {
            if (i >= 0 && j < cs.length && cs[i] == cs[j]) {
                sum++;
                i--;
                j++;
            } else {
                sum++;
                mid2++;
                i = mid2 - 1;
                j = mid2 + 1;
            }
        }
        return sum;
    }
}
