package 레벨2;

public class 멀쩡한사각형 {
    public long solution(int w, int h) {

        long n = gcd(w, h);

        long W = w;
        long H = h;
        if (n != 1) {
            W = w / n;
            H = h / n;
        }

        return (long) w * (long) h - n * (W + H - 1);
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
