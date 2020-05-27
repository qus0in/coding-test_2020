package question;

import java.util.HashSet;
// https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html
import java.util.Arrays;

public class Question03 {
  public static void input(String[][] caseArray, String[][] answerArray) {
    System.out.println("n명의 사람 이름 중에서 같은 이름을 찾아 집합으로 만들어 돌려주는 알고리즘");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %s\n출력(실제) : %s\n", Arrays.toString(caseArray[i]), Arrays.toString(answerArray[i]), Arrays.toString(solution(caseArray[i]).toArray()));
    }
  }

  // 문제 : n명의 사람 이름 중에서 같은 이름을 찾아 집합(중복X)으로 만들어주기
  // 입력 : (타입) 문자열 배열, nameArray
  // 출력 : (타입) 문자열 집합(HashSet), answerSet
  // 솔루션 : for문으로 하나씩 비교
  // 복잡도 : O(n)
  public static HashSet<String> solution(String[] nameArray) {
    // 이름확인 집합
    HashSet<String> nameSet = new HashSet<String>();
    // 동명이인 집합 (최소 2명 이상이 존재)
    HashSet<String> answerSet = new HashSet<String>();
    for (String v: nameArray) {
      // 만약에, 이번 차례의 이름(v)이 이름확인 집합에 없다면?
      if(!nameSet.contains(v)) { // contains
        // 집합에 이름을 추가해줍니다
        nameSet.add(v); // add
      // 그게 아니면 (이름확인 집합에 이름이 존재하면)
      } else {
        // = 동명이인 => 그 이름을 동명이인 집합에 추가해줍니다
        answerSet.add(v);
      }
    }
    return answerSet;
  }
}
// 추가 문제 : n명 중 두 명을 뽑아 짝을 짓는다고 할 때 짝을 지을 수 있는 모든 조합을 출력하는 알고리즘