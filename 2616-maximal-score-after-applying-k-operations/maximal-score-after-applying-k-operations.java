import java.util.*;

class Solution {
    List<Integer> heap = new ArrayList<>();

    public long maxKelements(int[] nums, int k) {
        // Build max-heap
        for (int num : nums) {
            add(num);
        }

        long score = 0;
        while (k-- > 0) {
            int val = remove(); // extract max
            score += val;
            int newVal = (int) Math.ceil(val / 3.0);
            add(newVal);
        }
        return score;
    }

    // Insert element into heap
    public void add(int item) {
        heap.add(item);
        upHeapify(heap.size() - 1);
    }

    private void upHeapify(int ci) {
        if (ci == 0) return;
        int pi = (ci - 1) / 2;
        if (heap.get(pi) < heap.get(ci)) { // max-heap condition
            swap(pi, ci);
            upHeapify(pi);
        }
    }

    // Extract max element
    public int remove() {
        swap(0, heap.size() - 1);
        int val = heap.remove(heap.size() - 1);
        downHeapify(0);
        return val;
    }

    private void downHeapify(int pi) {
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        int maxi = pi;

        if (lci < heap.size() && heap.get(maxi) < heap.get(lci)) {
            maxi = lci;
        }
        if (rci < heap.size() && heap.get(maxi) < heap.get(rci)) {
            maxi = rci;
        }

        if (maxi != pi) {
            swap(maxi, pi);
            downHeapify(maxi);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
