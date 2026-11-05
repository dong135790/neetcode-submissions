class MedianFinder {

    List<Double> list;

    public MedianFinder() {
        this.list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add((double) num);
    }
    
    public double findMedian() {
        Collections.sort(list);
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
