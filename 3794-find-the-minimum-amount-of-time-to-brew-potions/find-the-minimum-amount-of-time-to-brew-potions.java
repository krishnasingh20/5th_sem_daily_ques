class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[][] arr = new long[mana.length][skill.length];
        for(int i = 0; i < skill.length; i++) {
            long c = i - 1 < 0?0:arr[0][i-1];
            arr[0][i] += (skill[i]*mana[0]) + c;
        }
        for(int i = 1; i < mana.length; i++) {
            long start = 0;
            long sum = 0;
            for(int j = 0; j < skill.length; j++) {
                if(sum < arr[i-1][j]) {
                    long curr = sum - start;
                    start = start + (arr[i-1][j] - sum);
                    sum = start + curr + (skill[j]*mana[i]);
                }
                else {
                    sum += (skill[j]*mana[i]);
                }
            }
            sum = start;
            for(int j = 0; j < skill.length; j++) {
                arr[i][j] = sum + skill[j]*mana[i];
                sum = arr[i][j];
            }
        }
        return arr[mana.length - 1][skill.length - 1];
    }
}