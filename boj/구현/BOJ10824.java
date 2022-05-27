package 구현;

import java.util.*;
import java.io.*;

public class BOJ10824 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        String c = st.nextToken();
        String d = st.nextToken();
        System.out.println(Long.parseLong(a+b)+Long.parseLong(c+d));
    }
}
