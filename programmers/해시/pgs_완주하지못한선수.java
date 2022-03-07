package 해시;

import java.util.*;

public class pgs_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        String answer = "";
        int i;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                break;
            }
        }
        return participant[i];

    }
}
