class Trie: # Trie 자료구조를 class로 정의
    data = {"_": None} # 첫번째 데이터를 모두 분기 처리하려고 의미없는 키 값 넣어줌
    def insert(self, string): # insert 메소드 : 검증하려는 문자열을 넣어주면 접두사 있는지 판별
        curr = self.data # 현재 노드
        seperate = False # 분기 여부
        for char in string: # for문으로 전달받은 문자열 순회
            # print(char)
            cursor = curr.get(char, 0) # 탐색하려는 노드
            if cursor == 0:
                if(len(curr) == 0) and (not seperate):
                    return False
                else:
                    # print("분기됨")
                    curr[char] = {}
                    seperate = True
            curr = curr[char] # 탐색했던 노드로 이동
        return seperate

def solution(phone_book):
    trie = Trie()
    for v in phone_book:
        if not trie.insert(v):
            return False
        print(trie.data)
    return True