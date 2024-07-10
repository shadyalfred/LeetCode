class Solution {
    public double averageWaitingTime(int[][] customers) {
        double currTime = customers[0][0];

        double waitingTimes = 0;

        for (int[] customer : customers) {
            int arriveTime = customer[0];
            int neededTime = customer[1];

            if (arriveTime <= currTime) {
                currTime += neededTime;
            } else {
                currTime = arriveTime + neededTime;
            }

            waitingTimes += currTime - arriveTime;
        }


        return waitingTimes / customers.length;
    }
}