class Solution {
    class Point {
        public int x;
        public int y;
        public double distance;
        
        public Point(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        var minHeap = new PriorityQueue<Point>(
            (p1, p2) -> Double.compare(p1.distance, p2.distance)
        );
        
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            var distance = Math.sqrt(x * x + y * y);
            
            minHeap.offer(new Point(x, y, distance));
        }
        
        List<List<Integer>> minPoints = new ArrayList();
        
        while (k > 0) {
            var point = minHeap.poll();
            
            minPoints.add(Arrays.asList(point.x, point.y));
            
            k--;
        }
        
        
        return minPoints.stream().map(u -> u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
    }
}