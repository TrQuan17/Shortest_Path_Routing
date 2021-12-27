package pbl4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SPRServer {
    public static void main(String[] args) {
        new SPRServer();
    }
    
    public SPRServer(){
        try {
            ServerSocket server = new ServerSocket(5000);
            
            while(true){
                Socket soc = server.accept();
                XuLy x = new XuLy(soc);
                x.start();
                }
            }
        catch (IOException ex) {}
    }
}
class XuLy extends Thread{
    Socket soc;
    DataOutputStream dos;
    DataInputStream dis;
    
    public XuLy(Socket soc){
        try {
            this.soc = soc;
            dis = new DataInputStream(soc.getInputStream());
            dos = new DataOutputStream(soc.getOutputStream());
        } catch (IOException ex) {}
    }
    public void run(){
        try{
                
                int numE = dis.readInt();
                int numV = dis.readInt();
                
                List<Edge> Graph = new ArrayList();
                Dijkstra dij = new Dijkstra(numE, numV);
                
                for(int i = 0; i < numE; i++){
                    int src = dis.readInt();
                    int dest = dis.readInt();
                    int wei = dis.readInt();
                    System.out.print(src +"    "+ dest +"    "+ wei + "\n");
                    Graph.add(new Edge(src, dest, wei));
                }
                
                while(true){                    
                    int pStart = dis.readInt();
                    int pEnd = dis.readInt();
                    
                    
                    
                    dij.pStart = pStart;
                    dij.pEnd = pEnd;

                    dij.CreateArrayGraph(Graph);
                    
                    int Dismin = dij.DisMin();
                    String s = dij.TruyVet(pEnd);
                    String title = "Shortest path from " 
                            + (pStart + 1) + " to " + (pEnd + 1) + " : ";
                    
                    dos.writeInt(Dismin);
                    dos.writeUTF(s);
                    dos.writeInt(title.length());
                    
                    List<String> listSP = new ArrayList();
                    
                    for(int i = 0; i < numV; i++) {
                        if(i != pStart) {
                            dij.pEnd = i;
                            dij.DisMin();
                            listSP.add(dij.TruyVet(dij.pEnd));
                        }
                    }
                    dos.writeInt(listSP.size());
                    
                    for(String str : listSP) {
                        dos.writeUTF(str + "\n\n");
                    }
                }
        }catch(Exception e){}
    }
}