/*
https://leetcode.com/problems/time-based-key-value-store/
*/

class Pair {
    String value;
    int timestamp;
    
    public Pair(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {

    Map<String, List<Pair>> map;
    
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair newPair = new Pair(value, timestamp);
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(newPair);
    }
    
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Pair> allValues = map.get(key);
        int l = 0;
        int r = allValues.size() - 1;
        int ans = -1;
        if(timestamp >= allValues.get(r).timestamp) {
            return allValues.get(r).value;
        }
        while(l <= r) {
            int mid = l + (r - l)/2;
            int currTimeStamp = allValues.get(mid).timestamp;
            if(currTimeStamp == timestamp) {
                ans = mid;
                break;
            } else if(currTimeStamp < timestamp) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        if(ans == -1) {
            return "";
        }
        String val = allValues.get(ans).value;
        return val;
    }
    
    
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
