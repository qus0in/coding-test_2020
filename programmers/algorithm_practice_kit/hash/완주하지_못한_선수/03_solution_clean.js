function solution(participant, completion) {
    const completion_table = new Map();
    completion.forEach(v => {
        completion_table.set(v, completion_table.has(v) ? completion_table.get(v) + 1 : 1);
    });
    for (const v of participant) {
        if (!completion_table.get(v)) {
            return v;
        } else {
            completion_table.set(v, completion_table.get(v) - 1);
        }
    }
}