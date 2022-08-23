package 레벨2.완전탐색;


class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int index = 0;
        for (int i = 3; i < brown / 2; i++) {
            if ((i - 2) * ((brown - i * 2) / 2) == yellow) {
                index = i;
                break;
            }
        }

        if (index > (brown - index * 2) / 2 + 2) {
            answer[0] = index;
            answer[1] = (brown - index * 2) / 2 + 2;
        } else {
            answer[0] = (brown - index * 2) / 2 + 2;
            answer[1] = index;
        }

        return answer;
    }
}