class Pair{
    int weight;
    int node;
    Pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        ArrayList<Pair>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]= new ArrayList<>();
        }
        for(List<Integer> li:edges){
            int a = li.get(0);
            int b = li.get(1);
            int we = li.get(2);
            adj[a].add(new Pair(b,we));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        pq.offer(new Pair(src,0));
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int d = p.weight;
            int nd = p.node;
            for(Pair ne:adj[nd]){
                if(dist[nd]+ne.weight<dist[ne.node]){
                    dist[ne.node]=dist[nd]+ne.weight;
                    pq.offer(new Pair(ne.node,dist[ne.node]));
                   
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE){
                map.put(i,-1);
            }
            else
            map.put(i,dist[i]);
        }
        return map;


    }  
}
