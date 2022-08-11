package 레벨1.쉬운문제;

public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int n : numbers) {
            answer -= n;
        }

        return answer;
    }

    public int solution2(int[] numbers) {
        int answer = 0;
        boolean[] num = new boolean[10];
        for (int i = 0; i < numbers.length; i++) {
            num[numbers[i]] = true;
        }
        for (int i = 0; i < num.length; i++) {
            if (!num[i]) {
                answer += i;
            }

        }
        return answer;
    }
}
