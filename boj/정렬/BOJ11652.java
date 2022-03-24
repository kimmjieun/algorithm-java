package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BOJ11652 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            Long num =Long.parseLong(br.readLine());
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int max=0;
        // 맵 반복문 돌리는 방법
        ArrayList<Integer> list = new ArrayList<>(map.values());
        for(Integer val : list){
            if(max<val){
                max=val;
            }
        }

        PriorityQueue<Long> q = new PriorityQueue<>();
        // 밸류로 키 조회하기
        for(Long key :map.keySet()){
            if(max==map.get(key)){
                q.add(key);
            }
        }
        System.out.println(q.poll());

    }


}
