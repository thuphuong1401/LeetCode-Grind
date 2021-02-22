/*
https://leetcode.com/problems/design-underground-system/
*/

class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> checkInTime; // {id, (stationName, checkInTime)}
    Map<String, Pair<Integer, Integer>> journeyTime; // {start->end journey, (totalJourneyTime, count)}
    
    public UndergroundSystem() {
        this.checkInTime = new HashMap<>();
        this.journeyTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInTime.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> start = checkInTime.get(id);
        String startPlace = start.getKey();
        int startTime = start.getValue();
        String journey = startPlace + "->" + stationName;
        int timeTravelled = t - startTime;
        Pair<Integer, Integer> checkOut = journeyTime.getOrDefault(journey, new Pair<>(0, 0));
        journeyTime.put(journey, new Pair<>(checkOut.getKey() + timeTravelled, checkOut.getValue() + 1));  
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String journey = startStation + "->" + endStation;
        double totalTime = journeyTime.get(journey).getKey();
        double count = journeyTime.get(journey).getValue();
        return (double)(totalTime/count);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
