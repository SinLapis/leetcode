import java.util.List;

public class Main {
}
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        int[] sum = new int[n];
        sum[0] = triangle.get(0).get(0);
        int min = sum[0];
        for (int i = 1; i < n; i++) {
            sum[i] = triangle.get(i).get(i) + sum[i - 1];
            min = sum[i];
            for (int j = i - 1; j > 0; j--) {
                sum[j] = Math.min(sum[j], sum[j - 1]) + triangle.get(i).get(j);
                if (sum[j] < min) min = sum[j];
            }
            sum[0] = triangle.get(i).get(0) + sum[0];
            if (sum[0] < min) min = sum[0];
        }
        return min;
    }
}
