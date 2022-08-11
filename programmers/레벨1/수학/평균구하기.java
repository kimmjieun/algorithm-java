package 레벨1.수학;

public class 평균구하기 {
    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        answer = (double) sum / (double) arr.length;
        return answer;
    }
}
