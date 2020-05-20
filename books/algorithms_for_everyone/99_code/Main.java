import question.*;
import java.util.HashSet;

class Main {
  public static void main(String[] args) {
    basic();
  }
  public static void basic() {
    // int[] cases = {10, 100};
    // int[] answer = {55, 5050};
    // Q01.input(cases, answer);
    // int[][] cases = {{17, 92, 18, 33, 58, 7, 33, 42}};
    // int[] answer = {92};
    // int[] answer2 = {1};
    // Q02.input(cases, answer, answer2);
    String[][] nameArray = {{"Tom", "Jerry", "Mike", "Tom"}, {"Harry", "John", "Bill", "Bill", "Harry"}};
    String[][] answerArray = {{"Tom"}, {"Harry", "Bill"}};
    Q03.input(nameArray, answerArray);
  }
}