package 레벨2.다시풀문제;

public class P124나라의숫자_수학 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int tmp = n % 3;

            if (tmp == 0) tmp = 4;
            sb.append(tmp);

            if (tmp == 0) {
                n = n / 3 - 1;
            } else {
                n = n / 3;
            }

        }

        return sb.reverse().toString();
    }

    public String solution2(int n) {
        String answer = "";
        String[] nums = {"4", "1", "2"};

        while (n != 0) {
            int remainder = n % 3;

            n /= 3;
            if (remainder == 0) n--;
            answer = nums[remainder] + answer;

        }
        return answer;
    }
}
