package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            Character c= s.charAt(i);
            if(c>='a' &&c<='z'){
                sb.append((char)(c-32));
            }else{
                sb.append((char)(c+32));
            }
        }
        System.out.println(sb);
    }
}
