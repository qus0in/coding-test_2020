import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        // [분석]
        // 입력 : 문자열 이차원 배열 (옷 이름, 옷 종류)
        // 출력 : 가능한 옷가지 조합 수 (같은 옷 종류 안에서 조합)
        // 결국 옷 종류 별로 몇 가지 인지 세서 각자 곱해준 것 - 1 = 옷 가지 입는 조합 (그려 보기)
        // (-1은 아예 안입는 것! <= 이건 불가능)
        // 그래서 옷 종류(키)와 몇 개 있는지(값)을 다루는 맵 형태를 써줌 (맵 값을 대상으로 연산)
        // [코드]
        // 문자열, 숫자로 구성된 카테고리별 의상 갯수 세줄 hashMap 객체 생성
        HashMap<String, Integer> clothesTable = new HashMap<String, Integer>();
        // 향상된 for문(foreach)로 clothes 배열을 탐색
        for (String[] c : clothes) {
            // // c[1], 즉 옷의 종류를 키로 가지고 있는가?
            // if (clothesTable.containsKey(c[1])) {
            //     // 있으면 해당 값을 get 해준 다음 +1 하고 다시 put
            //     clothesTable.put(c[1], clothesTable.get(c[1]) + 1);             
            // } else {
            //     // 없으면 새로 1 값을 넣어줌
            //     clothesTable.put(c[1], 1);
            // }
            // getOrDefault로 축약
            clothesTable.put(c[1], clothesTable.getOrDefault(c[1], 0) + 1);
        }
        // 값으로 돌려줄 변수. 기본 값인 1
        int answer = 1;
        for (int v : clothesTable.values()) {
            answer *= (v + 1); // 옷의 종류별 갯수 + 1 (안 입을 확률)
        }
        return answer - 1; // 아예 입지 않는 가짓 수 1을 빼줌
    }
}