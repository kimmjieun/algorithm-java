package 레벨2.DFS;

public class 기능개발 {
    int answer = 0;

    public int solution(int[] numbers, int target) {

        back(0, target, numbers, 0);

        return answer;
    }

    public void back(int depth, int target, int[] numbers, int result) {
        if (depth == numbers.length) {
            if (target == result) {
                answer++;

            }
            return;
        }

        back(depth + 1, target, numbers, result + numbers[depth]);
        back(depth + 1, target, numbers, result - numbers[depth]);

    }
}
