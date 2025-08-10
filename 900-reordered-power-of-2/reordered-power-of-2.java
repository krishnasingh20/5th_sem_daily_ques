class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sort(n);
        for(int i = 0; i <= 31; i++) {
            if(target.equals(sort(1 << i))) {
                return true;
            }
        }
        return false;
    }
    public String sort(int n) {
        char[] ch = String.valueOf(n).toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}