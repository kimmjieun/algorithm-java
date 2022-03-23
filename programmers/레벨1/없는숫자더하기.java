package 레벨1;

public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int n : numbers) {
            answer -= n;
        }

        // // 오래걸림
        // int answer=0;
        // for(int i=0;i<10;i++){
        //     if(!contains(numbers,i)){
        //         answer+=i;
        //     }
        // }

        return answer;
    }
    // 다른 방안
    // public boolean contains(final int[] arr, final int key) {
    //     return Arrays.stream(arr).anyMatch(i -> i == key);
    // }
    // 안됨
    //   public boolean contains(final int[] arr, final int key) {
    //     return Arrays.asList(arr).contains(key);
    // }
}
