package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class shortestPath {
    
    public static int[] shortPath(int[][] edges, int n, int m){

        int []path = new int[n];

        for(int i=0;i<n;i++){
            path[i] = Integer.MAX_VALUE;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int[]edge:edges){

            int e1=edge[0];
            int e2=edge[1];

            adj.get(e1).add(e2);
            adj.get(e2).add(e1);

        }

        Queue<Integer>q = new LinkedList<>();

        q.add(0);
        path[0]=0;

        int []vis = new int[n];
        while(!q.isEmpty()){
            
            int node = q.poll();
            vis[node]=1;

            for(int ngr:adj.get(node)){
                if(vis[ngr]==0){
                    if(path[ngr]>path[node]+1){
                        q.add(ngr);
                        path[ngr]=path[node]+1;
                    }
                }
            }

        }

        return path;

        
    }
    public static void main(String[] args) {
        
        int[][]edges={{0,1},{0,3},{3,4},{4,5},{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}};

        int []paths = shortPath(edges, 9 , 10);

        for(int i=0;i<9;i++){
            System.out.println(i+":"+paths[i]);
        }


    }
}
