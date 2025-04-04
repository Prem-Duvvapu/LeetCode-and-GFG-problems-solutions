class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        Stack<Character> stack=new Stack<>();
        Stack<Character> stack2=new Stack<>();

        for (char ch: num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek()>ch && k>0) {
                stack.pop();
                k--;
            }

            stack.push(ch);
        }

        while (k-- > 0)
            stack.pop();
        

        while (!stack.isEmpty())
            stack2.push(stack.pop());

        while (!stack2.isEmpty() && stack2.peek()=='0')
            stack2.pop();

        if (stack2.isEmpty())
            return "0";

        StringBuilder res=new StringBuilder();
        while (!stack2.isEmpty())
            res.append(stack2.pop());
        

        return res.toString();
    }
}



/*
num = 1 4 3 2 2 1 9
      0 1 2 3 4 5 6
                  ^
k = 1
initialK=6
n=7

ans = oneDigit

1*10,00,000 + 4*1,00,000 + 3*10,000 + 2*1,000 + 2*100 + 1*10 + 9

a*1000+b*100+c*10+d

4*1000



5           1
stack      val
index

1


nums = 7 5 3
k=0
expected_ans=53

3
5


nums=357
k=2

expected_ans=3

7
5
3

3 3 3
3 5 7






 6      9  9
 5      1  10
 3      2  200
 0      1  1000

stack  val
index

9121

1219


1000  k=1   expected_ans=0

1000  k=3  expected_ans=0

10000000789 k=3  expected_ans=


7

9
8
7
0


987

789


*/