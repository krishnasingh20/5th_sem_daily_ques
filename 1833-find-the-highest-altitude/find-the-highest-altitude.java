class Solution {
    public int largestAltitude(int[] gain) {
        int [] arr1=new int[gain.length+1];
        arr1[0]=0;
        int max=0;
        for(int i=0;i<gain.length;i++){
            arr1[i+1]=arr1[i]+gain[i];
            max=Math.max(arr1[i+1],max);
        }
        return max;
    }
}