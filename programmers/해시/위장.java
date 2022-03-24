package 해시;

import java.util.*;

public class 위장 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        int answer = 1;
        for (Integer i : list) {
            answer *= i + 1;
        }

        return answer - 1;
    }
}
