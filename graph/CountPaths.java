package graph;

import java.util.*;

class Node{
    
    private int src;
    private int dist;

    public Node(int src, int dist){
        this.src = src;
        this.dist = dist;
    }


    public int getSrc(){
        return this.src;
    }

    public int getDist(){
        return this.dist;
    }

}

public class CountPaths {

    public int countPaths(int n, int[][] roads){
        
        int []minDistance = new int[n];
        int []countPath = new int[n];

        List<List<List<Integer>>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road:roads){

            int src = road[0];
            int ds = road[1];
            int w = road[2];

            adj.get(src).add(Arrays.asList(ds,w));
            adj.get(ds).add(Arrays.asList(src, w));

        }

        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[0]=0;
        countPath[0]=1;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.getDist()-b.getDist());

        pq.add(new Node(0,0));

        while(!pq.isEmpty()){

            Node node = pq.poll();

            int src = node.getSrc();
            int dist = node.getDist();

            if(dist>minDistance[src])continue;

            for(List<Integer> ngr:adj.get(src)){
                
                int ds = ngr.get(0);
                int d = ngr.get(1);

                if(minDistance[src]+d<minDistance[ds]){
                    minDistance[ds] = minDistance[src]+d;
                    countPath[ds] = countPath[src];
                    pq.add(new Node(src, minDistance[ds]));
                }
                else if(minDistance[src]+d==minDistance[ds]){
                    countPath[ds]+=countPath[src];
                }
            }
        }
        return countPath[n-1];
        
        
    }

}
