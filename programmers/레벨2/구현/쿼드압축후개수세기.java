package 레벨2.구현;


class 쿼드압축후개수세기 {
    int n;

    public int[] solution(int[][] arr) {
        n = arr.length;
        boolean[][] visit = new boolean[arr.length][arr.length];

        int zero = 0;
        int one = 0;
        for (int k = 0; k < arr.length; k++) {
            for (int u = 0; u < arr.length; u++) {
                if (arr[k][u] == 0) zero++;
                else if (arr[k][u] == 1) one++;
            }
        }

        if (arr[0][0] == 0 && zero == n * n) return new int[]{1, 0};
        else if (arr[0][0] == 1 && one == n * n) return new int[]{0, 1};


        while (n != 2) {
            // 덩어리 자르기, 압축하기
            for (int i = 0; i < arr.length; i += n / 2) {
                for (int j = 0; j < arr.length; j += n / 2) {
                    int tmp = arr[i][j];
                    // System.out.println(i+" "+j);

                    if (check01(i, j, arr, n / 2) && !visit[i][j]) {
                        arr[i][j] = tmp;
                        visit[i][j] = true;
                    }
                    // for(int k=0;k<arr.length;k++){
                    //      for(int u=0;u<arr.length;u++){
                    //         System.out.print(arr[k][u]);
                    //      }
                    //      System.out.println();
                    //    }
                    // System.out.println();
                }
            }
            // 쪼개기
            n = n / 2;

        }

        // 0의 개수, 1의 개수 세기
        int[] answer = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) answer[0]++;
                else if (arr[i][j] == 1) answer[1]++;
            }
        }
        return answer;
    }

    // 덩어리안 압축되는지 확인
    public boolean check01(int x, int y, int[][] arr, int size) {
        boolean flag = true;
        int num = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (num != arr[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    arr[i][j] = 2;
                }
            }
        }

        return flag;
    }
}
