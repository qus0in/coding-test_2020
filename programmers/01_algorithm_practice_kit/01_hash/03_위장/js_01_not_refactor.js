function solution(clothes) {
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Map
    // clothes 종류를 key로 받고, 각기 종류별 갯수를 value로 받는 맵 객체 생성
    const clothesTable = new Map();
    // clothes 리스트 순회
    for (const c of clothes) {
        // 의상 종류가 키로 이미 있으면 +1 해서 더해주고
        if (clothesTable.has(c[1])) {
            clothesTable.set(c[1], clothesTable.get(c[1]) + 1);
        } else { // 아니면 바로 1을 넣어줌
            clothesTable.set(c[1], 1);
        }
    }
    let answer = 1; // 답으로 리턴될 변수
    for (const v of clothesTable.values()) {
        // console.log(v);
        answer *= (v + 1) // 옷 종류별 옷 가지수 + 입지 않는 경우 (1)
    }
    return answer - 1; // 아예 안 입는 경우가 없으니 1 빼줌
}