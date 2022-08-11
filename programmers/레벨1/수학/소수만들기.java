package 레벨1.수학;

public class 소수만들기 {
    public boolean[] visit;
    public int[] arr;
    public int sum;
    public int answer = 0;

    public int solution(int[] nums) {
        // 방법1
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    int num = nums[i] + nums[j] + nums[k]; //값을 담아
                    if (isPrime(num)) {
                        answer++;
                    }
                }
            }

        }
        // 방법2
        // visit=new boolean[nums.length];
        // arr = new int[3];
        // dfs(0,nums,0);

        return answer;
    }

    public void dfs(int depth, int[] nums, int start) {
        if (depth == 3) {
            for (int val : arr) {
                sum += val;
            }
            System.out.println(sum);
            if (isPrime(sum)) {
                answer++;
            }

            sum = 0;
            return;
        }
        for (int i = start; i < visit.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = nums[i];
                dfs(depth + 1, nums, i);
                visit[i] = false;
            }
        }
    }

    public boolean isPrime(int x) {
        if (x == 0 || x == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }
}
