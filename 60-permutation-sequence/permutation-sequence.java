class Solution {
    int k=0;
    private void swap(char[] a,int i,int j)
    {
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private void permutations(int pos,char[] a,String[] list)
    {
        if (pos==a.length)
        {
            list[k]=new String(a);
            k++;
            return;
        }

        for (int i=pos;i<a.length;i++)
        {
            swap(a,pos,i);
            permutations(pos+1,a,list);
            swap(a,pos,i);
        }
    }

    public String getPermutation(int n, int k) {
        int fact=1;
        for (int i=1;i<=n;i++)
            fact*=i;
        String[] list=new String[fact];
        int num=0;
        for (int i=1;i<=n;i++)
            num=num*10+i;
        String s=Integer.toString(num);
        char[] arr=s.toCharArray();
        permutations(0,arr,list);
        Arrays.sort(list);
        return list[k-1];
    }
}