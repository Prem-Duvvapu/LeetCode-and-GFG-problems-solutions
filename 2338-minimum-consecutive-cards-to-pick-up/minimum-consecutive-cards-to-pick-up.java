class Solution {
    public int minimumCardPickup(int[] cards) {
        int n = cards.length;
        Map<Integer,Integer> map = new HashMap<>();
        int res = n+1;

        for (int i=0;i<n;i++) {
            if (map.containsKey(cards[i])) {
                int currRes = i - map.get(cards[i]) + 1;
                res = Math.min(res, currRes);
            }

            map.put(cards[i],i);
        }


        return (res == n+1) ? -1 : res;
    }
}

/*
[3,4,2,3,4,7]


{(3,1),(4,1),(2,1)}

minAns = 2
maxAns = n

2 to n

2,3,.5..,n


logn * O(n) = O(n*logn)

O(n^2) -> O(n*logn) -> (n*k)

{(4,1)(2,1)}
[3,4,2,3,4,7]
   l      r

map = {(3,4),(4,1),(2,2)}
res = 4
[3,4,2,3,4,7]

time: O(n)
space: O(n)
*/