package 레벨2.해시;

import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String r : record) {
            String[] input = r.split(" ");
            if (input[0].equals("Enter")) {
                map.put(input[1], input[2]);
                list.add(input[1] + " " + "Enter");
            } else if (input[0].equals("Leave")) {
                list.add(input[1] + " " + "Leave");
            } else if (input[0].equals("Change")) {
                map.put(input[1], input[2]);
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++) {
            String[] result = list.get(i).split(" ");
            if (result[1].equals("Enter")) {
                answer[i] = map.get(result[0]) + "님이 들어왔습니다.";
            } else {
                answer[i] = map.get(result[0]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }

}
