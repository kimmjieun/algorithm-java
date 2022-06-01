package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    ||(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                str+=s.charAt(i);
            }
        }
//        System.out.println(str);
        String keyword = br.readLine();
        boolean flag = false;
        for (int i = 0; i < str.length() - keyword.length() + 1; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                if (str.charAt(i + j) == keyword.charAt(j)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
