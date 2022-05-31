package 레벨4;

// 패키지 지울것
// 파일명 바꿀것
// 변수명 바꿀것
// 유니온 파인드 이해할 것
// 설명할 수 있게끔 숙지할 것

import java.util.*;
public class 호텔방배정 {
    static HashMap<Long,Long> map = new HashMap<Long,Long>();

    public static long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        for(int i=0;i<n;i++){
            answer[i] = findEmptyRoom(room_number[i]);
        }
        return answer;
    }

    public static long findEmptyRoom(long room){
        if(!map.containsKey(room)){
            map.put(room, room+1);
            return room;
        }

        long nextRoom = map.get(room);
        long emptyRoom = findEmptyRoom(nextRoom);
        map.put(room, emptyRoom);
        return emptyRoom;
    }

    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};
        long[] result = solution(k, room_number);
        for (long num : result)
            System.out.print(num+" ");
    }
}

