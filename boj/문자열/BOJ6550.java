package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);

            String s1 = st.nextToken();
            String s2 = st.nextToken();
            int idx=0;
            for(int i=idx;i<s2.length();i++) {
                if (s1.charAt(idx) == s2.charAt(i)) {
                    idx++;
                }
                if (idx == s1.length()) break;
            }
            if(idx==s1.length()) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
