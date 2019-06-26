public class Main {
}

class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int[] minus = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            minus[i - 1] = A[i] - A[i - 1];
        }
        int[] count = new int[minus.length];
        for (int i = 1; i < minus.length; i++) {
            if (minus[i] == minus[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int i: count) {
            sum += i;
        }
        return sum;
    }
}
