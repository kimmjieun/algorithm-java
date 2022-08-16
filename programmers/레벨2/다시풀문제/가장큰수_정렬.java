package 레벨2.다시풀문제;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수_정렬 {

    public String solution(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }

        });

        // 이거 왜 하냐 ? 0값이 중복일 경우 {0,0,0}
        if (arr[0].equals("0")) {
            return "0";
        }

        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }

        return s;
    }
}
