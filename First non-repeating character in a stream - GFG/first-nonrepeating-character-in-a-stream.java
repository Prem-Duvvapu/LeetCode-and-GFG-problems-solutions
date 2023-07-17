//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code herej
        StringBuilder res=new StringBuilder();
        int[] cnt=new int[26];
        char lastChar=A.charAt(0);
        cnt[lastChar-'a']++;
        res.append(lastChar);
        Queue<Character> q=new LinkedList<>();
        q.add(lastChar);
        
        for (int i=1;i<A.length();i++)
        {
            char ch=A.charAt(i);
            cnt[ch-'a']++;
            if (cnt[ch-'a']==1)
                q.add(ch);
            if (cnt[lastChar-'a']==1)
                res.append(lastChar);
            else
            {
                while (!q.isEmpty() && cnt[q.peek()-'a']!=1)
                    q.poll();
                if (q.isEmpty())
                    res.append('#');
                else
                {
                    res.append(q.peek());
                    lastChar=q.peek();
                }
            }
        }
        
        return res.toString();
    }
}