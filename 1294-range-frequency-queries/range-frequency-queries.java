class RangeFreqQuery {
    SGTree sgt;
    int n;

    public RangeFreqQuery(int[] arr) {
        n=arr.length;
        sgt=new SGTree(n);
        sgt.build(0,0,n-1,arr);
    }
    
    public int query(int left, int right, int value) {
        return sgt.query(0,0,n-1,left,right,value);
    }
}

class SGTree
{
    Map<Integer,Integer>[] seg;

    SGTree(int n)
    {
        seg=new HashMap[4*n];
    }

    public void build(int ind,int low,int high,int[] arr)
    {
        if (low==high)
        {
            seg[ind]=new HashMap<>();
            seg[ind].put(arr[low],1);
            return;
        }

        int mid=low+(high-low)/2;
        build(2*ind+1,low,mid,arr);
        build(2*ind+2,mid+1,high,arr);

        seg[ind]=new HashMap<>();

        for (Map.Entry<Integer,Integer> m: seg[2*ind+1].entrySet())
            seg[ind].put(m.getKey(),seg[ind].getOrDefault(m.getKey(),0)+m.getValue());

        for (Map.Entry<Integer,Integer> m: seg[2*ind+2].entrySet())
            seg[ind].put(m.getKey(),seg[ind].getOrDefault(m.getKey(),0)+m.getValue());
    }

    public int query(int ind,int low,int high,int l,int r,int val)
    {
        //no overlap
        if (high<l || low>r)
            return 0;

        //complete overlap
        if (low>=l && high<=r)
            return seg[ind].getOrDefault(val,0);
        
        //partial overlap
        int mid=low+(high-low)/2;
        int left=query(2*ind+1,low,mid,l,r,val);
        int right=query(2*ind+2,mid+1,high,l,r,val);

        int cnt=left+right;
        return cnt;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */