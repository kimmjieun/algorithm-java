package 레벨1.다시풀문제;

import java.util.Arrays;

// 그리디
public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; //잃어버린 학생들 제외하곤 체육복 가져옴
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++; //lost[i]==reserve[j] 이 아이 숫자 증가
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                    // -1로 변경해서 제외시킴
                }
            }
        }

        // 도난당한 학생에게 체육복 빌려주는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if ((lost[i] - 1 == reserve[j]) || (lost[i] + 1 == reserve[j])) {
                    answer++; // ㅇㅇ
                    reserve[j] = -1;// -1로 변경해서 제외
                    break;
                }
            }
        }
        return answer;
    }
}
