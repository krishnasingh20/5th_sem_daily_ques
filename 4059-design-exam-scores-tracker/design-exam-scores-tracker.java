class ExamTracker {
    List<Integer> times = new ArrayList<>();
    List<Long> prefix = new ArrayList<>();
    public ExamTracker() {
        
    }
    
    public void record(int time, int score) {
        times.add(time);
        if(prefix.size() == 0) {
            prefix.add((long)score);
        }
        else {
            prefix.add(prefix.get(prefix.size()-1) + score);
        }
    }
    
    public long totalScore(int startTime, int endTime) {
        int lower = lowerBound(startTime);
        int upper = upperBound(endTime);
        if(lower == -1 || upper == -1) {
            return 0;
        }
        else if(lower == 0) {
            return prefix.get(upper);
        }
        else if(lower <= upper) {
            return prefix.get(upper) - prefix.get(lower - 1);
        }
        else {
            return 0;
        }
    }

    public int lowerBound(int start) {
        int idx = -1;
        int low = 0;
        int high = times.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(times.get(mid) >= start) {
                idx = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return idx;
    }

    public int upperBound(int end) {
        int idx = -1;
        int low = 0;
        int high = times.size()-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(times.get(mid) <= end) {
                idx = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return idx;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */