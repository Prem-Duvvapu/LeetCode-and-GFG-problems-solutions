class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    boolean isEven;

    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>((x,y) -> Integer.compare(y,x));
        isEven=true;
    }
    
    public void addNum(int num) {
        if (isEven) { //curr size is even
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else { //curr size is odd
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }

        isEven=!isEven;
    }
    
    public double findMedian() {
        double median=0.0;

        if (isEven) {
            int first=maxHeap.peek();
            int second=minHeap.peek();
            median=(first+second)/2.0;
        } else {
            median=(double)minHeap.peek();
        }

        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */