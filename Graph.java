import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void main(String[] args) {
        final int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createAGraph(graph);

//        for (int i = 0; i<graph[2].size(); i++) {
//            Edge e = graph[2].get(i);
//            System.out.println(e.dest);
//        }

        //if graph is a disconected graph
        boolean[] visited= new boolean[V];
        // for(int i=0; i<V; i++) {
        //     if(!visited[i])
        //         bsf(graph, i, visited);
        // }

        // dfs(graph, 0, visited);
        findAllPath(graph, visited, 0, 5, "");
    }

    private static void dfs(ArrayList<Edge>[] graph, int i, boolean[] visited) {
        if(visited[i]) return;

        visited[i] = true;
        System.out.print(i+" ");
        for(int j =0; j<graph[i].size(); j++) {
            dfs(graph, graph[i].get(j).dest, visited);
        }
    }

    private static void bsf(ArrayList<Edge>[] graph, int i, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()) {
            int e = q.poll();

            if(!visited[e]) {
                visited[e] = true;
                System.out.print(e+" ");
                for(int j=0; j<graph[e].size(); j++) {
                    q.add(graph[e].get(j).dest);
                }
            }
        }
    }

    public static void findAllPath(ArrayList<Edge>[] graph, boolean[] visited, int curr, int tar, String ans) {
        if(curr == tar) {
            ans += tar;
            System.out.println(ans);
            return;
        }
        if(!visited[curr]) {
            visited[curr] = true;
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                findAllPath(graph, visited, e.dest, tar, ans+ Integer.toString(curr));
                
            }
            visited[curr]= false;
        }
    }

    private static void createAGraph(ArrayList<Edge>[] graph) {
//        Arrays.fill(graph, new ArrayList<Edge>());
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));


    }
}
