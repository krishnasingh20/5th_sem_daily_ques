class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        String[] map = {"electronics", "grocery", "pharmacy", "restaurant"};
        List<List<String>> ll = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            ll.add(new ArrayList<>());
        }
        for(int i = 0; i < code.length; i++) {
            if(isValid(code[i])) {
                if(isActive[i]) {
                    if(businessLine[i].equals(map[0])) {
                        ll.get(0).add(code[i]);
                    }
                    else if(businessLine[i].equals(map[1])) {
                        ll.get(1).add(code[i]);
                    }
                    else if(businessLine[i].equals(map[2])) {
                        ll.get(2).add(code[i]);
                    }
                    else if(businessLine[i].equals(map[3])) {
                        ll.get(3).add(code[i]); 
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            if(ll.get(i).size() > 0) {
                Collections.sort(ll.get(i));
                ans.addAll(ll.get(i));
            }
        }
        return ans;
    }
    public boolean isValid(String s) {
        if(s.length() == 0) {
            return false;
        }
        for(char c: s.toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == '_') {
                continue;
            }
            return false;
        }
        return true;
    }
}