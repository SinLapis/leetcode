public class Main {
}

class NumArray {
    int[] arr;
    int[] sum;
    int front;

    public NumArray(int[] nums) {
        if(nums.length == 0) return;
        arr = nums;
        front = 0;
        sum = new int[nums.length];
        sum[0] = nums[0];
    }

    public int sumRange(int i, int j) {
        if (j > front) {
            for (int k = front + 1; k <= j; k++) {
                sum[k] = sum[k - 1] + arr[k];
                front++;
            }
        }
        if (i == 0) return sum[j];
        else return sum[j] - sum[i - 1];
    }
}
