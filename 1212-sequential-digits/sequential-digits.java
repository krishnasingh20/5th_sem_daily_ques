class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int len1 = String.valueOf(low).length();
        int len2 = String.valueOf(high).length();

        List<Integer> ans = new ArrayList<>();

        for(int i = len1; i <= len2; i++) {
            for(int j = 1; j <= 10 - i; j++) {
                int k = j;
                int num = 0;
                for(int l = 1; l <= i; l++) {
                    num = num * 10  + k;
                    k++;
                }
                if(num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}