class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        l.add(a);
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> ll = new ArrayList<>();
            List<Integer> l1 = l.get(l.size()-1);
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    ll.add(l1.get(j));
                }
                else if(j == i) {
                    ll.add(l1.get(j-1));
                }
                else {
                    ll.add(l1.get(j-1)+l1.get(j));
                }
            }

            l.add(ll);
        }
        return l.get(l.size()-1);
    }
}