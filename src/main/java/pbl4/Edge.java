package pbl4;

public class Edge {
    int source;
    int destination;
    int weight;
    
    public Edge(int src, int dest, int wei){
        this.source = src;
        this.destination = dest;
        this.weight = wei;
    }
    
    public boolean CheckEdge() {
        if(this.source < 1 || this.destination < 1 || this.weight <= 0) 
            return false;
        if(this.source == this.destination)
            return false;
        
        return true;
    }
    
    public boolean equalsEdge (Edge e) {
        boolean check1 = this.source == e.source;
        boolean check2 = this.destination == e.destination;
        boolean check3 = this.source == e.destination;
        boolean check4 = this.destination == e.source;
        
        if((check1 && check2) || (check3 && check4)) {
            return true;
        } else {
            return false;
        }
    }
}
