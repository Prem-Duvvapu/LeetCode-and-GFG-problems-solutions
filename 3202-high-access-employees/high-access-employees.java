class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        int n=access_times.size();
        Map<String,List<Integer>> map=new HashMap<>();
        List<String> res=new ArrayList<>();

        for (int i=0;i<n;i++)
        {
            List<String> curr=access_times.get(i);
            String name=curr.get(0);
            String time=curr.get(1);
            int minutes=Integer.parseInt(time.substring(0,2))*60+Integer.parseInt(time.substring(2));
            if (!map.containsKey(name))
                map.put(name,new ArrayList<>());
            map.get(name).add(minutes);
        }

        for (Map.Entry<String,List<Integer>> m: map.entrySet())
        {
            Collections.sort(m.getValue());
            // System.out.println(m.getValue());
            if (m.getValue().size()<3)
                continue;

            for (int i=2;i<m.getValue().size();i++)
            {
                if (m.getValue().get(i)-m.getValue().get(i-2)<60)
                {
                    res.add(m.getKey());
                    break;
                }
            }
        }

        return res;
    }
}