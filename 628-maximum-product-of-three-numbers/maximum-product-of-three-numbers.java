class Solution {
    public int maximumProduct(int[] nums) {
        int[] arr = new int[5];
        arr[0] = arr[1] = Integer.MAX_VALUE;
        arr[2] = arr[3] = arr[4] = Integer.MIN_VALUE;

        for(int num: nums) {
            if(num < arr[0]) {
                arr[1] = arr[0];
                arr[0] = num;
            }
            else if(num < arr[1]) {
                arr[1] = num;
            }

            if(num > arr[2]) {
                arr[4] = arr[3];
                arr[3] = arr[2];
                arr[2] = num;
            }
            else if(num > arr[3]) {
                arr[4] = arr[3];
                arr[3] = num;
            }
            else if(num > arr[4]) {
                arr[4] = num;
            }
        }

        return Math.max(arr[0]*arr[1]*arr[2], arr[2]*arr[3]*arr[4]);
    }
}