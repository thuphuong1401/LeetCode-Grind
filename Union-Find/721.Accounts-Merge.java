/*
https://leetcode.com/problems/accounts-merge/

Each initial account will be ordered from 1 -> n
emailToID map: (email, id) where id is the first block that an email appears in accounts
Goals: same blockID => same account (same name). Have to union different blocks together
Each email belongs to one block ID. Loop through all emails, put each into hashmap. If 
already contained in hashmap => union 2 blocks
*/

class Solution {
    int n;
    int[] parents;
    int[] size;
    int numComponents;
    
    private void makeSet() {
        parents = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
        numComponents = n;
    }
    
    private int find(int p) {
        int root = p;
        while(root != parents[root]) {
            root = parents[root];
        }
        while(p != root) {
            int newp = parents[p];
            parents[p] = root;
            p = newp;
        }
        return root;
    }
    
    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if(size[rootP] >= size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        numComponents--;
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        n = accounts.size();    
        makeSet();
        Map<String, Integer> emailToIDMap = new HashMap<>();
        Map<String, Integer> nameToID = new HashMap<>();
        for(int i = 0; i < n; i++) { // loop through IDs of account
            String currName = accounts.get(i).get(0);
            for(int j = 1; j < accounts.get(i).size(); j++) {
                String currEmail = accounts.get(i).get(j);
                if(!emailToIDMap.containsKey(currEmail)) {
                    emailToIDMap.put(currEmail, i);
                } else {
                    union(i, emailToIDMap.get(currEmail));  
                }
            }
            nameToID.put(currName, i);
        }
        
        //System.out.println(emailToIDMap);
        
        Map<Integer, Set<String>> IDToEmailsMap = new HashMap<>();
        for(String email : emailToIDMap.keySet()) {
            int id = find(emailToIDMap.get(email));
            if(!IDToEmailsMap.containsKey(id)) {
                IDToEmailsMap.put(id, new HashSet<>());
            } 
            IDToEmailsMap.get(id).add(email);
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(Integer id : IDToEmailsMap.keySet()) {
            ans.add(new ArrayList<>(IDToEmailsMap.get(id)));
            int temp = ans.size() - 1;
            Collections.sort(ans.get(temp));
            String name = accounts.get((int)id).get(0);
            ans.get(temp).add(0, name);
        }
        
        return ans;
    }    

}
