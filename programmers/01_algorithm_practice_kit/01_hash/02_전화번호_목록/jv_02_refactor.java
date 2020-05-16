import java.util.HashMap;

class Trie {
    public HashMap<String, HashMap> data;

    public Trie() {
        this.data = new HashMap<String, HashMap>();
        this.data.put("_", null);
    }

    // 더 이상 변화가 없는 변수들은 final을 통해서 상수화
    public boolean insert(final String phoneNumber) {
        HashMap<String, HashMap> currNode = this.data;
        boolean seperate = false;
        for (final String p : phoneNumber.split("")) {
            // !(not)을 사용해 if문 축약
            if (!currNode.containsKey(p)) {
                if (!seperate && currNode.size() == 0) {
                    return false;
                }
                currNode.put(p, new HashMap<String, HashMap>());
                // 굳이 if 연산을 넣을 필요 없음
                seperate = true;
            }
            currNode = currNode.get(p);
        }
        return seperate;
    }
}

class Solution {
    public boolean solution(final String[] phone_book) {
        final Trie trie = new Trie();
        for (final String phoneNumber : phone_book) {
            if (!trie.insert(phoneNumber)) {
                return false;
            }
        }
        return true;
    }
}