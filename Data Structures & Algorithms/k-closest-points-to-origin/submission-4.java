class Solution {

    public int distance(int[] point) {
        return (point[0] * point[0] + point[1] * point[1]);
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));

        for (int i = 0; i < points.length; i++) {
            int[] coord = points[i];
            int dist = distance(coord);
            maxHeap.offer(new int[]{i, dist});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] output = new int[k][2];
        int index = 0;
        while (k > 0) {
            int pointIndex = maxHeap.poll()[0];
            output[index++] = points[pointIndex];
            k--;
        }
        return output;
    }
}
