package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ9536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<String> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }

            while (true) {
                String input = br.readLine();
                if(input.equals("what does the fox say?")) break;
                String sound = input.split(" ")[2];
                while(list.contains(sound)){
                    list.remove(sound);
                }

            }
            for(String s : list){
                sb.append(s+" ");
            }
            System.out.println(sb);
        }
    }
}
