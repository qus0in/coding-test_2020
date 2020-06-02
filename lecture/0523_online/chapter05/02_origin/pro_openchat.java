import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public String[] solution(String[] record) {
        // [분석]
        // 입력 : 기능, 아이디 (, 닉네임) 으로 구성된 문자열(구분자는 공백)의 배열
        // 출력 : 메시지 문자열 배열
        // 기능은 3가지 (Enter, Leave, Change)
        // 아이디는 중복될 수 없지만, 닉네임은 중복 (및 변경) 가능 ==> 이걸 보면 Map을 써야함 (Key는 중복되지 않지만, Value는 중복되는 상황)
        // 기록 문자열을 쪼개는 여러가지 방법이 있는데, 최적화된 StringTokenizer를 추천 (물론 split도 괜찮음)
        // 최종적으로 기록된 닉네임을 기준으로 채팅방 로그 메시지가 나옴
        // 배열을 답으로 제출해야하지만 ArrayList가 다루기 더 편하므로 ArrayList를 사용
        // [코드]
		StringTokenizer tokenizer; // 글자 나눠주기 (split도 가능)
		String cmd; // 커맨드를 받아주는 변수
        HashMap<String, String> idMap = new HashMap<>(); // id를 키, 닉네임으로 값으로 가지는 해시 맵 자료구조
        // 명령들을 forEach문으로 순서대로 탐색
		for (String r : record) { // r로 받음
			tokenizer = new StringTokenizer(r, " "); // r을 여백(" ")으로 분리하여 토큰화
			cmd = tokenizer.nextToken(); // 첫 번째 토큰 = 기술
			if(!cmd.equals("Leave")) { // 나가기 기능 (= 아이디와 닉네임의 변경 없음)
                idMap.put(tokenizer.nextToken(), tokenizer.nextToken());
                // 입장하거나 닉변하면 idMap에 기록해 줌
			}
		}		
		ArrayList<String> answer = new ArrayList<>(); // 편의상 ArrayList로 구현하고 이후 Array로 변환
		for (String r : record) { // record를 또다시 탐색 (왜? => 최종까지 닉네임 변경 여부가 있는지 확인하고 다시금 처음부터 끝까지...)
			tokenizer = new StringTokenizer(r, " ");
			cmd = tokenizer.nextToken();
			if(!cmd.equals("Change")) {	// 변경 명령이 아니라면 (= 로그 메시지가 출력됨)			
				answer.add(new StringBuilder() // StringBuilder(기본 내장)으로 메시지 반들어 줄 것임
								.append(idMap.get(tokenizer.nextToken())) // 닉네임
								.append("Enter".equals(cmd) ? "님이 들어왔습니다." : "님이 나갔습니다.") // 기능에 따라서 연결
								.toString()); // 결과물
			}
        }
        // ArrayList.toArray로 String 배열화
		return answer.toArray(new String[answer.size()]);
	}
}