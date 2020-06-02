package question;
import java.util.Arrays;

public class Question05 {
  public static void input(int[][] caseArray, int[] answerArray) {
    System.out.println("두 자연수 a와 b의 최대공약수를 구하는 알고리즘");
    System.out.println("솔루션 1 : while문으로 모듈러스 연산");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %d\n출력(실제) : %d\n", Arrays.toString(caseArray[i]), answerArray[i], solution(caseArray[i][0], caseArray[i][1]));
    }
    System.out.println("솔루션 2 : 유클리드 방식 (재귀)");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %d\n출력(실제) : %d\n", Arrays.toString(caseArray[i]), answerArray[i], solution2(caseArray[i][0], caseArray[i][1]));
    }
    System.out.println("솔루션 3 : 유클리드 방식 (반복)");
    for (int i = 0; i < caseArray.length; i++) {
      System.out.printf("입력 : %s\n출력(예상) : %d\n출력(실제) : %d\n", Arrays.toString(caseArray[i]), answerArray[i], solution3(caseArray[i][0], caseArray[i][1]));
    }
  }
  // 문제 : 최대공약수 구하기
  // 입력 : (타입) 정수, a, b
  // 출력 : a와 b의 최대공약수
  // 솔루션 1 : while문으로 모듈러스 연산
  // 복잡도 : O(n)
  public static int solution(int a, int b) {
    /* 최대공약수 : 두 개 이상의 정수의 공통 약수 중 가장 큰 값
    // (1) 두 수의 약수 중에서
    // (2) 공통된 것을 찾아
    // (3) 그 값 중 최댓값인 것을 찾아야 함
    */
    // [풀이]
    // 두 수 중 더 작은 값을 i에 저장
    int i = a < b ? a : b;
    while (true) {
      // i가 두 수의 공통된 약수인지 확인 (둘 다 모듈러스(나머지 연산) 해서 0이 나오는 지)
      if (a % i == 0 && b % i == 0) {
      // 참이면 리턴하여 종료 (감소시키다보면 i가 1이 되기 때문에 모듈러스는 언젠가 0이 나올 수밖에 없음)
        return i;
      }
      // 거짓이면 i를 1만큼 감소시킴
      i -= 1;
    }
  }
  // 솔루션 2 : 유클리드 방식 (재귀)
  // 복잡도 : O((log n)²)
  public static int solution2(int a, int b) {
    // (1) a와 b의 최대 공약수는 b와 a % b 의 최대공약수와 같음
    // (2) 어떤 수와 0의 최대공약수는 자기 자신
    // [풀이]
    if (b == 0) { //  종료 조건 (숫자 중 0이 발생))
      return a;
     } // 남은 숫자를 반환
    return solution2(b, a % b); // 좀 더 작은 값으로 자기 자신을 호출
  }
  // 솔루션 3 : 유클리드 방식 (반복)
  // 복잡도 : O((log n)²)
  public static int solution3(int a, int b) {
    int tmp; // 임시 저장을 위해 쓸 변수
    while (b != 0) { // b가 0이 아니라면
      tmp = a % b; // a를 b로 나눈 나머지를 임시 저장
      a = b; // a에 b를 넣음
      b = tmp; // b에 넣어줌
      // (solution2 재귀와 똑같은 기능이지만 공간 복잡도가 줄어듦)
    }
    return a;
  }
}
// 추가 문제 : 피보나치 수열을 구하는 재귀 호출 알고리즘