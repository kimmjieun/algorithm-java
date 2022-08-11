package 코딩테스트고득점키트.해시;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public int solution(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }

        if (set.size() >= nums.length / 2) {
            return nums.length / 2;
        } else {
            return set.size();
        }

    }
}
