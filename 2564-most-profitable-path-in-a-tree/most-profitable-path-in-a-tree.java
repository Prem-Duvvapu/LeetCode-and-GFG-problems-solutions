class Solution {
    public boolean funcBob(int node,int time,HashMap<Integer,Integer> hm,int[] vis,List<List<Integer>> arr){
        if(node==0){
            hm.put(0,time);
            return true;
        }
        vis[node]=1;
        hm.put(node,time);
        for(int i=0;i<arr.get(node).size();i++){
            if(vis[arr.get(node).get(i)]==0){
                if(funcBob(arr.get(node).get(i),time+1,hm,vis,arr)){
                    return true;
                }
            }
        }
        vis[node]=0;
        hm.remove(node);
        return false;
    }

    public int funcAlice(int node,int time,HashMap<Integer,Integer> hm,List<List<Integer>> arr,int[] vis,int[] amount){
        // if(arr.get(node).size()==1 && node!=0){
        //     if(hm.containsKey(node)){
        //         int bobTime=hm.get(node);
        //         if(time<bobTime){
        //             return amount[node];
        //         }
        //         else if(time==bobTime){
        //             return amount[node]/2;
        //         }
        //         else return 0;
        //     }
        //     return amount[node];
        // }
        
        int max=Integer.MIN_VALUE;
        vis[node]=1;
        int cur=0;

        if(hm.containsKey(node)){
                int bobTime=hm.get(node);
                if(time<bobTime){
                    cur=amount[node];
                }
                else if(time==bobTime){
                    cur=amount[node]/2;
                }
                else cur=0;
        }
        else{
            cur=amount[node];
        }

        if(arr.get(node).size()==1 && node!=0) return cur;
       
        for(int i=0;i<arr.get(node).size();i++){
            if(vis[arr.get(node).get(i)]!=1){
                max=Math.max(max,cur+funcAlice(arr.get(node).get(i),time+1,hm,arr,vis,amount));
            }
        }
        
        vis[node]=0;
        return max;

    }
    
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        List<List<Integer>> arr=new ArrayList<>();

        int[] visA=new int[n];
        int[] visB=new int[n];

        for(int i=0;i<n;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            arr.get(edges[i][0]).add(edges[i][1]);
            arr.get(edges[i][1]).add(edges[i][0]);
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        boolean aaa=funcBob(bob,0,hm,visB,arr);
        System.out.println(hm);
        return funcAlice(0,0,hm,arr,visA,amount);
    }
}