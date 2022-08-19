package 레벨2.기타;

import java.util.*;

public class 최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(arr);
        answer = String.valueOf(arr[0] + " " + arr[arr.length - 1]);
        return answer;
    }
}
