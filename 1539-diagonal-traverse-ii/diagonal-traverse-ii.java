class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
     
        Map<Integer,ArrayList<Integer>> hm=new TreeMap<>();
        int len=0;
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                int key=i+j;
                if(hm.containsKey(key)){
                    hm.get(key).add(nums.get(i).get(j));
                }
                else{
                    hm.put(key,new ArrayList<Integer>());
                    hm.get(key).add(nums.get(i).get(j));
                }
                len++;
            }
        }
        int[] y=new int[len];
        int u=0;
        System.out.println("hashMap  "+hm);

        for(Map.Entry<Integer,ArrayList<Integer>> e:hm.entrySet()){
            ArrayList<Integer> c=e.getValue();
             for(int i=c.size()-1;i>=0;i--){
                    y[u]=c.get(i);
                    u++;
                }
        }

        return y;


    }
}