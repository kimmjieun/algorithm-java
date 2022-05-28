package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        //list 시간초과
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        HashSet<String> list =new HashSet<>();
        for(int i=0;i<n;i++){
            list.add(br.readLine());
        }

        ArrayList<String> result =new ArrayList<>();
        for(int i=0;i<m;i++){
            String s = br.readLine();
            if(list.contains(s)){
                result.add(s);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(String s : result){
            System.out.println(s);
        }
    }
}
