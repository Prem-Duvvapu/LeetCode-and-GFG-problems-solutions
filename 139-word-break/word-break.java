class Solution {
    Map<String,Boolean> map;
    public boolean func(int idx,String s,StringBuilder sb,HashSet<String> hs){
        if(idx==s.length()){
            if(hs.contains(sb.toString())){
                return true;
            }
            return false;
        }

        String key=idx+" "+sb.toString();
        if (map.containsKey(key))
            return map.get(key);
        
        if(!hs.contains(sb.toString())){
            sb.append(s.charAt(idx));
            return func(idx+1,s,sb,hs);
        }
        
        sb.append(s.charAt(idx));
        boolean x1=func(idx+1,s,sb,hs);
        sb.setLength(0);
        boolean x2=func(idx,s,sb,hs);
        map.put(key,(x1 || x2));
        return x1 || x2;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        map=new HashMap<>();
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            hs.add(wordDict.get(i));
        }

        return func(0,s,new StringBuilder(),hs);
        
    }
}