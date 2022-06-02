package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ6996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            if (s1.length() != s2.length()) {
                System.out.println(s1 + " & " + s2 + " are NOT anagrams.");
            } else {
                char[] c1 = s1.toCharArray();
                char[] c2 = s2.toCharArray();
                Arrays.sort(c1);
                Arrays.sort(c2);
                boolean flag = false;
                for (int i = 0; i < c1.length; i++) {
                    if (c1[i] != c2[i]) {
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    System.out.println(s1 + " & " + s2 + " are NOT anagrams.");
                else
                    System.out.println(s1 + " & " + s2 + " are anagrams.");

            }

        }
    }
}
