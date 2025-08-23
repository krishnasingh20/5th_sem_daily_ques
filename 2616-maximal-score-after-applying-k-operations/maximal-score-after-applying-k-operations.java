class Solution {
    int size;

    public long maxKelements(int[] nums, int k) {
        size = nums.length;

        // Step 1: Build max-heap in-place
        buildHeap(nums);

        long score = 0;
        while (k-- > 0) {
            int val = remove(nums);  // extract max
            score += val;
            int newVal = (int) Math.ceil(val / 3.0);
            add(newVal, nums);      // insert new value
        }
        return score;
    }

    // Build heap from array
    private void buildHeap(int[] nums) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            downHeapify(i, nums);
        }
    }

    // Insert at end, then fix heap
    private void add(int item, int[] nums) {
        if (size == nums.length) { // expand if needed
            nums = java.util.Arrays.copyOf(nums, size * 2);
        }
        nums[size] = item;
        size++;
        upHeapify(size - 1, nums);
    }

    private void upHeapify(int ci, int[] nums) {
        if (ci == 0) return;
        int pi = (ci - 1) / 2;
        if (nums[pi] < nums[ci]) {
            swap(pi, ci, nums);
            upHeapify(pi, nums);
        }
    }

    // Remove root (max element)
    private int remove(int[] nums) {
        swap(0, size - 1, nums);
        int val = nums[size - 1];
        size--;
        downHeapify(0, nums);
        return val;
    }

    private void downHeapify(int pi, int[] nums) {
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        int maxi = pi;

        if (lci < size && nums[maxi] < nums[lci]) {
            maxi = lci;
        }
        if (rci < size && nums[maxi] < nums[rci]) {
            maxi = rci;
        }
        if (maxi != pi) {
            swap(pi, maxi, nums);
            downHeapify(maxi, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
