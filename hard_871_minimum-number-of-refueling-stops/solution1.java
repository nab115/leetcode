class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
         int x = minRefuelStops(target, startFuel, 0, 0, 0, stations);
        
        if (x > stations.length) {
            return -1;
        }
        
        return x;
    }
    
    int minRefuelStops(int target, int fuel, int distance, int visits, int passed, int[][] stations) {
        
        // System.out.format("Visits : %d, Passed: %d, Distance : %d, Fuel : %d, Target: %d\n", visits, passed, distance, fuel, target);
        // if we have enough fuel to get to target, 
        // return number of gas stations visited so far
        if (fuel >= (target - distance)) {
            return visits;
        }
        
        // if there are no more gas stations and we dont have enougb fuel to get to dest
        // OR if we dont have enough fuel to get to the next gas station, return
        if ((passed == stations.length) || (fuel < (stations[passed][0] - distance))) {
            return stations.length + 1;
        }
        
        // recurse into 2 options : visit next gas station and do not visit next gas station
        return Math.min(
            minRefuelStops(
                target
                , fuel - (stations[passed][0] - distance) + stations[passed][1]
                , stations[passed][0]
                , visits + 1
                , passed + 1
                , stations
            )
            , minRefuelStops(
                target
                , fuel - (stations[passed][0] - distance)
                , stations[passed][0]
                , visits
                , passed + 1
                , stations
            )
        );
    }
}