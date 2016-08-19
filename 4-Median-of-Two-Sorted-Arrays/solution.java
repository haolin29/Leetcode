public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 1) {
            return findK(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (findK(nums1, 0, nums2, 0, len / 2) + findK(nums1, 0, nums2, 0, len / 2 + 1)) / 2;
        }
    }
    
    public double findK(int[] A, int s1, int[] B, int s2, int k) {
        if(s1 >= A.length) {
            return B[s2 + k - 1];
        }
        
        if(s2 >= B.length) {
            return A[s1 + k - 1];
        }
        
        if(k == 1) {
            return Math.min(A[s1],B[s2]);
        }
        
        int A_key = (s1 + k / 2 - 1) < A.length ? A[s1 + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = (s2 + k / 2 - 1) < B.length ? B[s2 + k / 2 - 1] : Integer.MAX_VALUE;
        
        if(A_key < B_key) {
            return findK(A,s1 + k / 2, B, s2, k - k / 2);
        } else {
            return findK(A,s1, B, s2 + k / 2, k - k / 2);
        }
    }
}