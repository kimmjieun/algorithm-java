package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18429 {
    static int n, k;
    static int[] arr;
    static boolean[] visit;
    static int ans;
    static int count=0;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visit = new boolean[n];
        ans = 0;
        back(500, 0);
        System.out.println(ans);

        result = new int[n];
        back2(0);
        System.out.println(count);

    }

    static void back(int sum, int idx) {
        if (idx == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i] && (sum + arr[i] - k) >= 500) {
                visit[i] = true;
                back(sum + arr[i] - k, idx + 1);
                visit[i] = false;
            }
        }
    }

    static void back2(int depth) {
        if(n==depth) {
            int sum=500;
            boolean flag=true;
            for(int r:result) {
//				System.out.print(r+" ");
                if(sum+r-k>=500) {
                    sum=sum+r-k;
                }else {
                    flag=false;
                    break;
                }
            }
//			System.out.println();
            if(flag) count++;
            return;
        }

        for(int i=0;i<n;i++) {
            if(!visit[i]) {
                visit[i]=true;
                result[depth]=arr[i];
                back2(depth+1);
                visit[i]=false;
            }
        }
    }
}