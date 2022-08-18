package 레벨2.다시풀문제;

public class 양궁대회_dfs {

    static int max;
    static int[] answer;

    public int[] solution(int n, int[] info) {
        answer = new int[11];

        dfs(0, n, 0, new int[n], info);

        // max ==0이면 한번도 라이언이 이긴 적이 없음
        return max == 0 ? new int[]{-1} : answer;
    }

    // 중복조합 사용 11H10 = 184756
    public static void dfs(int start, int r, int idx, int[] result, int[] info) {
        if (idx == r) {
            int[] info2 = new int[11];
            // 과녁점수를 어피치와 같이 과녁 점수 맞춘 개수로 표현
            for (int score : result) {
                info2[10 - score]++;
            }
            int ryan = 0;
            int apeach = 0;

            for (int i = 0; i < 11; i++) {
                //info[0]=10점, info[1] = 9점 맞추기 위해 score 계산
                int score = 10 - i;
                // 라이언이 이긴 경우
                if (info2[i] > info[i]) {
                    ryan += score;
                }
                // 어피치가 이긴 경우
                else if (info2[i] < info[i]) {
                    apeach += score;
                }
                // 과녁에 맞추고 어피치와 라이언이 같은 갯수를 쏜 경우
                else if (info[i] != 0 && info2[i] == info[i]) {
                    apeach += score;
                }
            }

            if (ryan - apeach > max) {
                max = ryan - apeach;
                answer = info2;
            }
            return;
        }
        for (int i = start; i < 11; i++) {
            // 라이언이 쏜 과년 점수 저장
            result[idx] = i;
            dfs(i, r, idx + 1, result, info);
        }
    }
}