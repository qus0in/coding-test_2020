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
  public static int solution(int a, int b) {
    /* 최대공약수 : 두 개 이상의 정수의 공통 약수 중 가장 큰 값
    // (1) 두 수의 약수 중에서
    // (2) 공통된 것을 찾아
    // (3) 그 값 중 최댓값인 것을 찾아야 함
    */
    // (예) 3034 & 4923
    // 두 수 중 더 작은 값을 i에 저장
    // int i;
    // if (a < b) {
    //   i = a;
    // } else {
    //   i = b;
    // }
    // a가 b보다 작으면 a를, 아니면 b를 대입해준다
    int i = a < b ? a : b;
    while (true) {
      // i가 a와 b 두 수의 공통된 약수인지 확인
      if(a % i == 0 && b % i == 0) {
        // 공통된 약수 (나머지 0이니까)
        // i를 리턴하면서 종료
        return i;
      }
      i--; // 증감연산자 통해서 -의 값을 1 줄여줌
    }
  }

  // 솔루션 2 : 유클리드 방식 (재귀)
  public static int solution2(int a, int b) {
    // (1) a와 b의 최대 공약수는 b와 a % b 의 최대공약수와 같음
    // (2) 어떤 수와 0의 최대공약수는 자기 자신
    // a와 b. 
    // 종료조건 : b가 0이면 종료
    // b, 0 => b, a % b => a = x * b
    if(b == 0) {
      return a; // a가 원래 처음 들어왔던 두 수의 최대공약수임을 의미합니다
    }
    // a와 b의 최대공약수 연산을
    // b와 a 나누기 b의 나머지 간의 연산으로 바꿔줌
    return solution2(b, a % b);
  }
  // 솔루션 3 : 유클리드 방식 (반복)
  public static int solution3(int a, int b) {
    // 반복문의 기본은 외부 변수 선언
    int tmp;
    // 재귀에서의 종료 조건이 곧 반복문에서 제어 조건 (조건문)과 같음
    while (b != 0) {
      // solution2(b, a % b)
      tmp = a % b;
      a = b;
      b = tmp; // a % b
      // 재귀변수와 똑같은 구조
      // 공간복잡도 - 사용하는 메모리나 호출하는 함수의 횟수가 줄어들어요
    } // a <- b가 들어갔다, 근데 만약에 이 while 문이 종료되었다면 b = 0. 
    return a;
  }
}