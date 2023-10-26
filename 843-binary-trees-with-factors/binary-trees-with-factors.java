//Similar to LIS
class Solution {
  long mod=(long)(1e9)+7;

  public int numFactoredBinaryTrees(int[] arr) {
    int n=arr.length;
    long result=0;
    Map<Integer,Long> map=new HashMap<>();
    long count=1;
    
    Arrays.sort(arr);

    map.put(arr[0],count);
    for (int i=1;i<n;i++)
    {
      int root=arr[i];
      count=1;

      for (int j=0;j<i;j++)
      {
        int leftNode=arr[j];

        if (root%leftNode==0 && map.containsKey(root/leftNode))
          count+=(map.get(leftNode)*map.get(root/leftNode)); 
      }

      map.put(root,count);
    }

    for (Map.Entry<Integer,Long> m: map.entrySet())
      result=(result+m.getValue())%mod;

    return (int)result;
  }
}