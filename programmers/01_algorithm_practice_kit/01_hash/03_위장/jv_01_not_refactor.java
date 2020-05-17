// https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // 문자열, 숫자로 구성된 카테고리별 의상 갯수 세줄 hashMap 객체 생성
        HashMap<String, Integer> clothesTable = new HashMap<String, Integer>();
        // 향상된 for문(foreach)로 clothes 배열을 탐색
        for (String[] c : clothes) {
            // c[1], 즉 옷의 종류를 키로 가지고 있는가?
            if (clothesTable.containsKey(c[1])) {
                // 있으면 해당 값을 get 해준 다음 +1 하고 다시 put
                clothesTable.put(c[1], clothesTable.get(c[1]) + 1);             
            } else {
                // 없으면 새로 1 값을 넣어줌
                clothesTable.put(c[1], 1);
            }
        }
        // 값으로 돌려줄 변수. 기본 값인 1
        int answer = 1;
        for (int v : clothesTable.values()) {
            answer *= (v + 1); // 옷의 종류별 갯수 + 1 (안 입을 확률)
        }
        return answer - 1; // 아예 입지 않는 가짓 수 1을 빼줌
    }
}