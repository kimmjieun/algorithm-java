package 레벨1.해시;
import java.util.*;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0;i<completion.length;i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }

        return participant[participant.length-1];

    }
}
