class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map; // value -> index
    private Random rand;
    
    public RandomizedSet() {
        this.list = new ArrayList();       
        this.map = new HashMap();
        this.rand = new Random();
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
        
        int lastIndex = list.size() - 1;
        int index = map.get(val);
        
        if (index != lastIndex) {
            list.set(index, list.get(lastIndex));
            map.put(list.get(index), index);
        }
        
        list.remove(lastIndex);
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