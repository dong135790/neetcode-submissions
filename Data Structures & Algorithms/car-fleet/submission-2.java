class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Should we figure out how long each car will take to reach the target? will that help determine how many fleets?
        // Deque<double[]> stack = new ArrayDeque<>();
        double fastest = 0;
        double[][] cars = new double[position.length][2];

        int fleet = 0;
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        for (double[] car: cars) {
            double time = (target - car[0]) / car[1];
            if (time <= fastest ) {
                time = fastest;
            } else {
                fleet++;
            }
            fastest = time;
        }
        return fleet;

    }
}

// 0 4 2
// 2 1 3
// 5 6 2.66
// [4, 6], [2, 2.66], [0, 5]


// 4 1   0  7
// 2 2   1  1
// 3 4.5 10 3

// [4, 3], [0,10], [1, 4.5], [7,3]
// Sorted from closest -> furthest from target
// [7, 3], [4, 3], [1, 4.5], [0, 10] 