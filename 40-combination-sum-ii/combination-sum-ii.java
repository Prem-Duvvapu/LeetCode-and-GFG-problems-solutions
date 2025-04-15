class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n=candidates.length;
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(candidates);
        solve(0,new ArrayList<>(),target,res,candidates,n);
        return res;
    }

    public void solve(int pos,List<Integer> currList,int req,List<List<Integer>> res,int[] candidates,int n) {
        if (req==0) {
            res.add(new ArrayList<>(currList));
            return;
        }

        if (req<0)
            return;

        if (pos==n)
            return;

        for (int i=pos;i<n;i++) {
            if (i>pos && candidates[i]==candidates[i-1])
                continue;

            currList.add(candidates[i]);
            solve(i+1,currList,req-candidates[i],res,candidates,n);
            currList.remove(currList.size()-1);
        }
    }
}

/*

0 th index  1
1 st index  2, 2, 2, 5 
2 nd index  2, 2 5


solve(1,[1],4,res,...)
i=1,2,3,4
[1,2]

solve(2,[1,2],2,res,...)

i=2,3,4
[1,2,2]
 0 1 3

i=3 value=2

i=3
// solve(3,[1,2,2],0,res,....)
            0 1 2



Avoiding same element value at same index in the combination

candidates = [2,5,2,1,2], target = 5

[1, 2, 2, 2, 5]
 0  1  2  3  4


[1, 2, 2]
 0  1  2

[1, 2, 2]
 0  1  3

0 index - picked 1
1 index - not picked
2 index - curr=2 prev=2 [1,2]



res=[ [1,2,2] ]
       0 1 2

req=4  1
req=2  1+2

req=2 I'm index at 3 if I pick [1,2,2]
                                0 1 3



target=3
[1,2]
 0 1

[1,2]
 0 2

[1,2]
 0 3

combination = [0, 1, 2, 3, .....]


2,2,1 -> 1,2,2

2,1,2 -> 1,2,2

2,1,2 -> 1,2,2



*/