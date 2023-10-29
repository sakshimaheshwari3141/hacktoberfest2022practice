import java.util.*;
public class BiPartiteUsingDfs {
    
    HashMap<Integer,List<Integer>> graph = new HashMap<>();

    void addEdge(int source,int destination) {
        graph.putIfAbsent(source, new ArrayList<>());
        graph.putIfAbsent(destination, new ArrayList<>());
        graph.get(source).add(destination);
        graph.get(destination).add(source);

    }

    boolean isBipartiteUsingDFS(HashMap<Integer,List<Integer>> graph) {
        int v = graph.size();
        int color[] = new int[v];
        Arrays.fill(color,-1);
        // 0 & 1
        for(int i=0;i<v;i++) {
            if(color[i]==-1) {
                color[i] = 1;
                return DFSUtils(graph,color,i);
            }
        }


        return true;
    }

    boolean DFSUtils(HashMap<Integer,List<Integer>> graph ,int color[],int source) {
        
       boolean ans = true;
        for(int neigh: graph.get(source)) {
            if(color[neigh]!=-1) {
                if(color[neigh]==color[source]) {
                    
                    return false;
                }
              

            }
            if(color[neigh]==-1) {
                color[neigh] = 1-color[source];
                
               ans &= DFSUtils(graph, color, neigh);
            
            }
            if(!ans) {
                return false;
            }  
            
        }
        
        return true;
    }


    public static void main(String[] args) {
        BiPartiteUsingDfs obj = new BiPartiteUsingDfs();
        // obj.addEdge(0, 1);
        // obj.addEdge(0, 2);
        // obj.addEdge(0, 9);
        // obj.addEdge(1, 5);
        // obj.addEdge(1, 3);
        // obj.addEdge(2, 6);
        // obj.addEdge(2, 4);
        // obj.addEdge(3, 7);
        // obj.addEdge(3, 4);
        // obj.addEdge(4, 8);
        // obj.addEdge(5, 6);
        // obj.addEdge(5, 8);
        // obj.addEdge(6, 7);
        // obj.addEdge(9, 8);
        // obj.addEdge(9, 7);

        obj.addEdge(0, 1);
        obj.addEdge(0, 3);
        obj.addEdge(1,2);
        obj.addEdge(2, 3);
       obj.addEdge(0, 2);
    //    obj.addEdge(0, 1);
    //    obj.addEdge(0, 2);
    //    obj.addEdge(1,2);
        obj.addEdge(4, 5);
        obj.addEdge(6, 5);
        obj.addEdge(6, 4);

        System.out.println(obj.isBipartiteUsingDFS(obj.graph));
        
    }
}
