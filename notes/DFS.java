


// 1 -> 0,2, 0 -> 1,2 , 2 -> 0, 1, 3, 4 , 3->2, 4 -> 2  

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>(5);  
       boolean[] visited = new boolean[5];
       adj.add(new ArrayList<>(List.of(1,2)));
       adj.add(new ArrayList<>(List.of(0,2)));
       adj.add(new ArrayList<>(List.of(0,1,3,4)));
       adj.add(new ArrayList<>(List.of(2)));
       adj.add(new ArrayList<>(List.of(2)));
       System.out.println(adj.toString());
       dfs(adj, 0, visited);
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited)
    {
        visited[u] = true;
        for(int v : adj.get(u))
        {
            if(!visited[v])
            {
            System.out.printf("Going from %d ->  " , u);
            System.out.println(" " + v);
            dfs(adj, v, visited);
            }
        }

    }
}
