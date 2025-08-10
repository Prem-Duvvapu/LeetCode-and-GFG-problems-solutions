class DisjointSet {
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int getUltimateParent(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = getUltimateParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int ultParU = getUltimateParent(u);
        int ultParV = getUltimateParent(v);

        if (ultParU == ultParV)
            return;

        if (size[ultParU] >= size[ultParV]) {
            size[ultParU] += size[ultParV];
            parent[ultParV] = ultParU;
        } else {
            size[ultParV] += size[ultParU];
            parent[ultParU] = ultParV;
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> mailToParent = new HashMap<>();
        Map<Integer, List<String>> parentToMails = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=1; j<accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (!mailToParent.containsKey(email))
                    mailToParent.put(email, i);
                else
                    ds.unionBySize(mailToParent.get(email), i);
            }
        }

        for (Map.Entry<String, Integer> m: mailToParent.entrySet()) {
            String email = m.getKey();
            int parent = m.getValue();
            int ultParent = ds.getUltimateParent(parent);

            if (!parentToMails.containsKey(ultParent))
                parentToMails.put(ultParent, new ArrayList<>(Arrays.asList(accounts.get(ultParent).get(0))));

            parentToMails.get(ultParent).add(email);
        }

        for (Map.Entry<Integer, List<String>> m: parentToMails.entrySet()) {
            List<String> list = m.getValue();
            Collections.sort(list.subList(1,list.size()));
            res.add(list);
        }

        return res;
    }
}