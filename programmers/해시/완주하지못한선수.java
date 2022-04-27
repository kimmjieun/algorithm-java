package 해시;

import java.util.*;

public class 완주하지못한선수 {
    // 방법 1) 해시를 사용해 푸는 방법
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String arg : participant) {
            map.put(arg, map.getOrDefault(arg, 0) + 1);
        }
        for (String arg : completion) {
            map.put(arg, map.get(arg) - 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0)
                return key;
        }
        return null;
    }

    // 방법 2) 해시를 사용하지 않고 푸는 방법
    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < participant.length - 1; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
        if (answer.equals("")) {
            answer = participant[participant.length - 1];
        }
        return answer;
    }

}
