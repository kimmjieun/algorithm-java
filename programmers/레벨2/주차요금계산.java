package 레벨2;

import java.util.*;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, String> map = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();

        for(int i = 0; i < records.length; i++){
            feeMap.put(records[i].split(" ")[1], 0);
        }

        for(int i = 0; i < records.length; i++){
            String[] infos = records[i].split(" ");

            if(map.containsKey(infos[1])){
                String[] inTime = map.remove(infos[1]).split(":");
                String[] outTime = infos[0].split(":");

                int hour = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
                int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

                feeMap.replace(infos[1], feeMap.get(infos[1]) + 60 * hour + minute);

            }else{
                map.put(infos[1], infos[0]); // 차 번호, 시간
            }
        }

        for(String key : map.keySet()){
            String[] inTime = map.get(key).split(":");

            int hour = 23 - Integer.parseInt(inTime[0]);
            int minute = 59 -Integer.parseInt(inTime[1]);

            feeMap.replace(key, feeMap.get(key) + 60 * hour + minute);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList(feeMap.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return Integer.parseInt(o1.getKey()) > Integer.parseInt(o2.getKey())?1 :
                    Integer.parseInt(o1.getKey()) < Integer.parseInt(o2.getKey())?-1 : 0;
        });


        answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++){
            if(list.get(i).getValue() > fees[0]){
                answer[i] = fees[1] + (int) Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3];
            }else{
                answer[i] = fees[1];
            }
        }

        return answer;
    }

    public int[] solution2(int[] fees, String[] records) {


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