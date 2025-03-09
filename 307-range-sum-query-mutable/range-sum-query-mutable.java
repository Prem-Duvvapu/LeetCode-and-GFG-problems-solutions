class NumArray {
    SegmentTree st;
    int n;

    public NumArray(int[] nums) {
        n=nums.length;
        st=new SegmentTree(n);
        st.build(0,0,n-1,nums);
    }
    
    public void update(int index, int val) {
        st.update(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return st.query(0,0,n-1,left,right);
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

        seg[ind]=seg[2*ind+1]+seg[2*ind+2];
    }

    public void update(int ind,int low,int high,int pos,int val) {
        if (low==high) {
            seg[ind]=val;
            return;
        }

        int mid=low+(high-low)/2;
        if (pos<=mid)
            update(2*ind+1,low,mid,pos,val);
        else
            update(2*ind+2,mid+1,high,pos,val);

        seg[ind]=seg[2*ind+1]+seg[2*ind+2];
    }

    public int query(int ind,int low,int high,int l,int r) {
        //no overlap
        if (r<low || l>high)
            return 0;

        //completer overlap
        if (low>=l && high<=r)
            return seg[ind];

        //partial overlap
        int mid=low+(high-low)/2;
        int leftSum=query(2*ind+1,low,mid,l,r);
        int rightSum=query(2*ind+2,mid+1,high,l,r);
        return leftSum+rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */