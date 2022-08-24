package 레벨2.다시풀문제;

import java.util.HashSet;
        import java.util.LinkedList;

public class 수식최대화_dfs {
    static long maxAnswer;
    static LinkedList<Long> numList;
    static LinkedList<Character> opList, opSetList;
    static HashSet<Character> opSet;

    public static void main(String[] args) {
        System.out.println(solution("50*6-3*2"));
        System.out.println(solution("100-200*300-500+20"));
    }

    public static long solution(String exp) {
        // 가장 큰 연산의 결과를 담을 변수
        maxAnswer = Long.MIN_VALUE;
        // 수식에서 피연산자만 순서대로 담은 리스트
        numList = new LinkedList<Long>();
        // 수식에서 연산자만 순서대로 담은 리스트
        opList = new LinkedList<Character>();
        // 수식에서 나온 연산자의 종류만 담은 리스트
        opSetList = new LinkedList<Character>();
        // 수식에서 나온 연산자 집합
        opSet = new HashSet<Character>();

        // 수식에서 연산자와 피연산자 구분
        splitExp(exp);

        // 연산자 우선순위응 순열로 구함 -> 뽑힌것 토대로 계산
        getOperatorPerm(new LinkedList<Character>(), new boolean[opSetList.size()]);

        return maxAnswer;
    }

    public static void getOperatorPerm(LinkedList<Character> list, boolean[] picked) {
        if (list.size() == opSetList.size()) {
            // 계산 시작하기 위해 연산자와 피연산자 리스트 원본에서 복사
            LinkedList<Long> copyNumList = new LinkedList<Long>(numList);
            LinkedList<Character> copyOpList = new LinkedList<Character>(opList);

            // 연산자 우선순위대로 계산
            for (char flagOp : list) {
                for (int i = 0; i < copyOpList.size(); i++) {
                    // 우선순위에 해당되지 않은 연산자가 아니면 통과
                    if (copyOpList.get(i) != flagOp)
                        continue;

                    long l1 = copyNumList.get(i);
                    long l2 = copyNumList.get(i + 1);

                    // 계산한 피연산자, 피연산자 리스트에서 제거
                    // 앞에 있는 피연산자부터 지우면 i + 1에서 범위 초과 일어남
                    copyNumList.remove(i + 1);
                    copyNumList.remove(i);
                    // 계산한 연산자, 연산자 리스트에서 제거
                    copyOpList.remove(i);

                    // 계산 결과, 연산 진행한 번호에 넣음
                    copyNumList.add(i, calcNumber(l1, l2, flagOp));
                    // 연산자가 하나 줄었기 때문에 반복문 범위 하나 줄여줌
                    i--;
                }
            }

            // 수식 계산한 결과 가져옴 : 음수일 결루 절댓값으로 계산
            long flagAnswer = Math.abs(copyNumList.get(0));

            maxAnswer = Math.max(maxAnswer, flagAnswer);
            return;
        }

        // 수식에 나온 피연산자 종류 개수대로 순열 구함
        for (int i = 0; i < opSetList.size(); i++) {
            if (!picked[i]) {
                picked[i] = true;
                list.add(opSetList.get(i));

                getOperatorPerm(list, picked);

                picked[i] = false;
                list.removeLast();
            }
        }
    }

    public static void splitExp(String exp) {
        char[] arr = exp.toCharArray();
        StringBuilder numberStr = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            // 연산자일 경우
            if (arr[i] == '*' || arr[i] == '+' || arr[i] == '-') {
                // 그동안 쌓아온 피연산자 문자열 숫자로 변환
                long number = Long.valueOf(numberStr.toString());

                // 피연산자 리스트에 넣음
                numList.add(number);
                // 연산자 순서 리스트에 넣음
                opList.add(arr[i]);
                // 수식에 나온 연산자 종류 파악하기 위해 집합에 넣음
                opSet.add(arr[i]);
                // 연산자 이후 나오는 새로운 피연산자 파악 위해 초기화
                numberStr = new StringBuilder();
            } else {
                // 피연산자일 경우 문자열 더함
                numberStr.append(arr[i]);
            }
        }

        // 마지막에 나옴 피연산자 계산해서 리스트에 넣음
        numList.add(Long.valueOf(numberStr.toString()));

        // 연산자 종류 리스트로 생성
        opSetList = new LinkedList<>(opSet);
    }

    public static long calcNumber(long l1, long l2, char op) {
        long result = 0;
        switch (op) {
            case '*':
                result = l1 * l2;
                break;
            case '+':
                result = l1 + l2;
                break;
            default:
                result = l1 - l2;
                break;
        }

        return result;
    }

}

