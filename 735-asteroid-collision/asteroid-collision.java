class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            //if current is positive
            if (asteroids[i]>0) {
                stack.push(asteroids[i]);
                continue;
            }

            //current one is negative
            //1. stack is empty
            //2. top is negative
            //3. top is positive
            if (stack.isEmpty() || stack.peek()<0) {
                stack.push(asteroids[i]);
                continue;
            }

            //top one is positive

            //positive is bigger one
            if (stack.peek()>Math.abs(asteroids[i]))
                continue;

            //negative is bigger one
            while (!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(asteroids[i]))
                stack.pop();

            //1. stack is empty
            //2. top is negative
            if (stack.isEmpty() || stack.peek()<0) {
                stack.push(asteroids[i]);
                continue;
            }

            //top is positive

            //1. top is equal in size
            //2. top is bigger in size
            if (stack.peek()+asteroids[i]==0) {
                stack.pop();
                continue;
            }
        }

        int[] res=new int[stack.size()];
        int pos=res.length-1;
        while (!stack.isEmpty())
            res[pos--]=stack.pop();

        return res;
    }
}

/*

tc1
[1,2,3]
exp: [1,2,3]

tc2
[-1,-2,-3]
exp: [-1,-2,-3]

tc3
[5,-2]
exp: [5]

tc4
[-3,5,4,-6]
exp: [-3,-6]

tc5
[8,-8]
exp: []

*/

