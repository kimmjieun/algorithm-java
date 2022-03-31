package 레벨1;

public class 다트게임 {
    public int solution(String dartResult) {

        // 각 라운드에서 획득한 점수
        int[] round = new int[3];
        char[] carr = dartResult.toCharArray();
        // 인덱스 조정을 위해 -1부터 시작 매 반복마다 증가시켜야하는데 첫번째 반복에서는 0이되도록
        int idx = -1;
        for (int i = 0; i < carr.length; i++) {
            // n번재 라운드에 쏜 점수가 0-0인경우
            if (carr[i] >= '0' && carr[i] <= '9') {
                idx++;// 이전 라운드에서 현재라운드로 증가된 것 -1 -> 0
                // 점수 추가
                round[idx] += Integer.parseInt(String.valueOf(carr[i]));
                // n번째 라운드에 쏜 점수가 10점인 경우
                if (i + 1 != carr.length - 1 && carr[i + 1] == '0' && carr[i] == '1') {
                    round[idx] -= Integer.parseInt(String.valueOf(carr[i]));
                    round[idx] = 10;
                    i++;
                }
            } else if (carr[i] == 'D') {
                round[idx] *= round[idx];
            } else if (carr[i] == 'T') {
                round[idx] *= round[idx] * round[idx];
            } else if (carr[i] == '*') {
                if (idx > 0) round[idx - 1] *= 2;
                round[idx] *= 2;
            } else if (carr[i] == '#') {
                round[idx] *= -1;
            }
        }
        return round[0] + round[1] + round[2];
    }
}
