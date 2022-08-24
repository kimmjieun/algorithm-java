package 레벨2.다시풀문제;


import java.util.*;

class 모음사전_dfs {
    public String[] mo = {"A", "E", "I", "O", "U"};
    public ArrayList<String> list;

    public int solution(String word) {
        list = new ArrayList<>();
        int answer = 0;
        back(0, "");
        Collections.sort(list);
        answer = list.indexOf(word) + 1;
        return answer;
    }

    public void back(int index, String s) {
        if (index >= 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            list.add(s + mo[i]);
            back(index + 1, s + mo[i]);
        }
    }
}