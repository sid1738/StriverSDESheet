package graph;

import java.util.PriorityQueue;

class Coordinate{
    
    private int x;
    private int y;
    private int dist;

    public Coordinate(int x,int y,int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getDist(){
        return this.dist;
    }

}
public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        PriorityQueue<Coordinate> pq = new PriorityQueue<>((a,b)->a.getDist()-b.getDist());


        int r = grid.length;
        int c = grid[0].length;

        int [][]vis = new int[r][c];

        int []dx={-1, -1, 0, -1, 1, 1, 0, -1};
        int []dy={0, -1, -1, 1, 0, 1, 1, 1};

        if(grid[0][0]==0){
            pq.add(new Coordinate(0,0,0));
        }

        while(!pq.isEmpty()){
            
            Coordinate co = pq.poll();

            int x = co.getX();
            int y = co.getY();

            int dist = co.getDist();

            if(x==r-1 && y == c-1){
                return dist+1;
            }

            vis[r][c] = 1;
            for(int i=0;i<8;i++){
                
                int newx = x+dx[i];
                int newy = y+dy[i];

                if(newx>=0 && newx < r && newy>=0 && newy < c && vis[newx][newy]==0 && grid[newx][newy]==0){
                    pq.add(new Coordinate(newx, newy, dist+1));
                }
            }
        }

        return -1;


    }
    
    public static void main(String[] args) {
        ShortestPathBinaryMatrix c = new ShortestPathBinaryMatrix();

        int [][] grid = {{0, 1},{1, 0}};

        int ans = c.shortestPathBinaryMatrix(grid);
        System.out.println(ans);
    }
}
