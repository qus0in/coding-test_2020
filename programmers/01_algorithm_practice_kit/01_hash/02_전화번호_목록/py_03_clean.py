class Trie:
    data = {"_": None}
    def insert(self, string):
        curr = self.data
        seperate = False
        for char in string:
            cursor = curr.get(char, 0)
            if cursor == 0:
                if(len(curr) == 0) and (not seperate):
                    return False
                else:
                    curr[char] = {}
                    seperate = True
            curr = curr[char]
        return seperate

def solution(phone_book):
    trie = Trie()
    for p in phone_book:
        if not trie.insert(p):
            return False
    return True