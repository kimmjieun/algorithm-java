package 레벨1;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int zero = 0;
        int equal = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0)
                zero++;
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    equal++;
                }
            }
        }

        if (equal == 0 && zero == lottos.length) {
            answer[0] = 1;
            answer[1] = lottos.length;
        } else if (equal == lottos.length && zero == 0) {
            answer[0] = 1;
            answer[1] = 1;
        } else if (equal == 0 && zero == 0) {
            answer[0] = lottos.length;
            answer[1] = lottos.length;
        } else {
            answer[0] = lottos.length - equal - zero + 1;
            answer[1] = lottos.length - equal + 1;
        }

        return answer;
    }
}
