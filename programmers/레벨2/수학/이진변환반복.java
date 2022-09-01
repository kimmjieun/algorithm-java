package 레벨2.수학;

class 이진변환반복 {
    public int[] solution(String s) {
        int cnt = 0;
        int zeronum = 0;
        while (!s.equals("1")) {
            String newS = s.replace("1", "");
            int len = newS.length();// 0의 개수
            s = Integer.toString(s.length() - len, 2);// 0의 개수를 이진법으로
            cnt++;
            zeronum += len;
            // System.out.println("이진: "+s);
            // System.out.println("0의갯수: "+len);
            // System.out.println();
        }
        int[] answer = new int[2];
        answer[0] = cnt;
        answer[1] = zeronum;
        return answer;
    }
}
