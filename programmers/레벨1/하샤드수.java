package 레벨1;

public class 하샤드수 {
    public boolean solution(int x) {
        boolean answer = true;
        // 자릿수 합하기

        int sum = 0;
        String s = String.valueOf(x);
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.charAt(i) + "");
        }

        // 합으로 x나누기
        if (x % sum == 0) return true;
        else return false;

    }
}
