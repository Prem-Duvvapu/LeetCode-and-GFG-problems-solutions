class NumberContainers {
    Map<Integer,SortedSet<Integer>> numMap;
    Map<Integer,Integer> indexMap;

    public NumberContainers() {
        numMap=new HashMap<>();
        indexMap=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (numMap.containsKey(indexMap.get(index)))
            numMap.get(indexMap.get(index)).remove(index);

        numMap.putIfAbsent(number,new TreeSet<>());
        numMap.get(number).add(index);
        indexMap.put(index,number);
    }
    
    public int find(int number) {
        if (!numMap.containsKey(number) || numMap.get(number).size()==0)
            return -1;

        return numMap.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */