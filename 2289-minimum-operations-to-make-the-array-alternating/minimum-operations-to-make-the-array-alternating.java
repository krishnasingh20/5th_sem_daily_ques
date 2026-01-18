class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i += 2) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int a10 = -1;
        int a11 = -1;
        int a20 = -1;
        int a21 = -1;
        for(int key: map.keySet()) {
            int val = map.get(key);
            if(val > a11) {
                a20 = a10;
                a21 = a11;
                a10 = key;
                a11 = val;
            }
            else if(val > a21) {
                a20 = key;
                a21 = val;
            }
        }
        map.clear();
        for(int i = 1; i < n; i += 2) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int b10 = -1;
        int b11 = -1;
        int b20 = -1;
        int b21 = -1;
        for(int key: map.keySet()) {
            int val = map.get(key);
            if(val > b11) {
                b20 = b10;
                b21 = b11;
                b10 = key;
                b11 = val;
            }
            else if(val > b21) {
                b20 = key;
                b21 = val;
            }
        }
        int len1 = n/2;
        if((n & 1) == 1) {
            len1++;
        }
        int len2 = n/2;
        if(a10 != b10) {
            return (len1-a11) + (len2-b11);
        }
        else {
            if(a20 != -1 && b20 != -1) {
                int opr1 = (len1-a11)+(len2-b21);
                int opr2 = (len1-a21)+(len2-b11);
                return Math.min(opr1, opr2);
            }
            else if(a20 != -1) {
                int opr1 = (len1-a11)+len2;
                int opr2 = (len1-a21)+(len2-b11);
                return Math.min(opr1, opr2);
            }
            else if(b20 != -1) {
                int opr1 = (len1-a11)+(len2-b21);
                int opr2 = len1+(len2-b11);
                return Math.min(opr1, opr2);
            }
            else {
                return Math.min(len1, len2);
            }
        }
    }
}