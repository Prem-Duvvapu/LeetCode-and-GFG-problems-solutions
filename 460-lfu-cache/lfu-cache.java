class Pair {
    int freq;
    int val;

    Pair(int freq,int val) {
        this.freq=freq;
        this.val=val;
    }
}

class LFUCache {
    Map<Integer,Pair> cache;
    Map<Integer,LinkedHashSet<Integer>> frequencyKeys;
    int minFreq;
    int capacity;

    public LFUCache(int capacity) {
        cache=new HashMap<>();
        frequencyKeys=new HashMap<>();
        minFreq=0;
        this.capacity=capacity;
    }

    //custom method
    public void insert(int key,int freq,int val) {
        cache.put(key,new Pair(freq,val));
        frequencyKeys.putIfAbsent(freq,new LinkedHashSet<>());
        frequencyKeys.get(freq).add(key);
    }
    
    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        Pair freqAndVal=cache.get(key);
        int freq=freqAndVal.freq;
        int val=freqAndVal.val;
        Set<Integer> keys=frequencyKeys.get(freq);
        int newFreq=freq+1;

        keys.remove(key);
        if (keys.isEmpty()) {
            frequencyKeys.remove(freq);

            if (freq==minFreq)
                minFreq=newFreq;
        }

        insert(key,newFreq,val);

        return val;
    }
    
    public void put(int key, int value) {
        Pair freqAndVal=cache.get(key);
        if (freqAndVal!=null) {
            cache.put(key,new Pair(freqAndVal.freq,value));
            get(key);
            return;
        }

        if (cache.size()==capacity) {
            Set<Integer> keys=frequencyKeys.get(minFreq);
            int keyToDelete=keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);

            if (keys.isEmpty())
                frequencyKeys.remove(minFreq);
        }

        minFreq=1;
        insert(key,1,value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */