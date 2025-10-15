class Solution {
    static int[] key = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] value = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        while(num > 0) {
            if(num >= key[i]) {
                str.append(value[i]);
                num -= key[i];
            }
            else {
                i++;
            }
        }
        return str.toString();
    }
}