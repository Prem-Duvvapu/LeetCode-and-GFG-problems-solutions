class Solution {
    public String decodeString(String s) {
        StringBuilder sb=new StringBuilder("");
        StringBuilder temp=new StringBuilder("");
        Stack<Integer> numStack=new Stack<>();
        Stack<String> strStack=new Stack<>();

        for (int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);

            if (Character.isDigit(ch))
            {
                int num=ch-'0';
                while (i+1<s.length() && Character.isDigit(s.charAt(i+1)))
                {
                    num=num*10+s.charAt(i+1)-'0';
                    i++;
                }
                numStack.push(num);
            }
            else if (ch=='[')
            {
                strStack.push(sb.toString());
                sb.setLength(0);
            }
            else if (Character.isAlphabetic(ch))
                sb.append(ch);
            else
            {
                temp.append(strStack.pop());
                int val=numStack.pop();
                String curr=sb.toString();
                while (--val!=0)
                    sb.append(curr);
                temp.append(sb);
                sb=new StringBuilder(temp);
                temp.setLength(0);
            }
        }

        return sb.toString();
    }
}