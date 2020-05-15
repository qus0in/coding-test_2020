import java.util.HashMap;

class Solution {
    public String solution(final String[] participant, final String[] completion) {
        // 해시 맵 사용 (K-V)
        // https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
        // HashMap 객체 생성 (키는 문자열, 값은 정수)
        final HashMap<String, Integer> completionTable = new HashMap<String, Integer>();
        // 향상된 for문 (forEach) 사용하여 완주자 배열 순회
        for (final String v : completion) {
            // System.out.println(v);
            // key가 존재하면
            if (completionTable.containsKey(v)) {
                // 기존에 존재하던 값에 +1 해서 카운트
                completionTable.put(v, completionTable.get(v) + 1);
            } else {
                // 아니면 1을 넣어줌
                completionTable.put(v, 1);
            }
        }
        // System.out.println(completionTable);
        // 향상된 for문 (forEach) 사용하여 참가자 배열 순회
        for (final String v : participant) {
            // key가 존재하면
            if (completionTable.containsKey(v)) {
                // 값이 0 (이미 체크 끝남)
                if (completionTable.get(v) == 0) {
                    // 비완주자이므로 return
                    return v;
                } else {
                    // 체크하면서 수를 줄여줌
                    completionTable.put(v, completionTable.get(v) - 1);
                }
            } else {
                // 아니면 비완주자이므로 return
                return v;
            }
        }
        return "";
    }
}