class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWait = 0;
        int currentTime = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int service = customer[1];

            if (currentTime < arrival) {
                currentTime = arrival;
            }

            currentTime += service;

            totalWait += currentTime - arrival;
        }

        return (double) totalWait / customers.length;
    }
}
