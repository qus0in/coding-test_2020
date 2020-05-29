import java.util.Arrays;
import java.util.Collections;

import java.util.stream.*;
import java.util.Comparator;

class Main {
  public static void main(String[] args) {
    String s = "keyword cat";
    System.out.println(s);
    String[] strArr = s.split("");
    // Arrays.sort() 를 통한 정렬
    // 오름 차순
    Arrays.sort(strArr);
    System.out.println(String.join("", strArr));
    // 내림 차순
    Arrays.sort(strArr, Collections.reverseOrder());
    System.out.println(String.join("", strArr));
    // stream.sort() 를 통한 정렬 
    // https://codechacha.com/ko/java8-stream-sorted/
    // https://howtodoinjava.com/java8/join-stream-of-strings/
    String s2 = "hello world";
    System.out.println(s2);
    String[] strArr2 = s2.split("");    
    // 오름 차순
    System.out.println(
      Arrays.stream(strArr2) // 스트림화 해서
        .sorted() // 오름차순 정렬하고
        .collect(Collectors.joining())); // 합쳐준다
    // 내림 차순
    System.out.println(
      Arrays.stream(strArr2) //스트림화 해서
        .sorted(Comparator.reverseOrder()) // 내림차순 정렬하고
        .collect(Collectors.joining())); // 합쳐준다
    // 임의의 기준
    String s3 = "my sweet bean";
    System.out.println(
      Arrays.stream(s3.split(" ")) // 공백 위주로 띄운 것을 
        .sorted((p1, p2) -> Integer.compare(p1.length(), p2.length())) // 길이 오름 차순으로 정렬한 다음
        .collect(Collectors.joining(" "))); // 합쳐준다
    System.out.println(
      Arrays.stream(s3.split(" ")) // 공백 위주로 띄운 것을 
        .sorted((p1, p2) -> Integer.compare(p2.length(), p1.length())) // 길이 내림 차순으로 정렬한 다음
        .collect(Collectors.joining(" "))); // 합쳐준다
  }
}