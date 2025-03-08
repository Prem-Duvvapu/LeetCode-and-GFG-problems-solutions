class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    boolean even;

    public MedianFinder() {
        maxHeap=new PriorityQueue<>((a,b)->(b-a));
        minHeap=new PriorityQueue<>();
        even=true;
    }
    
    public void addNum(int num) {
        if (even) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }

        even=!even;
    }
    
    public double findMedian() {
        int total=minHeap.size()+maxHeap.size();
        if ((total&1)==1)
            return (double)maxHeap.peek();

        double median=((double)maxHeap.peek()+minHeap.peek())/2.0;
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */