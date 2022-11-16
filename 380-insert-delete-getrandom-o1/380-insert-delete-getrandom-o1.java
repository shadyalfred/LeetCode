class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map; // value -> index
    private Random rand = new Random();
    
    public RandomizedSet() {
        this.list = new ArrayList();       
        this.map = new HashMap();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        if (map.get(val) != list.size() - 1) {
            list.set(map.get(val), list.get(list.size() - 1));
            map.put(list.get(map.get(val)), map.get(val));
        }
        
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size())); 
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */