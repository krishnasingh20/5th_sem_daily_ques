class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int placed = 0;
        for(int i = 0; i < fruits.length; i++) {
            for(int j = 0; j < baskets.length; j++) {
                if(baskets[j] >= fruits[i]) {
                    placed++;
                    baskets[j] = -1;
                    break;
                }
            }
        }
        return fruits.length - placed;
    }
}