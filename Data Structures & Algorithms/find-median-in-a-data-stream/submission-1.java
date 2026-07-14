class MedianFinder {

    // largest to smallest
    private Queue<Integer> min = new PriorityQueue<>((a, b) -> b - a);
    // smallest to largest
    private Queue<Integer> max = new PriorityQueue<>((a, b) -> a - b);

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        min.add(num);
        if(min.size() - max.size() > 1 || !max.isEmpty() && max.peek() < min.peek()) {
            max.add(min.poll());
        }

        if(max.size() - min.size() > 1) {
            min.add(max.poll());
        }
    }
    
    public double findMedian() {
        if(min.size() == max.size()) {
            return (double) (min.peek() + max.peek()) / 2;
        } else if(min.size() > max.size()) {
            return (double) min.peek();
        } else {
            return (double) max.peek();
        }
    }
}
