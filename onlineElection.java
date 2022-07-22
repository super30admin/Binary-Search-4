/*
Problem: https://leetcode.com/problems/online-election/
*/
class TopVotedCandidate {

    // Maintains <leader, counts>
    HashMap<Integer, Integer> voteCountsMap;
    // Maintains <time, leader>
    HashMap<Integer, Integer> leaderTimeMap;
    int times[];
    
    
    public TopVotedCandidate(int[] persons, int[] times) {
        voteCountsMap = new HashMap<>();
        leaderTimeMap = new HashMap<>();
        int leader = persons[0];
        this.times = times;
        
        // TC: O(n)
        for (int i = 0; i < persons.length; ++i) {
            voteCountsMap.put(persons[i], voteCountsMap.getOrDefault(persons[i], 0) + 1);
            
            if (voteCountsMap.get(persons[i]) >= voteCountsMap.get(leader)) {
                leader = persons[i];
            }
            leaderTimeMap.put(times[i], leader);
        }
    }
    
    public int q(int t) {
        if (leaderTimeMap.containsKey(t)) {
            return leaderTimeMap.get(t);
        }
        
        // Binary search for time
        int low = 0, high = times.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // We don't have to check for t == mid because we already checked for t in leaderTimeMap 
            if (t > times[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return leaderTimeMap.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */