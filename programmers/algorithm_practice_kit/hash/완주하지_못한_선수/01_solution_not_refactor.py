def solution(participant, completion):
    # dictionary를 통한 풀이
    # dictionary (python docs)
    # - https://docs.python.org/ko/3.7/tutorial/datastructures.html#dictionaries
    # - https://docs.python.org/ko/3.7/library/stdtypes.html#typesmapping
    # 완주자들의 해시 테이블 작성
    completion_table = {}
    # 완주자 리스트 순회해서 테이블로 변형
    for v in completion:
        # get 메소드 : 있으면 해당 키 값, 없으면 defalut 값을 제공
        completion_table[v] = completion_table.get(v, 0) + 1
    # print(completion_table)
    # 참가자 리스트 순회해서 완주자 테이블과 대조
    for v in participant:
        # key가 없으면 default 0으로 대입됨 => 값이 0이면
        if not completion_table.get(v, 0):
            # 동명이인도 다 제거된 상태에서 비완주자이므로 return
            return v
        else:
            # 만약에 key가 있으면서 이름에 value 여분이 있으면 1을 빼줌
            completion_table[v] = completion_table[v] - 1