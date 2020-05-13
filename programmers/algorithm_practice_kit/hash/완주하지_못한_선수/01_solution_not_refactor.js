function solution(participant, completion) {
    // 자바스크립트에서 제공하는 자료 구조 Map을 사용
    // 사용법(MDN) : https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Map
    // 동명이인은 합쳐서 카운트한 해시 테이블
    const completion_table = new Map();
    // for-of 를 통해 completion을 모두 순회
    for (const v of completion) {
        // 해당 이름의 key가 있으면 +1
        if (completion_table.has(v)) {
            completion_table.set(v, completion_table.get(v) + 1);
        } else {
            // 없으면 하나 만들어줌
            completion_table.set(v, 1);
        }
    }
    // completion_table.forEach(console.log)
    // for-of 로 참가자를 모두 순회
    for (const v of participant) {
        // 만약에 키가 없다
        if (!completion_table.has(v)) {
            return v; // 해당 요소를 리턴
            // 만약에 해당 키로 get를 했는데 값이 0, 즉 false다
        } else if (!completion_table.get(v)) {
            return v; // 해당 요소를 리턴
        } else {
            // value를 하나 줄여준다
            completion_table.set(v, completion_table.get(v) - 1);
        }
    }
}