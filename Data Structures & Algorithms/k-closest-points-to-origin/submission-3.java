class Solution {

    public double distance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Double[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b[1], a[1]));

        for (int i = 0; i < points.length; i++) {
            int[] coord = points[i];
            double dist = distance(coord);
            maxHeap.offer(new Double[]{(double) i, dist});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] output = new int[k][2];
        int index = 0;
        while (k > 0) {
            int pointIndex = maxHeap.poll()[0].intValue();
            output[index++] = points[pointIndex];
            k--;
        }
        return output;
    }
}
