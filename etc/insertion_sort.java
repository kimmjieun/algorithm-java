public class insertion_sort {
    public static void insertion_sort(int[] a, int size) {
        for (int i = 1; i < size; i++) {
            // 타겟넘버
            int target = a[i];

            int j = i - 1;
            // 타겟이 이전 원소보다 크기 전까지 반복
            while (j >= 0 && target < a[j]) {
                a[j + 1] = a[j]; // 이전 원소를 한칸씩 뒤로 미룬다
                j--;
            }

            // 위 반복문에서 탈출하는 경우는 앞의 원소가 타겟보다 작다는 의미
            // 타겟원소는 j번째 원소 뒤에 와야한다
            // 그러므로 타겟은 j+1에 위치
            a[j + 1] = target;
        }
    }
}



