class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> stack=new Stack<>();
        int[] res;

        for (int i=0;i<n;i++) {
            if (asteroids[i]>0) {
                stack.push(asteroids[i]);
                continue;
            }

            while (!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(asteroids[i]))
                stack.pop();

            if (!stack.isEmpty() && stack.peek()==Math.abs(asteroids[i])) {
                stack.pop();
                continue;
            }

            if (stack.isEmpty() || stack.peek()<0)
                stack.push(asteroids[i]);
        }
        
        res=new int[stack.size()];
        for (int i=res.length-1;i>=0;i--)
            res[i]=stack.pop();

        return res;
    }
}