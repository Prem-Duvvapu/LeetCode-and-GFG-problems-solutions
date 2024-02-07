class Solution {
    public String frequencySort(String s) {
        char[] arr=s.toCharArray();
        Map<Character,Integer> freq=new HashMap<>();
        StringBuilder res=new StringBuilder();

        for (char ch: arr)
            freq.put(ch,freq.getOrDefault(ch,0)+1);

        PriorityQueue<Map.Entry<Character,Integer>> pq=new PriorityQueue<>((x,y)->(y.getValue()-x.getValue()));
        pq.addAll(freq.entrySet());

        while (!pq.isEmpty()) {
            Map.Entry<Character,Integer> entry=pq.poll();
            res.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return res.toString();
    }
}