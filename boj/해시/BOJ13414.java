package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                set.remove(s);
            }
            set.add(s);

        }
//        ArrayList<String> result = new ArrayList<>(set);
//        for (int i = 0; i < k; i++) {
//            System.out.println(result.get(i));
//        } // 	런타임 에러 (IndexOutOfBounds)

        Iterator iter = set.iterator();
        int cnt=k;
        while(iter.hasNext()){
            System.out.println(iter.next());
            cnt--;
            if(cnt==0) break;
        }
    }
    // 시간초과
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int k = Integer.parseInt(st.nextToken());
//        int l = Integer.parseInt(st.nextToken());
//
////        HashMap<String, Integer> map = new HashMap<>();
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < l; i++) {
//            String s = br.readLine();
//            list.add(s);
//        }
//
//        for (int i = 0; i < list.size()-1; i++) {
//            for(int j=i+1;j<list.size();j++){
//                if(list.get(i).equals(list.get(j))){
//                    list.remove(i);
//                    break;
//                }
//            }
//        }
//
//        for(int i=0;i<k;i++){
//            System.out.println(list.get(i));
//        }
//    }
}
