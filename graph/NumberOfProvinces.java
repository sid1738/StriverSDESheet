package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    

    private static void dfs(int curr, List<List<Integer>>adj, int []vis){

        vis[curr]=1;
        for(int node:adj.get(curr)){
            if(vis[node]==0){
                dfs(node,adj,vis);
            }
        }

    }

    public static int numberOfProvinces(int [][] isConnected){
        
        int n = isConnected[0].length;
        List<List<Integer>>adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int []vis = new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,adj,vis);
                count++;
            }
        }
        
        return count;
    }
    public static void main(String []args){
        int[][] cities = {{1,1,0},{1,1,0},{0,0,1}};
        int provinces = numberOfProvinces(cities);
        System.out.println(provinces);
    }
}
