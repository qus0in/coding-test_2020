import question.*;

class Main {
  public static void main(String[] args) {
    // basic();
    recursion();
  }
  public static void recursion() {
    int[] cases = {1, 5, 10};
    int[] answer = {1, 120, 3628800};
    Question04.input(cases, answer);
    // int[][] cases = {{1, 5}, {3, 6}, {60, 24}, {81, 27}};
    // int[] answer = {1, 3, 12, 27};
    // Question05.input(cases, answer);
  }
  public static void basic() {
    // int[] cases = {10, 100};
    // int[] answer = {55, 5050};
    // Question01.input(cases, answer);
    // int[][] cases = {{17, 92, 18, 33, 58, 7, 33, 42}};
    // int[] answer = {92};
    // int[] answer2 = {1};
    // Question02.input(cases, answer, answer2);
    // String[][] nameArray = {{"Tom", "Jerry", "Mike", "Tom"}, {"Harry", "John", "Bill", "Bill", "Harry"}};
    // String[][] answerArray = {{"Tom"}, {"Harry", "Bill"}};
    // Question03.input(nameArray, answerArray);
  }
}