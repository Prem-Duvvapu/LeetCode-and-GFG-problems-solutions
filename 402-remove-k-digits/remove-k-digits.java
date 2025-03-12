class Solution {
    public String removeKdigits(String num, int k) {
        if (num.equals("0"))
            return num;

        int n=num.length();
        Stack<Character> stack=new Stack<>();
        StringBuilder res=new StringBuilder();

        for (int i=0;i<n;i++) {
            char ch=num.charAt(i);

            while (!stack.isEmpty() && (k>0 && stack.peek()>ch)) {
                stack.pop();
                k--;
            }

            if (stack.isEmpty() && ch=='0')
                continue;

            stack.push(ch);
        }

        while (!stack.isEmpty() && k>0) {
                stack.pop();
                k--;
        }
        
        if (stack.isEmpty())
            return "0";

        while (!stack.isEmpty())
            res.append(stack.pop());

        res.reverse();
        // int i=0;
        // while (res.length()>i && res.charAt(i)=='0')
        //     i++;

        // res.delete(0,i);
        
        // if (res.length()==0)
        //     return "0";

        return res.toString();
    }
}