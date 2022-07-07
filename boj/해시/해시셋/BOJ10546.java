package 해시.해시셋;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class BOJ10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n * 2 - 1; i++) {
            String name = br.readLine();

            if (map.containsKey(name)) {
                map.remove(name);
            } else {
                map.put(name, 1);
            }
        }
        for (String key : map.keySet()) {
            System.out.println(key);
        }

    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        HashSet<String> set  = new HashSet<>();
//        for(int i=0;i<n*2-1;i++){
//            String name = br.readLine();
//            if(set.contains(name)){
//                set.remove(name);
//            }else{
//                set.add(name);
//            }
//        }
//
//        Iterator iter = set.iterator();
//        System.out.println(iter.next());
//    }
}
