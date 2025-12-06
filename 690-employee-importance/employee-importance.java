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
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees) {
            int val = e.id;
            map.put(val, e);
        }
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(id);
        int ans = 0;
        while(!q.isEmpty()) {
            int rv = q.poll();
            if(visited.contains(rv)) {
                continue;
            }
            visited.add(rv);
            Employee e = map.get(rv);
            ans += e.importance;
            for(int sub: e.subordinates) {
                if(!visited.contains(sub)) {
                    q.add(sub);
                }
            }
        }
        return ans;
    }
}