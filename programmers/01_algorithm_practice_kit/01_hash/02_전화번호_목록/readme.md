# 📞 전화번호 목록
## ❓ 문제 (요약)
> 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
* 🔗 [자세히 보기](https://programmers.co.kr/learn/courses/30/lessons/42577)

## 🔬 분석
- 문자열의 접두사를 검색하기 위해서는 트리 구조의 일종인 트라이(Trie - retrieval, 즉 검색을 위한 트리) 자료구조를 사용해야 함 (Hash 계열)
  - [트라이(Trie) 자료구조](https://brunch.co.kr/@springboot/75)
  - [트라이 자료구조 구현해보기](https://blog.ilkyu.kr/entry/%ED%8C%8C%EC%9D%B4%EC%8D%AC%EC%97%90%EC%84%9C-Trie-%ED%8A%B8%EB%9D%BC%EC%9D%B4-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0)
- 전화번호가 담긴 배열의 요소를 순차적으로 트라이에 넣으며 동시에 접두사 존재 여부를 검사한다고 했을 때, 아래 3가지 케이스가 가능
  1. 기존의 노드를 포함하고 확장해나감 (접두사)
  1. 기존의 노드와 일부 공유하지만 분기해 나감
  1. 기존의 노드 안에서 끝남 (접두사)
  - 이 중에 케이스 1, 3가 발생했을 경우 false를 return하고 케이스 2만 발생하고 전체 순회가 끝났다면 true를 리턴해주도록 짜면 됨