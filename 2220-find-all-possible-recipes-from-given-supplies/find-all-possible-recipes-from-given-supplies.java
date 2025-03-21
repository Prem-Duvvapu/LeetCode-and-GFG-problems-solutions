//brute
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n=recipes.length;
        List<String> res=new ArrayList<>();
        boolean[] canCreate=new boolean[n];
        
        Set<String> suppliesSet=new HashSet<>();
        for (String supply: supplies)
            suppliesSet.add(supply);

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (!canCreate[j]) {
                    boolean flag=true;
                    for (String ingredient: ingredients.get(j)) {
                        if (!suppliesSet.contains(ingredient)) {
                            flag=false;
                            break;
                        }
                    }

                    if (flag) {
                        canCreate[j]=true;
                        suppliesSet.add(recipes[j]);
                    }
                }
            }
        }

        for (int i=0;i<n;i++)
            if (canCreate[i])
                res.add(recipes[i]);

        return res;
    }
}