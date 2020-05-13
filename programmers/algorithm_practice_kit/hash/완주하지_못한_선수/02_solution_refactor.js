function solution(participant, completion) {
    const completion_table = new Map();
    // for-of를 for-each로 변환
    completion.forEach(v => {
        // if 구문을 삼항 연산자로 축약 
        completion_table.set(v, completion_table.has(v) ? completion_table.get(v) + 1 : 1);
    });
    // 정답이 나오면 return 해줘야하기 때문에 for-of를 계속 사용
    // forEach 메소드는 중간에 break가 안 됨, 메소드 사용하고 싶다면 some이나 every 메소드를 참고
    for (const v of participant) {
        // Map의 get 메소드는 키가 없을 경우 Key Error가 아닌 undefined를 return하므로 굳이 별도의 if 연산이 필요하지 않음
        // 그러므로 get 메소드 하나만 하면, key가 없을 때(undefined이므로 false)와 value가 0일 때(false)를 모두 잡아낼 수 있음
        if (!completion_table.get(v)) {
            return v;
        } else {
            completion_table.set(v, completion_table.get(v) - 1);
        }
    }
}