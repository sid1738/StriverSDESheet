package graph;



import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{

    private int node;
    private int steps;

    public Node(int node, int steps){
        this.node = node;
        this.steps = steps;
    }

    public int getSource(){
        return this.node;
    }

    public int getSteps(){
        return this.steps;
    }
}

public class MinimumMultiplications {
    public int minimumMultiplications(int[] arr, int start, int end) {

       int []minDistance = new int[100001];
       Arrays.fill(minDistance, Integer.MAX_VALUE); 

       Queue<Node> q = new LinkedList<>();

       minDistance[start] = 0;
       q.add(new Node(start, 0));

       int mod = 100000;

       while(!q.isEmpty()){
           
            Node node = q.poll();
            int src = node.getSource();
            int steps = node.getSteps();

            for(int num: arr){
                int nextNode = (src*num)%mod;
                if(nextNode == end){
                    return steps+1;
                }

                if(minDistance[nextNode]>minDistance[src]+1){
                    minDistance[nextNode] = minDistance[src]+1;
                    q.add(new Node(nextNode, steps+1));
                }
            }

       }


       return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};

        try {
            MinimumMultiplications obj = new MinimumMultiplications();
            int ans = obj.minimumMultiplications(arr, 3, 30);
            System.out.println(ans);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
