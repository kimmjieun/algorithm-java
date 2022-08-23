package 레벨2.수학;


class n개의최소공배수 {
    public int solution(int[] arr) {
        int answer = 0;

        int tmp = lcm(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            answer = lcm(tmp, arr[i]);
            tmp = answer;
        }

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
