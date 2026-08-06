class ProductOfNumbers {

    int[] product;
    int[] count;
    int idx;

    public ProductOfNumbers() {
        count = new int[40000];
        product = new int[40000];
        idx = 0;
    }
    
    public void add(int num) {
        if(num == 0) {
            product[idx] = 0;
            count[idx] = 1 + (idx > 0 ? count[idx-1] : 0);
        }
        else {
            count[idx] = idx > 0 ? count[idx-1] : 0;
            product[idx] = num;
            if(idx > 0) {
                if(product[idx-1] != 0) {
                    product[idx] *= product[idx-1];
                }
            }
        }
        idx++;
    }
    
    public int getProduct(int k) {
        if(k == idx) {
            if(count[k-1] > 0) {
                return 0;
            }
            return product[k-1];
        }
        if(count[idx-1] - count[idx - k - 1] > 0) {
            return 0;
        }
        return product[idx-1]/(product[idx - k - 1] == 0 ? 1 : product[idx - k - 1]);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */