package 정렬;

import java.util.*;

public class boj_2108 {

    public static int N;
    public static int[] array;

    public static int getAverage() {
        // 배열을 다 합해주는 stream
        double sum = Arrays.stream(array).sum();

        double avg = (double) sum / N;
        if (avg < 0) {
            // 반올림하는 Math.round함수
            return (int) Math.round(Math.abs(avg) * -1);
        } else {
            return (int) Math.round(avg);
        }
    }

    public static int countFreq() {
        Map<Integer, Integer> mp = new HashMap<>();

        if (N == 1) {
            return array[0];
        }
        for (int i = 0; i < N; i++) {
            if (mp.containsKey(array[i])) {
                mp.put(array[i], mp.get(array[i]) + 1);
            } else {
                mp.put(array[i], 1);
            }
        }
        int maxValue = Collections.max(mp.values());
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 가장 많이 나온 값
        for (Map.Entry<Integer, Integer> m : mp.entrySet()) {
            if (m.getValue() == maxValue) {
                arrayList.add(m.getKey());
            }
        }
        Collections.sort(arrayList);
        // 가장 많이 나온 값이 여러개일 경우 두번째로 작은 값
        if (arrayList.size() > 1)
            return arrayList.get(1);
        else // 가장 많이 나온 값이 하나면
            return arrayList.get(0);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scan.nextInt();
        }
        // 산술평균
        System.out.println(getAverage());
        Arrays.sort(array);
        // 중앙값
        System.out.println(array[N / 2]);
        // 최빈값
        System.out.println(countFreq());
        // 범위
        System.out.println(array[N - 1] - array[0]);
        scan.close();
    }


}
