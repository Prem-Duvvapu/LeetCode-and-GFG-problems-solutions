class ProductOfNumbers {
    List<Integer> list;

    public ProductOfNumbers() {
        list=new ArrayList<>();
    }
    
    public void add(int num) {
        if (num==0)
            list=new ArrayList<>();
        else if (list.size()==0)
            list.add(num);
        else
            list.add(list.get(list.size()-1)*num);
    }
    
    public int getProduct(int k) {
        if (k>list.size())
            return 0;

        if (k==list.size())
            return list.get(list.size()-1);

        int res=list.get(list.size()-1);
        System.out.println(res);
        res=res/(list.get(list.size()-k-1));
        return res;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */