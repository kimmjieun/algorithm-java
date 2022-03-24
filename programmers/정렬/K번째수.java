package 정렬;

import java.util.ArrayList;
import java.util.Arrays;

public class K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> list = new ArrayList<>();
        String s = "";

        int w = 0;
        for (int z = 0; z < commands.length; z++) {
            int i = commands[z][0];
            int j = commands[z][1];
            int k = commands[z][2];
            int[] newArr = new int[j - i + 1];
            for (int x = 0; x < newArr.length; x++) {
                newArr[x] = array[i - 1 + x];
            }
            Arrays.sort(newArr);

            answer[w++] = newArr[k - 1];

        }

        return answer;
    }
}
