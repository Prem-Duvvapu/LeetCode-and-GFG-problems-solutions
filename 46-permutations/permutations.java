class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        solve(0,new ArrayList<>(),res,nums,n);

        return res;
    }

    public void solve(int pos,List<Integer> currList,List<List<Integer>> res,int[] nums,int n) {
        if (pos==n) {
            res.add(new ArrayList<>(currList));
            return;
        }

        for (int i=pos;i<n;i++) {
            swap(nums,i,pos);
            currList.add(nums[pos]);
            solve(pos+1,currList,res,nums,n);
            currList.remove(currList.size()-1);
            swap(nums,i,pos);
        }
    }

    public void swap(int[] arr,int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}