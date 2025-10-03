class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b)->b[0]==a[0]?a[1]-b[1]:b[0]-a[0]);
        List<int[]> ll = new ArrayList<>();
        for(int i = 0; i < people.length; i++) {
            ll.add(people[i]);
        }
        for(int i = 1; i < ll.size(); i++) {
            int h = ll.get(i)[0];
            int k = ll.get(i)[1];
            int c = 0;
            int j = 0;
            while(c < k) {
                if(ll.get(j)[0] >= h) {
                    c++;
                }
                j++;
            }
            ll.remove(i);
            ll.add(j, new int[]{h, k});
        }
        for(int i = 0; i < people.length; i++) {
            people[i] = ll.get(i);
        }
        return people;
    }
}