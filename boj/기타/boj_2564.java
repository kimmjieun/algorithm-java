package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int[][] locations = new int[n+1][2];
        for(int i=0; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            locations[i][0] = Integer.parseInt(st.nextToken());
            locations[i][1] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int direc = locations[n][0];
        int num = locations[n][1];
        if(direc == 1) { //동근이가 상에 있을 때
            for(int i=0; i<n; i++) {
                if(locations[i][0] == 1) {
                    cnt += Math.abs(locations[i][1] - num);
                }else if(locations[i][0] == 2) {
                    cnt += Math.min(h + locations[i][1] + num, h + (w - locations[i][1]) + (w - num));
                }else if(locations[i][0] == 3) {
                    cnt += locations[i][1] + num;
                }else {
                    cnt += (h - locations[i][1]) + num;
                }
            }
        }
        else if(direc == 2){ //하
            for(int i=0; i<n; i++) {
                if(locations[i][0] == 1) {
                    cnt += Math.min(h + locations[i][1] + num, h + (w - locations[i][1]) + (w - num));
                }else if(locations[i][0] == 2) {
                    cnt += Math.abs(locations[i][1] - num);
                }else if(locations[i][0] == 3) {
                    cnt += (h - locations[i][1]) + num;
                }else {
                    cnt += (h - locations[i][1]) + (w - num);
                }
            }
        }
        else if(direc == 3) { //좌
            for(int i=0; i<n; i++) {
                if(locations[i][0] == 1) {
                    cnt += num + locations[i][1];
                }else if(locations[i][0] == 2) {
                    cnt += (h - num) + locations[i][1];
                }else if(locations[i][0] == 3) {
                    cnt += Math.abs(locations[i][1] - num);
                }else {
                    cnt += Math.min(w + locations[i][1] + num, w + (h - locations[i][1]) + (h - num));
                }
            }
        }
        else if(direc == 4) { //우
            for(int i=0; i<n; i++) {
                if(locations[i][0] == 1) {
                    cnt += num + (w - locations[i][1]);
                }else if(locations[i][0] == 2) {
                    cnt += (h - num) + (w - locations[i][1]);
                }else if(locations[i][0] == 3) {
                    cnt += Math.min(w + locations[i][1] + num, w + (h - locations[i][1]) + (h - num));
                }else {
                    cnt += Math.abs(locations[i][1] - num);
                }
            }
        }

        System.out.println(cnt);
    }

}