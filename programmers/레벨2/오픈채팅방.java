package 레벨2;

import java.util.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {


        Queue<String[]> q = new LinkedList<>();
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");

            if (!str[0].equals("Change")) {
                q.add(new String[]{str[0], str[1]});
            }

            if (str[0].equals("Change")) {
                map.replace(str[1], str[2]);
            }

            if (str[0].equals("Enter")) {
                map.put(str[1], str[2]);
            }

        }

        String[] answer = new String[q.size()];
        int i = 0;
        while (!q.isEmpty()) {
            String[] str = q.poll();

            if (str[0].equals("Enter")) {
                answer[i++] = map.get(str[1]) + "님이 들어왔습니다.";
            } else {
                answer[i++] = map.get(str[1]) + "님이 나갔습니다.";
            }
        }


        return answer;
    }

//    public String[] solution(String[] record) {
//
//        // 기록을 남길 list
//        List<String> result = new ArrayList<>();
//
//        // <id, nickname>
//        HashMap<String, String> map = new HashMap<>();
//
//        for (int i = 0; i < record.length; i++) {
//            String[] str = record[i].split(" ");
//
//            if (str[0].equals("Enter")) {
//                map.put(str[1], str[2]);
//                result.add(str[1] + "님이 들어왔습니다.");
//            }
//
//            if (str[0].equals("Leave")) {
//                result.add(str[1] + "님이 나갔습니다.");
//            }
//
//
//            if (str[0].equals("Change")) {
//                map.put(str[1], str[2]); // 변경
//            }
//
//        }
//
//        String[] answer = new String[result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            // id만 빼오기 위해 0부터 indexOf("님")까지 substring
//            int idx = result.get(i).indexOf("님");
//            String id = result.get(i).substring(0, idx);
//            answer[i] = map.get(id) + result.get(i).substring(idx);
//        }
//
//        return answer;
//    }
}
