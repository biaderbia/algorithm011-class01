学习笔记
### 双向BFS模板

```java
public int ladderLength(String beginWord, String endWord, Set<String> dic) {
  if (!dic.contains(endWord)) return 0;
  int len = beginWord.length();
  Set<String> visited = new HashSet<>();
  Set<String> beginVisited = new HashSet<>();
  Set<String> endVisited = new HashSet<>();
  beginVisited.add(beginWord);
  endVisited.add(endWord);
  int step = 1;
  while(!beginVisited.isEmpty() && !endVisited.isEmpty()) {
    if (beginVisited.size() > endVisited.size()) {
      Set<String> temp = beginVisited;
      beginVisited = endVisited;
      endVisited = temp;
    }

    // BFS begin
    Set<String> nextLevelVisited = new HashSet<>();
    for (String word : beginVisited) {
      char[] charArray = word.toCharArray();
      for (int i = 0; i < len; i++) {
        char oldChar = word.charAt(i);
        for (char c = 'a'; c <= 'z'; c++) {
          charArray[i] = c;
          String nextWord = String.valueOf(charArray);
          if (dic.contains(nextWord)) {
          	if (endVisited.contains(nextWord)) {
            	return step + 1;
          	}
            if (!visited.contains(nextWord)) {
              visited.add(nextWord);
              nextLevelVisited.add(nextWord);
            }
          }

        }
        charArray[i] = oldChar;
      }
    }
    step++;
    beginVisited = nextLevelVisited;
  }
  return 0;
}
```
