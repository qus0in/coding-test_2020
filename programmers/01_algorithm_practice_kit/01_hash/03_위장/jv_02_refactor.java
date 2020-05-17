import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesTable = new HashMap<String, Integer>();
        for (String[] c : clothes) {
            // getOrDefault 메소드로 축약
            clothesTable.put(c[1], clothesTable.getOrDefault(c[1], 0) + 1);
        }
        // https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#reduce-T-java.util.function.BinaryOperator-
        // stream 기능 사용하여 reduce로 곱해서 축약 (효율성은 낮아지지만 깔끔한 코딩)
        return clothesTable.values().stream().reduce(1, (prev, curr) -> prev * (curr + 1)) - 1;
    }
}