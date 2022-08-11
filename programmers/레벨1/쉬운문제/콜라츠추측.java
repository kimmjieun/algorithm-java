package 레벨1.쉬운문제;

public class 콜라츠추측 {
    public int solution(int num) {
        int answer = 0;

        if (num == 1) return 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;

            } else if (num % 2 == 1) {
                num = num * 3 + 1;

            }
            answer++;
            // 500번 시도 ?
            if (answer == 500) return -1;
        }
        return answer;
    }
}

