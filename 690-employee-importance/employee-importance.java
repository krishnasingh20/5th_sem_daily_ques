/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int max = 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees) {
            int val = e.id;
            map.put(val, e);
            max = Math.max(val,  max);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[max+1];
        q.add(id);
        int ans = 0;
        while(!q.isEmpty()) {
            int rv = q.poll();
            visited[rv] = true;
            Employee e = map.get(rv);
            ans += e.importance;
            for(int sub: e.subordinates) {
                if(!visited[sub]) {
                    q.add(sub);
                }
            }
        }
        return ans;
    }
}