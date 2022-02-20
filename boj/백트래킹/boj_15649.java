package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15649 {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static boolean[] visit;
    static int[] arr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[N];
        dfs(N,M,0);
        System.out.println(sb.toString());



    }

    private static void dfs(int N, int M, int depth) {
        if(depth==M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth]=i+1;
                dfs(N,M,depth+1);
                visit[i] =false;
            }
        }
    }
}
