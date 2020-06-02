// https://programmers.co.kr/learn/courses/30/lessons/42862
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 요소들을 자유롭게 삭제할 수 있어야하므로 리스트로 변환
        List<Integer> reserveList = new ArrayList<>();
        for (int i : reserve) {
            reserveList.add(i);
        }
        List<Integer> lostList = new ArrayList<>();
        for (int i : lost) {
            lostList.add(i);
        }
        // System.out.println(lostList);
        // System.out.println(reserveList);
        for (int i : lost) { // 잃어버린 사람들 배열에서
            // 본인부터 체크해서 지워줍니다.
            // 여분 목록에 그 사람이 있다?
            if (reserveList.contains(i)) {
                // remove에서 정수를 넣으면 인덱스로 인식하므로 Integer.valueOf를 사용
                reserveList.remove(Integer.valueOf(i)); // 여분에서 지우고
                lostList.remove(Integer.valueOf(i)); // 잃어버린 것에서도 지우고
            }
        }
        // System.out.println(lostList);
        // System.out.println(reserveList);
        for (int i : reserveList) { // 여분 목록을 순회해줍니다
            if (lostList.contains(i - 1)) { // 사이즈가 1 작은 게 있는지
                lostList.remove(Integer.valueOf(i - 1)); // 있으면 lostList에서 제거
            } else if (lostList.contains(i + 1)) { // 사이즈 1 큰 게 있는지
                lostList.remove(Integer.valueOf(i + 1)); // 있으면 lostList에서 제거
            }
        }
        // System.out.println(lostList);
        // System.out.println(reserveList);
        return n - lostList.size(); // 아직도 여분 못 구한 사람들 수를 전체 수에서 빼줌
    }
}