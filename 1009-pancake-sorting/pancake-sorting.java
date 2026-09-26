class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        for (int size=n;size>1;size--) {
            int maxElementPos = 0;

            for (int i=1;i<size;i++) {
                if (arr[i] == size) {
                    maxElementPos = i;
                }
            }

            if (maxElementPos == size-1) {
                continue;
            }

            reverse(arr,0,maxElementPos);
            res.add(maxElementPos+1);
            reverse(arr,0,size-1);
            res.add(size);
        }  

        return res;
    }

    private void reverse(int[] arr,int left,int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}