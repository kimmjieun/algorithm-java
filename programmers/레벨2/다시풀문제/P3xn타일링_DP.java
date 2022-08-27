package 레벨2.다시풀문제;


public class P3xn타일링_DP {
    private final int MOD = 1000000007;

    public int solution(int n) {
        if(n < 2) return 0;

        long unique = 0;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;

        for(int i=4; i<=n; i+=2) {
            unique += (2 * dp[i-4]) % MOD;
            dp[i] = (3 * dp[i-2] + unique) % MOD;
        }

        return (int) dp[n];
    }
}
