class Solution {
    class Pair {
        String s;
        int ind;

        Pair(String s, int ind) {
            this.s = s;
            this.ind = ind;
        }

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> words = new HashSet<>(wordList);

        words.remove(beginWord);

        while (!q.isEmpty()) {
            String word = q.peek().s;
            int step = q.peek().ind;
            q.remove();
            if (word.equals(endWord)) {
                return step;
            }
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == original) {
                        continue;
                    }
                    chars[i] = ch;
                    String next = new String(chars);

                    if (words.contains(next)) {
                        q.add(new Pair(next, step + 1));
                        words.remove(next);
                    }
                }
                chars[i] = original;
            }
        }
        return 0;
    }
}