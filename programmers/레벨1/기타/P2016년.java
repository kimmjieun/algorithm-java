package 레벨1.기타;

public class P2016년 {
    public String solution(int a, int b) {

        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        int sum = b;

        for (int i = 0; i < a - 1; i++) {
            sum += days[i];
        }

        System.out.println(sum);
        String answer = dayOfWeek[sum % 7];
        return answer;
    }
}
