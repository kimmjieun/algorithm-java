package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1351 {
    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//        long n = Long.parseLong(st.nextToken());
//        int p = Integer.parseInt(st.nextToken());
//        int q = Integer.parseInt(st.nextToken());
//        HashMap<Long, Long> map = new HashMap<>();
//        map.put((long)0, (long)1);
//        for (long i = 1; i <= n; i++) {
//            map.put(i, map.get(i / p) + map.get(i / q));
//        }
//        System.out.println(map.get(n));
//    } // 	런타임 에러 (NumberFormat) -> long -> 메모리초과
    static HashMap<Long, Long> map = new HashMap<>();
    static int p, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        System.out.println(solve(n));
    }

    // 메모이제이션 하기 위해 함수처리로 구현한다.
    static long solve(long num) {
        if (num == 0) return 1;
        if (map.containsKey(num)) {
            return map.get(num);
        }

        map.put(num, solve(num / p) + solve(num / q));
        return map.get(num);
    }
}
