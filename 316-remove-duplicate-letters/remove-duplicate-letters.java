//Monotonic Stack
class Solution {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        int[] last=new int[26];
        boolean[] visited=new boolean[26];

        for (int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            last[ch-'a']=i;
        }

        for (int i=0;i<n;i++)
        {
            char ch=s.charAt(i);

            if (visited[ch-'a']==true)
                continue;

            while (!stack.isEmpty() && stack.peek()>ch && last[stack.peek()-'a']>i)
                visited[stack.pop()-'a']=false;

            stack.push(ch);
            visited[ch-'a']=true;
        }

        StringBuilder res=new StringBuilder();
        while (!stack.isEmpty())
            res.append(stack.pop());

        res.reverse();
        return res.toString();
    }
}