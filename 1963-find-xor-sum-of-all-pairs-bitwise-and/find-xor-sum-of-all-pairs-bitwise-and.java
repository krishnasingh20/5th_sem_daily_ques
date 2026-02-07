class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor1 = getXOR(arr1);
        int xor2 = getXOR(arr2);
        return (xor1 & xor2);
    }
    private int getXOR(int[] arr) {
        int xor = 0;
        for(int a: arr) {
            xor ^= a;
        }
        return xor;
    }
}