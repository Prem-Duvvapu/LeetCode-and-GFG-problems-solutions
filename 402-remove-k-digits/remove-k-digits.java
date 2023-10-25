//Monotonic Stack
class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> stack=new Stack<>();
        StringBuilder res=new StringBuilder();

        for (int i=0;i<n;i++)
        {
            while (!stack.isEmpty() && stack.peek()>num.charAt(i) && k>0)
            {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
        }

        while (k-- > 0)
            stack.pop();

        if (stack.isEmpty())
            return "0";

        while (!stack.isEmpty())
            res.append(stack.pop());

        while (res.length()>1 && res.charAt(res.length()-1)=='0')
            res.deleteCharAt(res.length()-1);

        res.reverse();
        return res.toString();
    }
}