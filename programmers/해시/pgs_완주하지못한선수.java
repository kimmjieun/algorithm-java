package 해시;

import java.util.*;

public class pgs_완주하지못한선수 {
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
//    public String solution(String[] participant, String[] completion) {
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        String answer = "";
//        int i;
//        for (i = 0; i < completion.length; i++) {
//            if (!participant[i].equals(completion[i])) {
//                break;
//            }
//        }
//        return participant[i];
//
//    }
}
