class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[friends.length];
        HashMap<String, Integer> map = new HashMap<>();
        q.add(new Pair(id, 0));
        while(!q.isEmpty()) {
            Pair rv = q.poll();
            if(visited[rv.vtx]) {
                continue;
            }
            visited[rv.vtx] = true;
            if(rv.dis == level) {
                List<String> ll = watchedVideos.get(rv.vtx);
                for(String s: ll) {
                    if(map.containsKey(s)) {
                        map.put(s, map.get(s)+1);
                    }
                    else {
                        map.put(s, 1);
                    }
                }
                continue;
            }
            int[] nbrs = friends[rv.vtx];
            for(int nbr: nbrs) {
                if(!visited[nbr]) {
                    q.add(new Pair(nbr, rv.dis+1));
                }
            }
        }
        List<Pair1> ll = new ArrayList<>();
        for(String key: map.keySet()) {
            ll.add(new Pair1(key, map.get(key)));
        }
        Collections.sort(ll, new Comparator<>(){
            @Override
            public int compare(Pair1 a, Pair1 b) {
                if(a.freq == b.freq) {
                    return (a.video).compareTo(b.video);
                }
                return Integer.compare(a.freq, b.freq);
            }
        });
        List<String> ans = new ArrayList<>();
        for(Pair1 p: ll) {
            ans.add(p.video);
        }
        return ans;
    }
    class Pair{
        int vtx;
        int dis;
        public Pair(int vtx, int dis) {
            this.vtx = vtx;
            this.dis = dis;
        }
    }
    class Pair1{
        String video;
        int freq;
        public Pair1(String video, int freq) {
            this.video = video;
            this.freq = freq;
        }
    }
}