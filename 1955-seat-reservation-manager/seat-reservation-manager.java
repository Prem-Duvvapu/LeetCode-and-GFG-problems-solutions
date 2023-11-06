class SeatManager {
    int last;
    PriorityQueue<Integer> q;

    public SeatManager(int n) {
        last=1;
        q=new PriorityQueue<>();
    }
    
    public int reserve() {
        if (!q.isEmpty())
            return q.poll();

        return last++;
    }
    
    public void unreserve(int seatNumber) {
        q.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */