package 레벨1.기타;

public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = 0;

        long pay = 0;
        for (int i = 1; i <= count; i++) {
            pay += i * price;
        }
        if (pay > money) {
            answer = pay - money;
        } else {
            answer = 0;
        }

        return answer;
    }
}
