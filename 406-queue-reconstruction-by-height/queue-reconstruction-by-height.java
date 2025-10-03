class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        List<int[]> ll = new ArrayList<>();
        for(int i = 0; i < people.length; i++) {
            ll.add(people[i][1], people[i]);
        }
        for(int i = 0; i < people.length; i++) {
            people[i] = ll.get(i);
        }
        return people;
    }
}