def solution(phone_book):
    # 트라이 구조를 만들어주면서 접두사 여부를 판정하는 함수
    def trieFun(curr, string):
        # 분기 여부를 확인하는 boolean
        seperate = False
        # print(string)
        for s in string: # 전달받은 문자열을 순회
            # print(s)
            # get으로 받았으니 딕셔너리 나오거나 키 없으면 0 나옴
            cursor = curr.get(s, 0)
            if cursor == 0:
                # 트라이에 다른 키들이 없음 => 이전까지의 노드들이 접두사임
                if (len(curr) == 0) and (not seperate):
                    # print('case 1 : prefix')
                    return False
                # 있으면 분기된 것임
                # print('case 2')
                seperate = True
                # 없으니까 새로운 딕셔너리를 추가해줌
                curr[s] = {}
            # 다음 노드로 넘어감
            curr = curr[s]
        # 분기되지 않았고 전부 탐색했다면
        if not seperate:
            # 무언가의 접두사임
            # print('case 3 : prefix')
            return False
        return True
    trie = {'_' : None} # 첫번째부터 key 오류가 나지 않게 빈값 넣어줌
    # phone_book을 순회
    for p_number in phone_book:
        curr = trie # trie 최상층부터 노드 탐색
        if not trieFun(curr, p_number): # 만약에 접두사가 존재해서 false가 리턴되면
            return False # 바로 false 이어서 리턴 (아니면 계속 탐색)
    return True # 끝까지 탐색했는데 접두사 없으면 false