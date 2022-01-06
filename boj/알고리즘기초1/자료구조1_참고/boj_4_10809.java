package 알고리즘기초1.자료구조1_참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10809번 알파벳 찾기
public class boj_4_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] count = new int[26];
        for(int i =0;i<count.length;i++){
            count[i]=-1;
        }


        String input = br.readLine();
        int sequence=0;
        for(int i = 0 ;i<input.length();i++){
            if(count[(int) input.charAt(i)-97]==-1){
                count[(int) input.charAt(i)-97] =sequence;
            }
            sequence++;
        }

        for(int i = 0;i<count.length;i++){
            sb.append(count[i]);
            sb.append(" ");
        }

        System.out.println(sb);

    }
}
