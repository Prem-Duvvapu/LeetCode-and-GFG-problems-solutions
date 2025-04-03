class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();

        Stack<Character> stack=new Stack<>();
        Stack<Character> stack2=new Stack<>();
        StringBuilder res=new StringBuilder();

        for (char ch: num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek()>ch && k>0) {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        while (k-- >0)
            stack.pop();

        while (!stack.isEmpty())
            stack2.push(stack.pop());

        while (!stack2.isEmpty() && stack2.peek()=='0')
            stack2.pop();
        
        if (stack2.isEmpty())
            return "0";

        while (!stack2.isEmpty())
            res.append(stack2.pop());

        return res.toString();
    }
}

/*
1432219 k=3

1000 k=1
1000 k=3

000 k=2

1020 k=2
10030 k=1
*/