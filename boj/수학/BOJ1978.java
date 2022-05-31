package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt=0;
        for(int i=0;i<n;i++){
            if(isPrime(Integer.parseInt(st.nextToken()))){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
    static boolean isPrime(int n){
        if(n==0 || n==1) return false;

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
