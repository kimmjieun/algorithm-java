package 레벨2.해시;

import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {

        TreeMap<String, Integer> totalTime = new TreeMap<>();
        Map<String, String> startTime = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] input = records[i].split(" ");

            if (input[2].equals("IN")) {
                startTime.put(input[1], input[0]);
            } else {
                String[] start = startTime.get(input[1]).split(":");
                String[] end = input[0].split(":");
                int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
                int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
                totalTime.put(input[1], totalTime.getOrDefault(input[1], 0) + hour * 60 + minute);
                startTime.remove(input[1]);
            }

        }

        for (String key : startTime.keySet()) {
            String[] start = startTime.get(key).split(":");
            int hour = 23 - Integer.parseInt(start[0]);
            int minute = 59 - Integer.parseInt(start[1]);

            totalTime.put(key, totalTime.getOrDefault(key, 0) + hour * 60 + minute);
        }

        int[] answer = new int[totalTime.size()];
        int i = 0;
        for (String key : totalTime.keySet()) {
            int sum = totalTime.get(key);
            if (sum > fees[0]) {
                answer[i] += fees[1];
                answer[i] += ((sum - fees[0]) / fees[2]) * fees[3];
                if ((sum - fees[0]) % fees[2] != 0) answer[i] += fees[3];
            } else {
                answer[i] = fees[1];
            }
            i++;
        }
        return answer;
    }

}