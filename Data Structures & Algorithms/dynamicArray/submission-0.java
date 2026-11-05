class DynamicArray {
    private int[] array;
    private int length;
    private int capacity;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.array = new int[capacity];
    }

    public int get(int i) {
        if (i < length) {
            return array[i];
        }
        return -1;
    }

    public void set(int i, int n) {
        if (i < length) {
            array[i] = n;
        }
    }

    public void pushback(int n) {
        if (length == capacity) {
            this.resize();
        }
        array[length++] = n;
    }

    public int popback() {
        if (length > 0) {
            length--;
            return array[length];
        }
        return -1;
    }

    private void resize() {
        this.capacity = 2 * capacity;
        int[] newArray = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
