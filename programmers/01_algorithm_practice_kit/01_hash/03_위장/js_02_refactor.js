function solution(clothes) {
    const clothesTable = new Map();
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/%EC%95%A0%EB%A1%9C%EC%9A%B0_%ED%8E%91%EC%85%98
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Conditional_Operator
    // forEach 메소드로, clothesTable에 값을 집어넣음
    // 삼항 조건 연산자로 if문 축약
    clothes.forEach(c => {
        clothesTable.set(c[1], clothesTable.has(c[1]) ? clothesTable.get(c[1]) + 1 : 1);
    })
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/from
    // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/Reduce
    // clothesTable.values()는 iterable이지, array가 아니므로 array.from 기능으로 형변환 해주고 reduce 메소드를 통해 축약
    return Array.from(clothesTable.values()).reduce((prev, curr) => prev * (curr + 1), 1) - 1;
}