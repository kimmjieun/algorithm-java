package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String s = br.readLine();
            if(s.equals("END")) break;
            StringBuilder sb = new StringBuilder();
            System.out.println(sb.append(s).reverse());
        }
    }
}
