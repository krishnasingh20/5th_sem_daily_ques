class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        while(numBottles >= numExchange) {
            numBottles -= numExchange;
            ans++;
            numBottles++;//numExchange bottle ke bad ek full bottle mila jise mai pike empty bottle me sum kr diya aur jo ek bottle aur usko upper answer me add krdiya
            numExchange++;//say in question that after every numExchange empty bottle it value increase by 1
        }
        return ans;
    }
}