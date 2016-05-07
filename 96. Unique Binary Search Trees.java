//若数组为空，则只有一种BST，即空树，f(0)=1;  
//若数组仅有一个元素1，则只有一种BST，单个节点，f(1)=1;  
//若数组有两个元素1，2，则有两种可能，f(2)=f(0)*f(1)+f(1)*f(0);  
//若数组有三个元素1，2，3，则有f(3)=f(0)*f(2)+f(1)*f(1)+f(2)*f(0)  
//由此可以得到递推公式：f(i)=f(0)*f(i-1)+...+f(k-1)*f(i-k)+...+f(i-1)*f(0)  
//利用一维动态规划来求解  

public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
        	for (int k = 1; k <= i; k++) {
        		dp[i] += dp[k - 1] * dp[i - k];
        	}
        }

        return dp[n];

    }
}