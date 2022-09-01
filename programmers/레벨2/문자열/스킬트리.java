package 레벨2.문자열;


class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            String tmpSkill = skillTree;
            for (int i = 0; i < skillTree.length(); i++) {
                String s = skillTree.substring(i, i + 1);
                if (!skill.contains(s)) {
                    tmpSkill = tmpSkill.replace(s, "");
                }
            }
            System.out.println(tmpSkill);

            if (skill.indexOf(tmpSkill) == 0) answer++;


        }

        return answer;
    }
}
