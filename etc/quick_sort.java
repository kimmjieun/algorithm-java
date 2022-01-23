
public class quick_sort {
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1); // 배열을 받으면 시작 위치와 끝위치를 정해준다.
    }

    private static void quickSort(int[] arr, int start, int end) { // 시작위치와 끝위치를 받아온다
        int part2 = partition(arr, start, end); // 파티션을 나누고 오른쪽 방의 첫번째 값을 반환한다
        if (start < part2 - 1) { // 왼쪽 파티션
            quickSort(arr, start, part2 - 1);
        }
        if (part2 < end) { // 오른쪽 파티션
            quickSort(arr, part2, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }


}