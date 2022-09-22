class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
      
        // traverse to farthest station you can get to
        
        // once you reach a point where you cannot make it to next station,
        // find max fuel station passed and check if you can make it using that fuel
        // if you cant, repeat, if you can move on.
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        int distance = 0;
        int fuel = startFuel;
        int visits = 0;
        
        for (int i = 0; i < stations.length; i++) {
            
            // if we have enough fuel to make to to target, return number of visits so far
            if (fuel >= (target - distance)) {
                return visits;
            }
            
            while (fuel < (stations[i][0] - distance)) {
                //if we cant make it to next station, and weve used all the fuel 
                // available so far return -1
                if (maxHeap.size() == 0) {
                    return -1;
                }
                
                fuel += maxHeap.poll();
                visits++;
            }
            
            // made it to next station, add fuel at the station to maxHeap and move us to that station
            fuel -= (stations[i][0] - distance);
            distance = stations[i][0];
            maxHeap.add(stations[i][1]);
        }
        
        System.out.format("%d, %d, %d\n", distance, visits, fuel);
        while (fuel < (target - distance)) {
                //if we cant make it to target, and weve used all the fuel 
                // available so far return -1
                if (maxHeap.size() == 0) {
                    return -1;
                } 
                fuel += maxHeap.poll();
                visits++;
            }
        return visits;
    }
}