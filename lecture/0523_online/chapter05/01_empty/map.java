import java.util.*;

class Main {
  public static void main(String[] args) {
    // 맵 생성 (키는 문자열, 값은 정수)
    HashMap<String, Integer> map = new HashMap<>(); 
    // https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
    System.out.println(map); // { }
    // put(k, v) : k라는 키에 v라는 값 넣기

    // get(k) : k를 키로 가지는 값 불러오기 (키가 없을 시 null 리턴)
    
    // getOrDefault(k, d) : k를 키로 가지는 값을 불러오되, 키가 없을 시에 d라는 기본값 리턴

    // containsKey(k) : HashMap에 k라는 키가 있는지 (boolean)

    // containsValue(v) : HashMap에 v라는 값이 (한 개 이상) 있는지 (boolean)

    // remove(k) : k라는 키 자체를 제거

    // keySet() : HashMap에 있는 모든 키가 담긴 Set (중복 없는 집합) 반환
 
    // values() : HashMap에 있는 모든 값이 담긴 Collection으로 반환
 
    // entrySet() : HashMap에 있는 모든 키와 값의 쌍이 Set으로 반환
  }
}