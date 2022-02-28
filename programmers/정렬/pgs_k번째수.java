package 정렬;

import java.util.Arrays;

public class pgs_k번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(array, commands);

    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int w = 0;
        for (int x = 0; x < commands.length; x++) {
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            int[] newArr = new int[j - i + 1];
            int z = 0;
            for (int y = i - 1; y < j; y++) {
                newArr[z++] = array[y];
            }

            Arrays.sort(newArr);
//            System.out.println(newArr[k-1]);
            answer[w++] = newArr[k - 1];
        }
        return answer;
    }
}
