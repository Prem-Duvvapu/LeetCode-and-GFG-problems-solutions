class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        int currIndex=map.get(val);
        int lastIndex=list.size()-1;
        int lastElement=list.get(lastIndex);
        list.set(currIndex,lastElement);
        map.put(lastElement,currIndex);
        map.remove(val);
        list.remove(lastIndex);

        return true;
    }
    
    public int getRandom() {
        Random rand=new Random();
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