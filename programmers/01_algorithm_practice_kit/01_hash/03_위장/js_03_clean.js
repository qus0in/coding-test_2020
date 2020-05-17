function solution(clothes) {
    const clothesTable = new Map();
    clothes.forEach(c => {
        clothesTable.set(c[1], clothesTable.has(c[1]) ? clothesTable.get(c[1]) + 1 : 1);
    })
    return Array.from(clothesTable.values()).reduce((prev, curr) => prev * (curr + 1), 1) - 1;
}