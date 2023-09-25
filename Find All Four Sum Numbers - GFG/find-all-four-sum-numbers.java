//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Arrays.sort(arr);
        solve(0,4,k,new ArrayList<>(),arr,res);
        return res;
    }
    
    private void solve(int pos,int req,int target,List<Integer> currList,int[] arr,ArrayList<ArrayList<Integer>> res)
    {
        if (req==2)
        {
            int left=pos;
            int right=arr.length-1;
            
            while (left<right)
            {
                if (arr[left]+arr[right]<target)
                    left++;
                else if (arr[left]+arr[right]>target)
                    right--;
                else
                {
                    currList.add(arr[left]);
                    currList.add(arr[right]);
                    res.add(new ArrayList<>(currList));
                    
                    currList.remove(currList.size()-1);
                    currList.remove(currList.size()-1);
                    
                    left++;
                    right--;
                    while (left<right && arr[left]==arr[left-1])
                        left++;
                }
            }
            return;
        }
        
        for (int i=pos;i<arr.length;i++)
        {
            if (i>pos && arr[i]==arr[i-1])
                continue;
                
            currList.add(arr[i]);
            solve(i+1,req-1,target-arr[i],currList,arr,res);
            currList.remove(currList.size()-1);
        }
    }
}