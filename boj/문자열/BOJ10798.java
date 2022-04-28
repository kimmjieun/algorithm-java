package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
        }

        String result = "";
        for (int i = 0; i < 15; i++) {

            if (arr[0].length() - 1 >= i) result += arr[0].charAt(i);

            if (arr[1].length() - 1 >= i) result += arr[1].charAt(i);

            if (arr[2].length() - 1 >= i) result += arr[2].charAt(i);

            if (arr[3].length() - 1 >= i) result += arr[3].charAt(i);

            if (arr[4].length() - 1 >= i) result += arr[4].charAt(i);
        }

        System.out.println(result);
    }
}
