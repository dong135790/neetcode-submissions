class MedianFinder {
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    public MedianFinder() {
        this.min = new PriorityQueue<>();
        this.max = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
    }
    
    public void addNum(int num) {
        max.offer(num);
        if (max.size() - min.size() > 1 ||
            !min.isEmpty() && max.peek() > min.peek()) {
                min.offer(max.poll());
            }

        if (min.size() - max.size() > 1) {
            max.offer(min.poll());
        }
    }
    
    // max [1] 
    // min [2, 3, 4]
    public double findMedian() {
        if (min.size() == max.size()) {
            return (double) (min.peek() + max.peek()) / 2;
        } else if (min.size() > max.size()) {
            return (double) min.peek();
        } else {
            return (double) max.peek();
        }
    }
}
