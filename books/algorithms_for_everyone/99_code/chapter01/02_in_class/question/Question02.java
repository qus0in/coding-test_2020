package question;
import java.util.Arrays;

public class Question02 {
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
  // 출력 : (타입) 정수, nArray 최댓값
  // 복잡도 : O(n)
  public static int solution(int[] nArray) {
    // 최댓값을 저장해줄 변수
    int max = 0;
    // 향상된 for문을 통해 nArray의 모든 원소를 탐색
    for (int v : nArray) {
      // 만약에 max의 값보다 v의 값이 크면
      if (max < v) {
      // max에 v를 대입해준다
        max = v;
      }
      // max = max < v ? v : max; // 삼항연산자
    }
    return max;
  }

  // 문제 : 주어진 숫자 n개 중 가장 큰 숫자의 인덱스 찾기
  // 입력 : (타입) 정수 배열, nArray
  // 출력 : (타입) 정수, nArray 최댓값의 인덱스
  // 복잡도 : O(n)
  public static int solution2(int[] nArray) {
    // 최댓값을 담아준 변수
    int max = 0;
    // 최댓값의 인덱스를 담아주는 변수
    int maxIndex = 0;
    // 인덱스를 써야하므로 일반적인 for문 사용
    for (int i = 0; i < nArray.length; i++) {
      // 만약에 max의 값보다 v의 값이 크면
      if (max < nArray[i]) {
      // max에 v를 대입해준다
        max = nArray[i];
      // maxIndex에 i를 대입해준다
        maxIndex = i;
      }
    }
    return maxIndex;
  }
}
// 추가 문제 : 숫자 n개를 배열로 입력받아 최솟값을 구하는 알고리즘