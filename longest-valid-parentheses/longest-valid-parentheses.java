class Solution {
    public int longestValidParentheses(String s) {
        int res=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);

        for (int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if (ch=='(')
                stack.push(i);
            else
            {
                stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else
                    res=Math.max(i-stack.peek(),res);
            }
        }

        return res;
    }
}