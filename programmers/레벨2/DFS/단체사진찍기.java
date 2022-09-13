package 레벨2.DFS;


class 단체사진찍기 {
    public int answer = 0;
    public boolean visit[] = new boolean[8];
    public String[] arr = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public int solution(int n, String[] data) {
        back(0, data, "");

        return answer;
    }

    public void back(int depth, String[] data, String s) {
        if (depth == 8) {
            for (String d : data) {
                char c1 = d.charAt(0);
                char c2 = d.charAt(2);
                char c3 = d.charAt(3);
                int dist = Math.abs(s.indexOf(c1) - s.indexOf(c2)) - 1; // -1안해줘서 헤맴
                int num = d.charAt(4) - '0';
                boolean flag = false;
                if (c3 == '=') {
                    if (dist == num) flag = true;
                } else if (c3 == '>') {
                    if (dist > num) flag = true;
                } else if (c3 == '<') {
                    if (dist < num) flag = true;
                }
                if (!flag) return;
            }
            answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                back(depth + 1, data, s+arr[i]);
                visit[i] = false;
            }
        }
    }
}
