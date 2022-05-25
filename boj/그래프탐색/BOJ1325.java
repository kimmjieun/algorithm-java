package 그래프탐색;

import java.io.*;
import java.util.*;

public class BOJ1325 {
    static int n,m;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visit;
    static int[] result;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0;i<=n;i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }
        result = new int[n+1];
        for(int i=1;i<=n;i++) {
            visit = new boolean[n+1];
            bfs(i);
        }
        for(int i=1;i<=n;i++) {
            if(result[i]==max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x]=true;
        int count=1;
        while(!q.isEmpty()) {
            int t = q.poll();
            for(int v:list.get(t)) {
                if(!visit[v]) {
                    visit[v]=true;
                    q.add(v);
                    count++;
                }
            }
        }
        result[x]=count;
        max = Math.max(max, count);

    }
}
