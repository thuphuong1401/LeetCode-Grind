/*
https://leetcode.com/problems/ipo/
*/

class Project implements Comparable<Project> {
    int profit;
    int capital;
    
    public Project(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
    
    @Override
    public int compareTo(Project other) {
        return this.capital - other.capital;
    }
    
    public String toString() {
        return this.profit + " " + this.capital;
    }
}


class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] listProjects = new Project[n];
        for(int i = 0; i < n; i++) {
            int currProfit = profits[i];
            int currCapital = capital[i];
            listProjects[i] = new Project(currProfit, currCapital);
        }
        Arrays.sort(listProjects); // capital ascending
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        int i = 0;
        int projectCount = 0;
        while(projectCount < k) {
            while(i < n) {
                Project currProject = listProjects[i];
                if(currProject.capital <= w) {
                    pq.add(currProject.profit);
                } else {
                    break;
                }
                i++;
            }
            if(pq.size() == 0) {
                return w;
            }
            Integer profit = pq.remove();
            w += profit;
            projectCount++;
        }
        
        return w;
    }
}
