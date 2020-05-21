package question;

// https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html
import java.util.HashSet;
import java.util.Arrays;

public class Q03 {
  public static void input(String[][] caseArray, String[][] answerArray) {
    System.out.println("n명의 사람 이름 중에서 같은 이름을 찾아 집합으로 만들어 돌려주는 알고리즘");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %s\n출력(실제) : %s\n", Arrays.toString(caseArray[i]), Arrays.toString(answerArray[i]), Arrays.toString(solution(caseArray[i]).toArray()));
    }
  }

  // 문제 : n명의 사람 이름 중에서 같은 이름을 찾아 집합으로 만들어주기
  // 입력 : (타입) 문자열 배열, nameArray
  // 출력 : (타입) 문자열 집합(HashSet), answerSet
  // 솔루션 : for문으로 하나씩 비교
  // 복잡도 : O(n)
  public static HashSet<String> solution(String[] nameArray) {
    // 이미 있는 이름인지 확인할 set을 만들어줌
    HashSet<String> nameSet = new HashSet<String>();
    // 이미 있는 이름인지 확인할 set을 만들어줌
    HashSet<String> answerSet = new HashSet<String>();
    // 향상된 for문으로 nameArray의 요소들(가지고 있는 값들)을 순서대로 v에 넣어줌 (v는 반복문마다 별도로 생성되는 값이기에 final 처리)
    for (final String v : nameArray) {
      // [for문 내부] nameSet(집합)에 v가 있는지 확인하여 없으면 nameSet에, 있으면(중복되면) answerSet에 추가(add)해줌
      if (nameSet.contains(v)) {
        answerSet.add(v);
      } else {
        nameSet.add(v);
      }
    }
    return answerSet;
  }
}
// 추가 문제 : n명 중 두 명을 뽑아 짝을 짓는다고 할 때 짝을 지을 수 있는 모든 조합을 출력하는 알고리즘