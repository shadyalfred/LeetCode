class Solution {
    class Car {
        public int position;
        public int speed;
        public double time;
        
        public Car(int position, int speed, int target) {
            this.position = position;
            this.speed = speed;
            
            this.time = (target - position) / (double) speed;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(position[i], speed[i], target);
        }
        
        Arrays.sort(cars, Comparator.comparingInt(c -> c.position));
        
        Stack<Car> stack = new Stack<>();
        
        for (int i = cars.length - 1; i >= 0; i--) {
            var car = cars[i];
            
            if (! stack.empty() && car.time <= stack.peek().time) {
                continue;
            }
            
            stack.push(car);
        }
        
        return stack.size();
    }
}