import java.util.*;

class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());

        int ans = 0;
        int index = 0;

        for (int time : processorTime) {
            for (int i = 0; i < 4; i++) {
                ans = Math.max(ans, time + tasks.get(index));
                index++;
            }
        }

        return ans;
    }
}
