//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<N;i++)
        {
            if (stack.isEmpty() || asteroids[i]>0)
                stack.push(asteroids[i]);
            else
            {
                while (!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(asteroids[i]))
                    stack.pop();
                    
                if (!stack.isEmpty() && stack.peek()+asteroids[i]==0)
                    stack.pop();
                else if (stack.isEmpty() || stack.peek()<0)
                    stack.push(asteroids[i]);
            }
        }
        
        int[] res=new int[stack.size()];
        for (int i=stack.size()-1;i>=0;i--)
            res[i]=stack.pop();
            
        return res;
    }
}
