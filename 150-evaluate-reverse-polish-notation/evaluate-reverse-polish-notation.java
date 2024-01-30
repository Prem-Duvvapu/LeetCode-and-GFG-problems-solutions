class Solution {
    public int evalRPN(String[] tokens) {
        int res=0;
        Stack<Integer> stack=new Stack<>();

        for (String s: tokens) {
            if (isOperator(s)) {
                int b=stack.pop();
                int a=stack.pop();
                int value=0;
                switch (s.charAt(0)) {
                    case '+':
                        value=a+b;
                        break;
                    case '-':
                        value=a-b;
                        break;
                    case '*':
                        value=a*b;
                        break;
                    default:
                        value=a/b;
                }
                stack.push(value);
            }
            else
                stack.push(Integer.parseInt(s));
        }

        return stack.pop();
    }

    private boolean isOperator(String opr) {
        return (opr.equals("+") || opr.equals("-") || opr.equals("*") || opr.equals("/"));
    }
}