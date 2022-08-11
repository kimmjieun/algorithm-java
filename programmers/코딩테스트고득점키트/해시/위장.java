package 코딩테스트고득점키트.해시;

import java.util.*;

public class 위장 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 방법 1) value 목록을 리스트로 만들어 밸류리스트로 사용
        List<Integer> list = new ArrayList<>(map.values());
        int answer = 1;
        for (Integer i : list) {
            answer *= i + 1;
        }

        // 방법 2) keySet으로 value를 가져오는 방법
//        for(String key :map.keySet()){
//            answer*=(map.get(key)+1);
//        }

        return answer - 1;
    }
}
