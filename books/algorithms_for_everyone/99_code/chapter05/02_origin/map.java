import java.util.*;

class Main {
  public static void main(String[] args) {
    // 맵 생성 (키는 문자열, 값은 정수)
    HashMap<String, Integer> map = new HashMap<>(); 
    // https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
    System.out.println(map); // { }
    // put(k, v) : k라는 키에 v라는 값 넣기
    map.put("수학", 95);
    map.put("영어", 50);
    map.put("국어", 85);
    System.out.println(map); // {국어=85, 수학=95, 영어=50}
    // get(k) : k를 키로 가지는 값 불러오기 (키가 없을 시 null 리턴)
    System.out.println(map.get("국어")); // 85
    System.out.println(map.get("과학")); // null
    // getOrDefault(k, d) : k를 키로 가지는 값을 불러오되, 키가 없을 시에 d라는 기본값 리턴
    System.out.println(map.getOrDefault("수학", 0)); // 95
    System.out.println(map.getOrDefault("과학", 0)); // 0
    // containsKey(k) : HashMap에 k라는 키가 있는지 (boolean)
    System.out.println(map.containsKey("수학")); // true
    System.out.println(map.containsKey("과학")); // false
    // containsValue(v) : HashMap에 v라는 값이 (한 개 이상) 있는지 (boolean)
    System.out.println(map.containsValue(95)); // true
    System.out.println(map.containsValue(100)); // false
    // remove(k) : k라는 키 자체를 제거
    map.remove("영어");
    System.out.println(map.get("영어")); // null
    // keySet() : HashMap에 있는 모든 키가 담긴 Set (중복 없는 집합) 반환
    System.out.println(map.keySet()); // [국어, 수학]
    // values() : HashMap에 있는 모든 값이 담긴 Collection으로 반환
    System.out.println(map.values()); // [85, 95]
    // entrySet() : HashMap에 있는 모든 키와 값의 쌍이 Set으로 반환
    System.out.println(map.entrySet()); // [국어=85, 수학=95]
  }
}