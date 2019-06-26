import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divisorGame(2));
    }
}
class Solution {
    public boolean divisorGame(int N) {
        boolean[] result = new boolean[N + 1];
        result[0] = false;
        for (int i = 1; i <= N; i++) {
            result[i] = false;
            for (int j = 1; j < i; j++) {
                if (!result[i - j] && i % j == 0) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[N];
    }
}
