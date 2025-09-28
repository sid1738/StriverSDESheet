package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijikstra {

    public static int[]dijikstra(int v,List<List<List<Integer>>>adj,int s){
        int []paths = new int[v];

        PriorityQueue<List<Integer>>q = new PriorityQueue<>((a,b)->a.get(1)-b.get(1));
        q.add(Arrays.asList(s,0));

        int [] vis = new int[v];

        while(!q.isEmpty()){
            List<Integer>node = q.poll();
        
            int currVertex = node.get(0);
            int currDistance = node.get(1);

            vis[currVertex]=1;

            for(List<Integer>ngr:adj.get(currVertex)){

                int next = ngr.get(0);
                int dist = ngr.get(1);

                if(vis[next]==0){
                    paths[next]=currDistance+dist;
                    q.add(Arrays.asList(next,paths[next]));
                }
            }
        }

        return paths;
    }
    public static void main(String []args){
      
        List<List<List<Integer>>> adj = List.of(
            List.of(List.of(1, 1), List.of(2, 6)),
            List.of(List.of(2, 3), List.of(0, 1)),
            List.of(List.of(1, 3), List.of(0, 6))
);


        int[]paths = new int[3];
        paths = dijikstra(3,adj,2);

        for(int i=0;i<3;i++){
            System.out.println(i+":"+paths[i]);
        }

    }
}
