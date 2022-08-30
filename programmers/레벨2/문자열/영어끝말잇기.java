package 레벨2.문자열;


import java.util.*;

class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0)) {
                if (!set.contains(words[i])) {
                    set.add(words[i]);
                } else {
                    answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                    answer[1] = (i + 1) % n == 0 ? (i + 1) / n : (i + 1) / n + 1;
                    break;

                }
            } else {
                answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                answer[1] = (i + 1) % n == 0 ? (i + 1) / n : (i + 1) / n + 1;
                break;
            }
            if (i == words.length - 1) {
                return new int[]{0, 0};
            }
        }

        return answer;
    }
}