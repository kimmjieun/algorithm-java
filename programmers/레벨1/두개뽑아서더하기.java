package 레벨1;

import java.util.*;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int i = 0;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            answer[i++] = (int) it.next();
        }
        Arrays.sort(answer);
        return answer;
    }
}
