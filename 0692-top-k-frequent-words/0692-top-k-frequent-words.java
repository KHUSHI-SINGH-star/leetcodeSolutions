class Solution {
    class Pair {
        String a;
        int b;

        Pair(String a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(

                (a, b) -> {
                    // Different frequencies → higher frequency first
                    if (a.b != b.b) {
                        return b.b - a.b;
                    }

                    // Same frequency → alphabetical order
                    return a.a.compareTo(b.a);
                }

        );

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            ;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        List<String> list = new ArrayList<>();
        while (k > 0) {
            list.add(pq.poll().a);
            k--;
        }

        return list;
    }
}