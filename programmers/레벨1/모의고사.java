package 레벨1;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {

        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a1[i % 5]) {
                cnt1++;
            }
            if (answers[i] == a2[i % 8]) {
                cnt2++;
            }
            if (answers[i] == a3[i % 10]) {
                cnt3++;
            }
        }

        int max = Math.max(Math.max(cnt1, cnt2), cnt3);
        ArrayList<Integer> list = new ArrayList<>();
        if (max == cnt1) {
            list.add(1);
        }
        if (max == cnt2) {
            list.add(2);
        }
        if (max == cnt3) {
            list.add(3);
        }

        Collections.sort(list);
        int[] answer = new int[list.size()];
        int i = 0;
        for (Integer val : list) {
            answer[i++] = val;
        }

        return answer;
    }

}
