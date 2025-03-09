class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int res=0;
        int n=fruits.length;

        SegmentTree sg=new SegmentTree(n);
        sg.build(0,0,n-1,baskets);
        
        for (int i=0;i<n;i++)
            if (!sg.query(0,0,n-1,fruits[i]))
                res++;

        return res;
    }
}

class SegmentTree {
    int[] seg;

    SegmentTree(int n) {
        seg=new int[4*n];
    }

    public void build(int ind,int low,int high,int[] arr) {
        if (low==high) {
            seg[ind]=arr[low];
            return;
        }

        int mid=low+(high-low)/2;
        build(2*ind+1,low,mid,arr);
        build(2*ind+2,mid+1,high,arr);

        seg[ind]=Math.max(seg[2*ind+1],seg[2*ind+2]);
    }

    public boolean query(int ind,int low,int high,int val) {
        if (seg[ind]<val)
            return false;
        
        if (low==high) {
            seg[ind]=0;
            return true;
        }

        int mid=low+(high-low)/2;
        boolean res1=query(2*ind+1,low,mid,val);

        if (res1) {
            seg[ind]=Math.max(seg[2*ind+1],seg[2*ind+2]);
            return res1;
        }
            

        boolean res2=query(2*ind+2,mid+1,high,val);
        seg[ind]=Math.max(seg[2*ind+1],seg[2*ind+2]);
        return res2;
    }
}