package 레벨1.기타;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zero = 0;
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    count++;
                    break;
                }
                if (lottos[i] == 0) {
                    zero++;
                    break;
                }
            }
        }
        if (zero == 6) {
            return new int[]{1, 6};
        } else if (zero == 0 && count == 6) {
            return new int[]{1, 1};
        } else if (zero == 0 && count == 0) {
            return new int[]{6, 6};
        } else {
            return new int[]{6 - count - zero + 1, 6 - count + 1};
        }

    }
}
