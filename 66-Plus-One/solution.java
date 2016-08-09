public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return digits;
        }
        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        
        if (carry != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        return digits;
    }
}