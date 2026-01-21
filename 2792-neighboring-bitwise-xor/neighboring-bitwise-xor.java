class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for(int a: derived) {
            xor ^= a;
        }
        return xor == 0;
    }
}