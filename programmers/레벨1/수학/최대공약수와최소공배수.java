package 레벨1.수학;

public class 최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);
        return answer;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;

        }
        return a;
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
