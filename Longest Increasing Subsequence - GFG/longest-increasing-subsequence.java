//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int binSearch(List<Integer> list,int val)
    {
        int left=0;
        int right=list.size()-1;
        
        while (left<=right)
        {
            int mid=left+(right-left)/2;

            if (val==list.get(mid))
                return mid;
            else if (val<list.get(mid))
                right=mid-1;
            else
                left=mid+1;
        }

        return right+1;
    }

    static int longestSubsequence(int n,int[] nums) {
        int res=1;
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);

        for (int i=1;i<nums.length;i++)
        {
            if (nums[i]>list.get(res-1))
            {
                list.add(nums[i]);
                res++;
            }
            else
            {
                int index=binSearch(list,nums[i]);
                list.set(index,nums[i]);
            }
        }

        return res;
    }
} 