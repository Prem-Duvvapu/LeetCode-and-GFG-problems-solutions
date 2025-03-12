//Decreasing monotonic stack
class Pair {
    int pos;
    int value;

    Pair(int pos,int value) {
        this.pos=pos;
        this.value=value;
    }
}

class StockSpanner {
    Stack<Pair> stack;
    int currPos;

    public StockSpanner() {
        stack=new Stack<>();
        currPos=0;
    }
    
    public int next(int price) {
        while (!stack.isEmpty() && stack.peek().value<=price)
            stack.pop();

        int prevIndex=stack.isEmpty() ? -1: stack.peek().pos;
        int res=currPos-prevIndex;

        stack.push(new Pair(currPos,price));
        currPos++;

        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */