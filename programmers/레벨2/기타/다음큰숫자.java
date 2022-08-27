package 레벨2.기타;


class 다음큰숫자 {
    public int solution(int n) {
        int answer = 0;

        String s = Integer.toString(n, 2);
        s = s.replace("0", "");
        int len = s.length();

        while (true) {
            n++;
            String newS = Integer.toString(n, 2);
            newS = newS.replace("0", "");
            if (newS.length() == len) break;
        }

        return n;
    }
}
