class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<n;i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }

            if (stack.isEmpty() || stack.peek()<0) {
                stack.push(asteroids[i]);
                continue;
            }

            if (stack.peek() > Math.abs(asteroids[i])) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek()>0 && stack.peek() < Math.abs(asteroids[i])) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek()+asteroids[i] == 0) {
                stack.pop();
                continue;
            }

            if (stack.isEmpty() || stack.peek()<0) {
                stack.push(asteroids[i]);
            }
        }

        int[] res = new int[stack.size()];
        int pos = res.length-1;
        while (!stack.isEmpty()) {
            res[pos] = stack.pop();
            pos--;
        }

        return res;
    }
}