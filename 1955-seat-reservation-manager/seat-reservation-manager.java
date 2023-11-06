class SeatManager {
    boolean[] arr;
    int last;
    PriorityQueue<Integer> q;

    public SeatManager(int n) {
        last=1;
        arr=new boolean[n+1];
        q=new PriorityQueue<>();
    }
    
    public int reserve() {
        if (!q.isEmpty())
        {
            arr[q.peek()]=true;
            return q.poll();
        }
        arr[last]=true;
        return last++;
    }
    
    public void unreserve(int seatNumber) {
        arr[seatNumber]=false;
        q.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */