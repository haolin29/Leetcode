public class NumArray {
    
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        int s = 0;
        for(int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i] = s;
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - (i == 0 ? 0 : sum[i - 1]);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);