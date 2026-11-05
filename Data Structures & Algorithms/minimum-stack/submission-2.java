class MinStack {
    int size;
    List<Integer> array;

    public MinStack() {
        this.size = 0;
        array = new ArrayList<>();
    }
    
    public void push(int val) {
        array.add(val);
        size++;
    }
    
    public void pop() {
        if (size > 0) {
            array.remove(size - 1);
            size--;
        }
    }
    
    public int top() {
        if (size > 0) {
            return array.get(size -1);
        }
        return -1;
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int n: array) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }
}
