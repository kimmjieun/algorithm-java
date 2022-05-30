package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= s.length(); i++) {
            int j;
            for (j = 0; j < s.length() - i; j++) {
                set.add(s.substring(j, j + i));
//                System.out.println(s.substring(j, j + i));
            }
            set.add(s.substring(j));
//            System.out.println(s.substring(j));
        }
        System.out.println(set.size());
    }
}
