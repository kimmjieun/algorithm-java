package 레벨1.어려운문제;

public class 정수제곱근판별 {
    public long solution(long n) {
        long sqr = (long) Math.sqrt(n);
        // System.out.println(sqr);
        if (sqr * sqr == n) return (sqr + 1) * (sqr + 1);
        else return -1;

    }
}
