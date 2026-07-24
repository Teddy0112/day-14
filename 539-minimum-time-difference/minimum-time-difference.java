import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        
        if (n > 1440) {
            return 0;
        }

        boolean[] minutes = new boolean[1440];

        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            int total = hour * 60 + minute;

            if (minutes[total]) {
                return 0;
            }

            minutes[total] = true;
        }

        int first = -1;
        int prev = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < 1440; i++) {
            if (minutes[i]) {
                if (first == -1) {
                    first = i;
                }

                if (prev != -1) {
                    minDiff = Math.min(minDiff, i - prev);
                }

                prev = i;
            }
        }

        
        minDiff = Math.min(minDiff, 1440 - prev + first);

        return minDiff;
    }
}
