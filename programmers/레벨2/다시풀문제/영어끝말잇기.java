package 레벨2.다시풀문제;


import java.util.*;

class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        int i;

        set.add(words[0]);
        for (i = 1; i < words.length; i++) {
            if (words[i].length() == 1) break;
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) break;
            if (set.contains(words[i])) break;
            set.add(words[i]);
        }

        answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
        answer[1] = (int) Math.ceil((double) (i + 1) / n);
        if (i == words.length) {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}