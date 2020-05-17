import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesTable = new HashMap<String, Integer>();
        for (String[] c : clothes) {
            clothesTable.put(c[1], clothesTable.getOrDefault(c[1], 0) + 1);
        }
        return clothesTable.values().stream().reduce(1, (prev, curr) -> prev * (curr + 1)) - 1;
    }
}