/*
https://leetcode.com/problems/find-all-people-with-secret/

See solution 2 for a more "ingenious" version
*/

class DSU {
    int[] parents;
    int[] size;
    int numComponents;
    
    public DSU (int n) {
        parents = new int[n];
        size = new int[n];
        numComponents = n;
        
        for(int u = 0; u < n; u++) {
            parents[u] = u;
            size[u] = 1;
        }
    }
    
    public int find (int p) {
        int u = p;
        while(u != parents[u]) {
            u = parents[u];
        }
        while(p != u) {
            int parentP = parents[p];
            parents[p] = u;
            p = parentP;
        }
        return u;
    }
    
    public void union (int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        
        if(rootP == rootQ) {
            return;
        }
        
        if(size[rootP] >= size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }
}


class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[2], m2[2]));
        int m = meetings.length;
        int i = 0;
        Set<Integer> secret = new HashSet<>();
        secret.add(0);
        secret.add(firstPerson);
        
        while(i < m) {
            
            int[] curr = meetings[i];
            int currTime = curr[2];
            Map<Integer, Integer> compress = new HashMap<>(); // number compression
            Map<Integer, Integer> decompress = new HashMap<>();
            int j = 0; // compressed index
            int k = i;
            
            while(currTime == curr[2]) {
                currTime = curr[2];
                int xi = curr[0];
                int yi = curr[1];
                if(!compress.containsKey(xi)) {
                    compress.put(xi, j);
                    decompress.put(j, xi);
                    j++;
                }
                if(!compress.containsKey(yi)) {
                    compress.put(yi, j);
                    decompress.put(j, yi);
                    j++;
                }
                i++;
                if(i >= m) {
                    break;
                }
                curr = meetings[i];
            }
            
            DSU dsu = new DSU(j);
            
            while(k < i) {
                int[] meeting = meetings[k];
                int xi = meeting[0];
                int yi = meeting[1];
                dsu.union(compress.get(xi), compress.get(yi));
                k++;
            }
            
            
            for(int p = 0; p < j; p++) {
                if(secret.contains(decompress.get(p))) {
                    int parent = dsu.find(p);
                    parent = decompress.get(parent);
                    secret.add(parent);
                }
            }
            
            for(int p = 0; p < j; p++) {
                int parent = dsu.find(p);
                parent = decompress.getOrDefault(parent, -1);
                if(secret.contains(parent)) {
                    secret.add(decompress.get(p));
                }
            }
            
        }
        
        return new ArrayList<>(secret);
    }
}


/*
Big idea: "disconnect"

- Sort the meetings from small to large by time 
- For each timestamp, union all people with meetings in that timestamp (since 
1 people know secret in a timestamp => all people from such component knows that 
secret)
- Important: after each timestamp union, disconnect all people not in the same
component as 0. This means they don't have the secret by this timestamp, even
though they might be connected to another person(s)
- Repeat step 2 and 3 for all meetings. Add all person(s) in the same component
as 0 to the final answer.
*/

class DSU {
    int[] parents;
    int[] size;
    int N;

    public DSU (int n) {
        N = n;
        parents = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }
    
    public int find (int p) {
        int u = p;
        while(u != parents[u]) {
            u = parents[u];
        }
        while(p != u) {
            int parentP = parents[p];
            parents[p] = u;
            p = parentP;
        }
        return u;
    }
    
    public void union (int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) {
            return;
        } 
        
        if(size[rootP] > size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }
    
    
    public boolean sameComponent (int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    
    public void reset (int p) {
        parents[p] = p;
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[2], m2[2]));
        DSU dsu = new DSU(n);
        int m = meetings.length;
        int i = 0;
        dsu.union(0, firstPerson);
        
        List<Integer> secret = new ArrayList<>();
        
        while(i < m) {
            List<Integer> people = new ArrayList<>(); // list of people who have meetings at this timestamp
            int currTime = meetings[i][2];
            while(i < m && meetings[i][2] == currTime) { // loop through meetings in the same timestamp
                
                int[] currMeeting = meetings[i];
                int xi = currMeeting[0];
                int yi = currMeeting[1];
                dsu.union(xi, yi); // union these 2 people since they can share secrets with each other
                people.add(xi);
                people.add(yi);
                
                i++;
                
            }
            
            for(int p : people) {
                if(!dsu.sameComponent(p, 0)) { // if a person having a meeting at this timestamp is not connected to 0, then he doesn't have the secret
                    dsu.reset(p);
                }
            }
        }
        
        for(int p = 0; p < n; p++) {
            if(dsu.sameComponent(p, 0)) {
                secret.add(p);
            }
        }
        
        return secret;
    }
}
