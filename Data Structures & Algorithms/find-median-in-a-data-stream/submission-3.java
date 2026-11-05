class MedianFinder {

    List<Double> list;
    boolean sorted;
    public MedianFinder() {
        this.list = new ArrayList<>();
        this.sorted = false;
    }
    
    public void addNum(int num) {
        list.add((double) num);
        this.sorted = false;
    }
    
    public double findMedian() {
        if (this.sorted == false) {
            Collections.sort(list);
            this.sorted = true;
        }
        int size = list.size();
        if (size % 2 == 1) {
            return list.get(size/2);
        } else {
            int left = size/2 - 1;
            int right = size/2;
            return (list.get(left) + list.get(right)) / 2;
        }
    }
}
