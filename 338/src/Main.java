import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.countBits(5)));
    }
}
class Solution {
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        int max = 2;
        int j = 0;
        for (int i = 2; i <= num; i++) {
            if (j >= max) {
                max <<= 1;
                j = 0;
            }
            result[i] = 1 + result[j];
            j++;
        }
        return result;
    }
}
