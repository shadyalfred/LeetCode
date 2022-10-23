class TimeMap {
    class Entry {
        public String value;
        public int timestamp;
        public Entry(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    
    private HashMap<String, List<Entry>> dic = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if (! dic.containsKey(key))
            dic.put(key, new ArrayList<Entry>());
        
        dic.get(key).add(new Entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (! dic.containsKey(key)) {
            return "";
        }
        
        var entry = search(dic.get(key), timestamp);
        
        if (entry.timestamp <= timestamp) {
            return entry.value;
        }
        
        return "";
    }
    
    private Entry search(List<Entry> list, int targetTimestamp) {
        int l = 0;
        int h = list.size() - 1;
        Entry maxEntry = list.get(0);
        
        while (l <= h) {
            int mid = (l + h) / 2;
            
            var entry = list.get(mid);
            
            if (entry.timestamp == targetTimestamp) {
                return entry;
            } else if (entry.timestamp < targetTimestamp) {
                l = mid + 1;
                maxEntry = entry;   
            } else {
                h = mid - 1;
            }
        }
        
        return maxEntry;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */