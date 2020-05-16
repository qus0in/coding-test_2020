import java.util.HashMap;

class Trie {
    public HashMap<String, HashMap> data;

    public Trie() {
        this.data = new HashMap<String, HashMap>();
        this.data.put("_", null);
    }

    public boolean insert(final String phoneNumber) {
        HashMap<String, HashMap> currNode = this.data;
        boolean seperate = false;
        for (final String p : phoneNumber.split("")) {
            if (!currNode.containsKey(p)) {
                if (!seperate && currNode.size() == 0) {
                    return false;
                }
                currNode.put(p, new HashMap<String, HashMap>());
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