import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {


        HashMap<String, String> cars = new HashMap<>(); // 주차시간 입출 기록
        Map<String, Integer> result = new TreeMap<>(); // 주차시간 누적
        for (int i = 0; i < records.length; i++) {
            String[] tmp = records[i].split(" ");

            if (tmp[2].equals("IN")) {
                cars.put(tmp[1], tmp[0]);// in 인경우 cars에 넣기
            } else {
                // out인 경우 기존에 들어가 있는 In시간을 가져온다
                String[] timeIn = cars.get(tmp[1]).split(":");
                cars.remove(tmp[1]);
                String[] timeOut = tmp[0].split(":");
                int min = 0;// 분계산
                min += (Integer.parseInt(timeOut[0]) - Integer.parseInt(timeIn[0])) * 60;
                min += (Integer.parseInt(timeOut[1]) - Integer.parseInt(timeIn[1]));
                if (result.containsKey(tmp[1])) {
                    result.replace(tmp[1], result.get(tmp[1]) + min);
                } else {
                    result.put(tmp[1], min);
                }
            }
        }


        // Out기록없는 차
        for (String car : cars.keySet()) {
            String[] timeIn = cars.get(car).split(":");
            int min = 0;
            min += (23 - Integer.parseInt(timeIn[0])) * 60;
            min += 59 - Integer.parseInt(timeIn[1]);
            if (result.containsKey(car)) {
                result.replace(car, result.get(car) + min);
            } else {
                result.put(car, min);
            }
        }
        int[] answer = new int[result.size()];
        int i = 0;
        for (String key : result.keySet()) {
            int totalMin = result.get(key);
            int fee = 0;
            if (totalMin >= fees[0]) {
                totalMin -= fees[0];
                fee = fees[1];
            } else {
                totalMin = 0;
                fee = fees[1];
            }
            if (totalMin > 0) {
                if (totalMin % fees[2] == 0) {
                    fee += totalMin / fees[2] * fees[3];
                } else {
                    fee += (totalMin / fees[2] + 1) * fees[3];
                }
            }
            answer[i++] = fee;
        }


        return answer;
    }

}