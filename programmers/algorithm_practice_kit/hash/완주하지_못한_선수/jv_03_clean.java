import java.util.HashMap;

class Solution {
    public String solution(final String[] participant, final String[] completion) {
        final HashMap<String, Integer> completionTable = new HashMap<String, Integer>();
        for (final String v : completion) {
            completionTable.put(v, completionTable.getOrDefault(v, 0) + 1);
        }
        for (final String v : participant) {
            if (completionTable.getOrDefault(v, 0) == 0) {
                return v;
            completionTable.put(v, completionTable.get(v) - 1);
        }
        return "";
    }
}