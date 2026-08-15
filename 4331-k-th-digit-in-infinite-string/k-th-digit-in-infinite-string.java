class Solution {
    public int kthDigit(long k) {
        if(k <= 9) {
            return (int)k;
        }

        long count = 9;
        long start = 1;
        long end = 9;

        for(int i = 1; i <= 13; i++) {
            long temp = (i+1)*10;
            long prev = count;
            count += ((end - start + 1)*temp);

            if(count >= k) {
                long low = start;
                long high = end;
                long idx = -1;

                while(low <= high) {
                    long mid = low + (high - low)/2;
                    if(prev+((mid - start + 1)*temp) >= k) {
                        idx = mid;
                        high = mid - 1;
                    }
                    else {
                        low = mid + 1;
                    }
                }

                StringBuilder sb = new StringBuilder();
                if(idx != start) {
                    prev += ((idx - start)*temp);
                }

                if((idx & 1) == 1) {
                    for(long j = (10L * idx) + 9; j >= (10L * idx); j--) {
                        sb.append(Long.toString(j));
                    }
                }
                else {
                    for(long j = (10L * idx); j <= (10L * idx) + 9; j++) {
                        sb.append(Long.toString(j));
                    }
                }

                for(int l = 0; l < sb.length(); l++) {
                    if(prev + l + 1 == k) {
                        return sb.charAt(l)-'0';
                    }
                }
            }

            start *= 10;
            end = end*10 + 9;
        }
        return -1;
    }
}