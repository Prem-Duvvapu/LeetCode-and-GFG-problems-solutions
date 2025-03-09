class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        Stack<Character> stack=new Stack<>();

        for (char ch: s.toCharArray()) {
            if (ch=='(' || ch=='{' || ch=='[') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty())
                return false;

            char top=stack.pop();
            if ((ch==')' && top!='(') || (ch=='}' && top!='{') || (ch==']' && top!='['))
                return false;      
        }

        return stack.isEmpty();
    }
}