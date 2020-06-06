// https://programmers.co.kr/learn/courses/30/lessons/42883?language=java
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // 만약에 number를 조합화 해가지고 모든 경우의수를 구하려고 하면 말도 안되는 시간이 걸림
        // 그러므로 부분적인 최선을 찾아줘야 함 => How?
        // 1. 0부터 제거해줘야하는 수 k + 1 개만큼 (0 to k) 좌측부터 잠정적인 제거 범위(left, right)를 지정
        // 2-1. 가장 최댓값 하나를 정해주고 새로운 left로 삼음. 그리고 right는 하나 증가 시킴
        // 2-2. 최댓값을 정해줬다는 것은 그 앞으로는 지워졌다는 것을 의미. 
        // 3-1. 만약에 가장 끝인 k 앞까지 제거를 했다면 (실질적으로 k개 제거) 이후에는 left right 간의 원소가 1 밖에 없으므로 늘 최댓값임
        // 3-2. 반대로 0을 선택해서 제거된게 없더라고 하도, 이후 1~k+1 간에서 최댓값을 추리는 과정하에서 제거되게 마련이고, 최악의 경우라도 마지막 number.length - k - 1 ~ number.length - 1 인덱스에서 하나의 값이 선택되면서 지워져야하는 k개는 모두 지워짐
        // 아래는 코드
        // 시간 절약을 위해 StringBuilder를 사용.
        StringBuilder sb = new StringBuilder();
        int left = 0; // 좌측 값
        int right = k; // 우측 값 한계 (빼줘야하는 수)
        int max; // 최댓값을 받아줄 변수
        int idx = 0; // 인덱스
        while (right < number.length()) { // number 끝까지 탐색할 때까지 (right가)
        	 max = -1; // 매번 새로 초기화해줘야 함
             for(int i = left ; i < right + 1 ; i++){ // 좌측부터 우측까지
                 int num = number.charAt(i) - '0'; // char to int = - '0'
                 if(num > max){
                     idx = i; // 최댓값의 인덱스
                     max = num; // 최댓값
                 }
             }
             sb.append(number.charAt(idx)); // 찾은 최댓값을 빌더에 넣어줌
             left = idx + 1; // 최댓값 찾은 것보다 한 인덱스 오른쪽
             right++; // 하나 찾았으니 범위 하나 오른쪽으로 늘림
        }
        return sb.toString(); // StringBuilder를 toString 해줌
    }
}