// Delta College - CST 283 - Klingler & Dale C++ Text          
// This program demostrates building and working with a graph using
// the Graph class

import javax.swing.JOptionPane;
import java.util.*;

public class GraphDriver
{   
    public static void main(String[ ] args)
    {            
       // Build graph
       Graph<String> theGraph = new Graph<String>();
   
       buildGraph(theGraph);   

       // Write sequence of depth-first search of graph
       System.out.println("Depth-first search:");
       theGraph.depthFirstSearch("E","F");     
       System.out.println("\n\n"); 
       
       // Clear out all traversal markings for graph
       theGraph.clearMarks();

       // Write sequence of breadth-first search of graph
       System.out.println("Breadth-first search:");
       theGraph.breadthFirstSearch("E","F");      
       System.out.println("\n\n");

       System.exit(0);
    }

    // Function to build and rebuild graph for demonstration
    public static void buildGraph(Graph<String> theGraph)
    {
       // Add vertices
       theGraph.addVertex("A");
       theGraph.addVertex("B");
       theGraph.addVertex("C");
       theGraph.addVertex("D");
       theGraph.addVertex("E");
       theGraph.addVertex("F");
       theGraph.addVertex("G");
       theGraph.addVertex("H");
   
       // Add edges
       theGraph.addEdge("D","E",1);
       theGraph.addEdge("E","D",1);
       theGraph.addEdge("D","H",1);
       theGraph.addEdge("H","D",1);
       theGraph.addEdge("E","G",1);
       theGraph.addEdge("G","E",1);
       theGraph.addEdge("E","C",1);
       theGraph.addEdge("C","E",1);
       theGraph.addEdge("A","C",1);
       theGraph.addEdge("C","A",1);
       theGraph.addEdge("A","B",1);
       theGraph.addEdge("B","A",1);
       theGraph.addEdge("A","F",1);
       theGraph.addEdge("F","A",1);
    }
}