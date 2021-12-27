package pbl4;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    public int ArrayGraph[][];
    public int P[];
    public int M, N, pStart, pEnd;
    
    public Dijkstra(int m, int n){
        ArrayGraph = new int[100][100];
        P = new int[100];
        //so canh
        M = m;
        //so dinh
        N = n; 
    }
    public void CreateArrayGraph(List<Edge> graph){
        //khoi tao
        int src, dest, wei;
        
        for(int i = 0; i < M; i++){
                src = graph.get(i).source - 1;
                dest = graph.get(i).destination - 1;
                wei = graph.get(i).weight;
                ArrayGraph[src][dest] = ArrayGraph[dest][src] = wei;
        }
    }
    public int DisMin(){
        int MinPath[] = new int[N];
        
        for(int i = 0; i < N; i++){
            MinPath[i] = Integer.MAX_VALUE;
        }
        MinPath[pStart] = 0;
        
        boolean Check[] = new boolean[N];
        for(int i = 0; i < N; i++)
        {
            Check[i] = false;
        }
        int u = 0;
        
        P[0] = -1;
        
        while(true){
            u = pEnd;
            for(int i = 0; i < N; i++){
                if(Check[i] == false && MinPath[u] > MinPath[i]){
                    u = i;
                }
            }
            Check[u] = true;
            
            if(MinPath[u] == Integer.MAX_VALUE || u == pEnd) break;
            
            for(int v = 0; v < N; v++){
                if(ArrayGraph[u][v] > 0 && !Check[v]){
                    if(ArrayGraph[u][v] + MinPath[u] < MinPath[v]){
                        MinPath[v] = ArrayGraph[u][v] + MinPath[u];
                        P[v] = u;
                    }
                }
            }
        }
        return MinPath[pEnd];
    }
    
    public String TruyVet(int end){
        String s = "Shortest path from " + (pStart + 1) + " to " + (pEnd + 1) + " : "; 
        int u = end;
        List<Integer> vet = new ArrayList();
        while(u != pStart){
            vet.add(0, u);
            u = P[u];
        }
        vet.add(0, pStart);
        for(int i : vet){
            if(i != vet.get(0)) {
                s = s + "-->" + (i + 1);
            }
            else {
                s = s + "" + (i + 1);
            }
        }
        return s;
    }
}