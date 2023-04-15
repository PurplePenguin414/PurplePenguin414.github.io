// Delta College - CST 283 - Klingler & Dale Text                  
// This class includes a generic graph defined by a vertext set and
// an edge set.

import java.util.*;

public class Graph<VertexType extends Comparable<VertexType>>
{
    private final int MAX_VERTICES = 100;
    private final int MAX_EDGES    = 50;  
    private final int NULL_EDGE    = -1;
    
    int numVertices;
    int maxVertices;
    ArrayList<VertexType> vertices;
    int edges[][];
    boolean marks[];      

    //------------------------------------------------------------------
    // Constructor.  Set graph to initial values.
    public Graph()
    {
        numVertices = 0;
        maxVertices = MAX_VERTICES;

        vertices = new ArrayList<VertexType>();
        edges    = new int[MAX_EDGES][MAX_EDGES];
        marks    = new boolean[MAX_VERTICES];
    }

    //------------------------------------------------------------------
    // Adds vertex to the graph.
    // Pre:  Graph is not full.
    // Post: Corresponding row and column of edges have been set
    // to null.  Variable numVertices has been incremented.
    public void addVertex(VertexType vertex)
    {
        vertices.add(numVertices,vertex);
        for (int index = 0; index < numVertices; index++)
        {
          edges[numVertices][index] = NULL_EDGE;
          edges[index][numVertices] = NULL_EDGE;
        }
        numVertices++;
    }

    //------------------------------------------------------------------
    // Return index of vertex in vertices.
    public int indexIs(ArrayList<VertexType> vertices, VertexType vertex)
    {
        int index = 0;
        while (vertex.compareTo(vertices.get(index)) != 0)
           index++;
        return index;
    }

    //------------------------------------------------------------------
    // Adds an edge with the specified weight from fromVertex to toVertex.
    // Pre:  fromVertex and toVertex are in V(graph)
    // Post: (fromVertex, toVertex) is in E(graph) with the specified weight.
    public void addEdge(VertexType fromVertex, VertexType toVertex, int weight)

    {
        int row,col;
        row = indexIs(vertices, fromVertex);
        col = indexIs(vertices, toVertex);
        edges[row][col] = weight;
    }

    //------------------------------------------------------------------
    // Determines the weight of the edge from fromVertex to toVertex.
    // Pre:  fromVertex and toVertex are in V(graph)
    // Post: Function value = weight associated with the edge (fromVertex, toVertex).
    public int weightIs(VertexType fromVertex, VertexType toVertex)
    {
        int row;
        int col;
        row = indexIs(vertices, fromVertex);
        col = indexIs(vertices, toVertex);
        return edges[row][col];
    }

    //------------------------------------------------------------------
    // Returns a queue of the vertices that are adjacent from vertex.
    // Pre:  Vertex is in V(graph).
    // Post: adjVertexQ contains the names of all the vertices that are
    //       heads of edges for which vertex is the tail.
    public void getToVertices(VertexType vertex, LinkedQueue<VertexType> adjVertexQ)
    {
        int fromIndex;
        int toIndex;

        fromIndex = indexIs(vertices, vertex);
        for (toIndex = 0; toIndex < numVertices; toIndex++)
          if (edges[fromIndex][toIndex] != NULL_EDGE)
            adjVertexQ.enqueue(vertices.get(toIndex));
    }

    //------------------------------------------------------------------
    // Sets marks for all vertices to false.
    public void clearMarks()

    {
        for (int index = 0; index < numVertices; index++)
        {
          marks[index] = false;
        }
    }

    //------------------------------------------------------------------
    // Sets mark for vertex to true.
    // Pre:  vertex is in V(graph).
    public void markVertex(VertexType vertex)
    {
        int index = 0;
        while (vertex.compareTo(vertices.get(index)) != 0)
           index++;
        marks[index] = true;
    }

    //------------------------------------------------------------------
    // Determines if vertex has been marked.
    // Pre:  vertex is in V(graph).    
    public boolean isMarked(VertexType vertex)
    {
        int index = 0;
        while (vertex.compareTo(vertices.get(index)) != 0)
           index++;
        if (marks[index])
            return true;
        else
            return false;
    }
    
    // =================================================================
    // =================================================================
      
    // -----------------------------------------------------------------
    // Traverse this graph depth-first. 
    // Param:  starting vertex and search target
    void depthFirstSearch(VertexType startVertex, VertexType endVertex) 
    {
        LinkedStack<VertexType> stack   = new LinkedStack<VertexType>();
        LinkedQueue<VertexType> vertexQ = new LinkedQueue<VertexType>();
        boolean found = false;
        VertexType vertex;
        VertexType item;

        this.clearMarks();

        stack.push(startVertex);
        do 
        {
            vertex = stack.pop();
            if (vertex == endVertex) 
            {
                System.out.print(vertex + " ");
                found = true;
            }
            else
            {
                if (!this.isMarked(vertex)) 
                {
                    this.markVertex(vertex);
                    System.out.print(vertex + " ");
                    this.getToVertices(vertex, vertexQ);
                    while (!vertexQ.isEmpty()) 
                    {
                        item = vertexQ.dequeue();
                        if (!this.isMarked(item)) 
                            stack.push(item);
                    }
                }
            }
        } while (!stack.isEmpty() && !found);
        
        if (!found) 
            System.out.println("Path not found.");
        else
            System.out.print("\n");
    }

    //------------------------------------------------------------------
    void breadthFirstSearch(VertexType startVertex, VertexType endVertex)    
    // Traverse this graph breadth-first. 
    // Param:  starting vertex and search target
    {
        LinkedQueue<VertexType> queue   = new LinkedQueue<VertexType>();
        LinkedQueue<VertexType> vertexQ = new LinkedQueue<VertexType>();
        
        boolean found = false;
        VertexType vertex;
        VertexType item;

        this.clearMarks();
        queue.enqueue(startVertex);
        do 
        {
            vertex = queue.dequeue();
            if (vertex == endVertex) 
            {
                System.out.print(vertex + " ");
                found = true;
            } 
            else 
            {
                if (!this.isMarked(vertex)) 
                {
                    this.markVertex(vertex);
                    System.out.print(vertex + " ");
                    this.getToVertices(vertex, vertexQ);
                    while (!vertexQ.isEmpty()) 
                    {
                        item = vertexQ.dequeue();
                        if (!this.isMarked(item)) 
                            queue.enqueue(item);
                    }
                }
            }
        } while (!queue.isEmpty() && !found);
        
        if (!found) 
            System.out.println("Path not found.");
        else
            System.out.print("\n");
    }

}

