package question;

// https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html
import java.util.Arrays;

public class Q02 {
  public static void input(int[][] caseArray, int[] answerArray, int[] answerArray2) {
    System.out.println("주어진 숫자 n개 중 가장 큰 숫자를 찾는 알고리즘");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %d\n출력(실제) : %d\n", Arrays.toString(caseArray[i]), answerArray[i],
          solution(caseArray[i]));
    }
    System.out.println("주어진 숫자 n개 중 가장 큰 숫자의 인덱스를 찾는 알고리즘");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %d\n출력(실제) : %d\n", Arrays.toString(caseArray[i]), answerArray2[i],
          solution2(caseArray[i]));
    }
  }

  // 문제 : 주어진 숫자 n개 중 가장 큰 숫자를 찾기
  // 입력 : (타입) 정수 배열, nArray
  // 출력 : (타입) 정수, nArr 중 최댓값
  // 솔루션 : for문으로 하나씩 비교
  // 복잡도 : O(n)
  public static int solution(int[] nArray) {
    // 최댓값을 저장할 변수 max 선언 및 0으로 초기화
    int max = 0;
    // 향상된 for문으로 nArray의 요소들(가지고 있는 값들)을 순서대로 v에 넣어줌 (v는 반복문마다 별도로 생성되는 값이기에 final
    // 처리)
    for (final int v : nArray) {
      // [for문 내부] max와 v를 비교해서 v가 크다면 max에 v를 대입해줌
      // if (max < v) {
      // max = v;
      // }
      // 코드를 깔끔하게 만들어주기 위한 삼항 연산자 사용
      max = max < v ? v : max;
    }
    // for문이 끝났을 때 max 값이 결과 값 (출력)
    return max;
  }

  // 문제 : 주어진 숫자 n개 중 가장 큰 숫자의 인덱스를 찾기
  // 입력 : (타입) 정수 배열, nArray
  // 출력 : (타입) 정수, nArr 중 최댓값의 인덱스
  // 솔루션 : for문으로 하나씩 비교
  // 복잡도 : O(n)
  public static int solution2(int[] nArray) {
    // 최댓값을 저장할 변수 max와 인덱스를 저장할 변수 idx 선언 및 0으로 초기화
    int max = 0;
    int idx = 0;
    // for문으로 0에서 nArray의 길이 - 1 까지 i 를 반복해서 증가해줌 (즉, 모든 인덱스 탐색)
    for (int i = 0; i < nArray.length; i++) {
      // [for문 내부] 인덱스 i로 찾은 값 v과 max를 비교해서 v가 크다면 idx에 i를 대입하고 max에 v를 대입
      int v = nArray[i];
      // if (max < v) {
      // idx = i;
      // max = v;
      // }
      // 코드를 깔끔하게 만들어주기 위한 삼항 연산자 사용
      idx = max < v ? i : idx;
      max = max < v ? v : max;
    }
    // for문이 끝났을 때 idx 값이 결과 값 (출력)
    return idx;
  }
}
// 추가 문제 : 숫자 n개를 리스트로 입력받아 최솟값을 구하는 알고리즘