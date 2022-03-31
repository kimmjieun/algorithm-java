package 레벨1;

import java.util.*;

public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {

        ArrayList<Integer> list = new ArrayList<>();

        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0)
                list.add(arr[i]);
        }

        if (list.size() == 0) {
            list.add(-1);
        }


        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }
}
