import java.util.HashMap; // HashMap import

class Trie {
    // String Key값과 HashMap을 계속 담아주는 멤버변수 
    public HashMap<String, HashMap> data;
    public Trie() { // 생성자
        this.data = new HashMap<String, HashMap>();
        this.data.put("_", null); // 첫 데이터 분기 처리
    }
    // insert 메소드 (param : 전화번호)
    public boolean insert(String phoneNumber) {
        HashMap<String, HashMap> currNode = this.data; // 현재 노드 -> 계속 재대입할 예정
        boolean seperate = false; // 분기 여부 체크
        // 전화번호를 순서대로 쪼개서 순회
        for (String p : phoneNumber.split("")) {
            // System.out.println("* 탐색하려는 문자 : " + p);
            // System.out.println("* 탐색하려는 노드 : " + currNode);
            // 현재 조회중인 노드가 탐색하려는 문자를 key로 가지고 있는가?
            if (currNode.containsKey(p)) {
                // 가지고 있다면 그냥 패스한다
                // System.out.println("* 가지고 있는 키");
                ;
            } else {
                // 분기 되어 있지 않고 다른 키가 없다면
                // https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html#size--
                if (!seperate && currNode.size() == 0) {
                    // System.out.println("* 다른 키 없음");
                    return false; // 현재 노드까지를 접두사로 가지는 케이스
                } 
                // 다른 키가 있다면, 분기하는 새로운 키를 추가해준다
                currNode.put(p, new HashMap<String, HashMap>());
                // System.out.println("* 새 키 추가");
                if (!seperate) {                 
                    // System.out.println("* 분기됨");
                    seperate = true; // 분기 스위치
                }
            }
            // System.out.println(currNode);
            currNode = currNode.get(p); // 다음 노드 탐색
        }
        // System.out.println("* 끝까지 찾음");
        return seperate; // 분기를 안하고 false를 유지했다면 다른 노드의 접두사이므로 바로 boolean을 return해줌
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        Trie trie = new Trie();
        // System.out.println(trie.data);
        // 전화번호부를 순회하면서 트라이에 삽입 & 접두사 검증
        for (String phoneNumber : phone_book) {
            if (!trie.insert(phoneNumber)) { // false, 즉 접두사 존재 한다고 나오면
                return false; // 접두사 존재, false를 리턴
            }
        }
        // 끝까지 진행하면 접두사가 없다!
        return true;
    }
}