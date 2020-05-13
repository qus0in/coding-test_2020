function solution(participant, completion) {
    const completionTable = new Map();
    completion.forEach(v => {
        completionTable.set(v, completionTable.has(v) ? completionTable.get(v) + 1 : 1);
    });
    for (const v of participant) {
        if (!completionTable.get(v)) {
            return v;
        } else {
            completionTable.set(v, completionTable.get(v) - 1);
        }
    }
}