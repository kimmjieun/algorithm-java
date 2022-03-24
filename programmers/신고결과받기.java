import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 신고결과받기 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(solution(id_list, report, 2));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        // String은 HashSet<String>에게 신고당했다
        // key - 신고당한 사람, value - 신고한 사람
        Map<String, HashSet<String>> reportMemberList = new HashMap<>();
        Map<String, Integer> getMailCount = new HashMap<>(); // 신고한 사람에게 신고 당한 사람을 알리는 메일 갯수
        for (String id : id_list) {
            getMailCount.put(id, 0); // 사람마다 보낼 메일 개수를 0으로 초기화
            reportMemberList.put(id, new HashSet<>());
        }

        for (String rep : report) {
            String[] checkReport = rep.split(" ");
            reportMemberList.get(checkReport[1]).add(checkReport[0]); // 신고당한 사람(key)의 value에 신고한 사람을 추가

        }

        for (String key : reportMemberList.keySet()) { // 신고당한 사람들
            HashSet<String> reporters = reportMemberList.get(key); // 신고한 사람들 리스트 가져오기
            if (reporters.size() >= k) { // 신고한 사람들이 k 이상이면
                for (String reporter : reporters) { // 신고한 사람들
                    Integer getMail = getMailCount.get(reporter); // 신고한 사람의 갯수를 가져오기
                    getMailCount.put(reporter, getMail + 1); // 1 더해주기
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = getMailCount.get(id_list[i]); // 순서대로 출력
        }

        return answer;
    }
}
