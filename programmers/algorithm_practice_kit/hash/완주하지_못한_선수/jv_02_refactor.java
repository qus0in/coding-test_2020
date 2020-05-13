import java.util.HashMap;
// import java.util.stream.Stream;

class Solution {
    public String solution(final String[] participant, final String[] completion) {
        final HashMap<String, Integer> completionTable = new HashMap<String, Integer>();
        for (final String v : completion) {
            // HashMap의 getOrDefault 메소드를 사용해서 키가 없으면 0 값을 불러오게 함
            completionTable.put(v, completionTable.getOrDefault(v, 0) + 1);
        }
        // Stream 구문을 사용할 수도 있으나, 성능은 for문에 비해 낮아짐
        // https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
        // https://homoefficio.github.io/2016/06/26/for-loop-%EB%A5%BC-Stream-forEach-%EB%A1%9C-%EB%B0%94%EA%BE%B8%EC%A7%80-%EB%A7%90%EC%95%84%EC%95%BC-%ED%95%A0-3%EA%B0%80%EC%A7%80-%EC%9D%B4%EC%9C%A0/
        // Stream.of(completion).forEach(v -> completionTable.put(v, completionTable.getOrDefault(v, 0) + 1));        
        for (final String v : participant) {
            // 완주자 테이블에 key가 없거나 값이 0이면 비완주자
            if (completionTable.getOrDefault(v, 0) == 0) {
                return v;
            }
            // 이전 if가 한 조건으로 축약되었으므로 굳이 else 쓰지 않음 (취향)
            // https://skylit.tistory.com/263
            completionTable.put(v, completionTable.get(v) - 1);
        }
        return "";
    }
}