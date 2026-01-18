class AuctionSystem {
    HashMap<Integer, HashMap<Integer, Integer>> map1;
    HashMap<Integer, TreeMap<Integer, TreeSet<Integer>>> map2;
    public AuctionSystem() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        map1.putIfAbsent(itemId, new HashMap<>());
        map2.putIfAbsent(itemId, new TreeMap<>());
        if(map1.get(itemId).containsKey(userId)) {
            int bid = map1.get(itemId).get(userId);
            if(bid == bidAmount) {
                return;
            }
            TreeSet<Integer> oldSet = map2.get(itemId).get(bid);
            if(oldSet != null) {
                oldSet.remove(userId);
                if(oldSet.isEmpty()) {
                    map2.get(itemId).remove(bid);
                }
            }
            map1.get(itemId).put(userId, bidAmount);
            map2.get(itemId).computeIfAbsent(bidAmount, k-> new TreeSet<>()).add(userId);
        }
        else {
            map1.get(itemId).put(userId, bidAmount);
            map2.get(itemId).computeIfAbsent(bidAmount, k-> new TreeSet<>()).add(userId);
        }
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        int bid = map1.get(itemId).get(userId);
        if(bid == newAmount) {
            return;
        }
        TreeSet<Integer> oldSet = map2.get(itemId).get(bid);
        if(oldSet != null) {
            oldSet.remove(userId);
            if(oldSet.isEmpty()) {
                map2.get(itemId).remove(bid);
            }
        }
        map1.get(itemId).put(userId, newAmount);
        map2.get(itemId).computeIfAbsent(newAmount, k-> new TreeSet<>()).add(userId);
    }
    
    public void removeBid(int userId, int itemId) {
        int bid = map1.get(itemId).get(userId);
        map1.get(itemId).remove(userId);
        TreeSet<Integer> oldSet = map2.get(itemId).get(bid);
        if(oldSet != null) {
            oldSet.remove(userId);
            if(oldSet.isEmpty()) {
                map2.get(itemId).remove(bid);
            }
        }
        if (map2.get(itemId).isEmpty()) {
            map2.remove(itemId);
            map1.remove(itemId);
        }
    }
    
    public int getHighestBidder(int itemId) {
        if (!map2.containsKey(itemId)) {
            return -1;
        }
        TreeMap<Integer, TreeSet<Integer>> map = map2.get(itemId);
        if (map.isEmpty()) {
            return -1;
        }
        Integer highestBid = map.lastKey();
        Integer user = map.get(highestBid).last();
        return user == null ? -1 : user;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */