package 레벨2.DP;

public class P2xn타일링 {
    public int solution(int n) {
        int answer = 0;
        int[] d = new int[60001];
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000007;
        }
        return d[n];
    }
}
