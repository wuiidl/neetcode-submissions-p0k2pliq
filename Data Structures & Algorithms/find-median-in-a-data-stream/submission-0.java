class MedianFinder {
    // largest on top
    private Queue<Integer> smallHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    // smallest on top
    private Queue<Integer> largeHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

    public MedianFinder() {}
    
    public void addNum(int num) {
        smallHeap.offer(num);
        if(smallHeap.size() - largeHeap.size() > 1 || 
        !largeHeap.isEmpty() &&
        smallHeap.peek() > largeHeap.peek()
        ) {
            largeHeap.offer(smallHeap.poll());
        }
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }

    
    public double findMedian() {
        if(smallHeap.size() == largeHeap.size()) {
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
        }else if(smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        }else{
            return (double) largeHeap.peek();
        }
    }
}
