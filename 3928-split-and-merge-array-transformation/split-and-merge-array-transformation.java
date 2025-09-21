class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<String> set= new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int level = 0;
        String src = "";

        for (int i=0;i<n;i++)
            src += ""+i;

        q.add(src);
        set.add(src);

        while (!q.isEmpty()) {
            int qlen = q.size();

            while (qlen-- > 0) {
                String curr = q.poll();
                boolean match = true;

                for (int i=0;i<n;i++)
                    if (nums1[curr.charAt(i) - '0'] != nums2[i])
                        match = false;

                if (match)
                    return level;

                for (int i=0;i<n;i++) {
                    for (int j=i;j<n;j++) {
                        String base = curr.substring(0,i) + curr.substring(j+1);
                        String sub = curr.substring(i,j+1);

                        for (int k=0;k<=base.length();k++) {
                            StringBuilder sb = new StringBuilder(base);
                            sb.insert(k,sub);

                            if (set.contains(sb.toString()))
                                continue;

                            q.add(sb.toString());
                            set.add(sb.toString());
                        }
                    }
                }
            }

            level++;
        }


        return -1;
    }
}