package 레벨2.DFS;


import java.util.*;

class 모음사전 {
    public List<String> list = new ArrayList<>();
    public String[] alpha = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        dfs(0, "");
        Collections.sort(list);
        answer = list.indexOf(word) + 1;
        return answer;
    }

    public void dfs(int index, String str) {
        if (index >= 5) {
            return;
        }
        for (int i = 0; i < alpha.length; i++) {
            list.add(str + alpha[i]);
            dfs(index + 1, str + alpha[i]);
        }
    }
}