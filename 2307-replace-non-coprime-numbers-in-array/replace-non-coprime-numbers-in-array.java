class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        ll.add(nums[0]);
        int i = 1;
        long a1 = 0;
        long a2 = 0;
        while(i < nums.length) {
            a1 = ll.remove(ll.size() - 1);
            a2 = nums[i];
            long a = a1;
            long b = a2;
            while(b != 0) {
                long temp = b;
                b = a % b;
                a = temp;
            }
            if(a <= 1) {
                ll.add((int)a1);
                ll.add((int)a2);
                i++;
            }
            else {
                long lcm =(a1*a2)/a;
                if(ll.size() >= 1) {
                    nums[i] = (int)lcm;
                }
                else {
                    ll.add((int)lcm);
                    i++;
                }
            }
        }
        return ll;
    }
}