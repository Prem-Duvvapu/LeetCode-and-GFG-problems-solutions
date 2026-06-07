class Solution {
    public String removeKdigits(String num, int k) {
        if ("0".equals(num)) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        for (char ch: num.toCharArray()) {
            while (!stack.isEmpty() && ch < stack.peek()) {
                if (k > 0) {
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }
            stack.push(ch);
        }

        while (!stack.isEmpty() && k>0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        while (res.length()>0 && res.charAt(res.length()-1) == '0') {
            res.deleteCharAt(res.length()-1);
        }

        if (res.length() == 0) {
            return "0";
        }

        return res.reverse().toString();
    }
}