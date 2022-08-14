package 레벨2.수학;

public class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long gc = gcd(w, h);

        long W = (long) w;
        long H = (long) h;

        return W * H - gc * ((W / gc) + (H / gc) - 1);


    }

    public long gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
