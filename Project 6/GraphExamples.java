import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Iterator;
/**
 * This class provides a utility to build a graph from a list of edges.
 *
 * It also contains specific factory methods to generate graph instances used
 * as examples within Data Structures and Algorithms in Java, 6th edition.
 */
public class GraphExamples {

  /**
   * Constructs a graph from an array of array strings.
   *
   * An edge can be specified as { "SFO", "LAX" }, in which case edge is created
   * with default edge value of 1, or as { "SFO", "LAX", "337" }, in which case
      labels.add(edge[0]);
   * the third entry should be a string that will be converted to an integral value.
   */
  public static Graph<String,Integer> graphFromEdgelist(String[][] edges, boolean directed) {
    Graph<String,Integer> g = new AdjacencyMapGraph<>(directed);

    // first pass to get sorted set of vertex labels
    TreeSet<String> labels = new TreeSet<>(); 
    for (String[] edge : edges) {
      labels.add(edge[0]);
      labels.add(edge[1]);
    }
    /*Iterator<String> i = labels.iterator();
    System.out.println("Labels TreeSet: ");
    while (i.hasNext()) {
    	System.out.println(i.next() + " "); 
    }*/

    // now create vertices (in alphabetical order)
    HashMap<String, Vertex<String> > verts = new HashMap<>(); // HashMap<K, V>
    for (String label : labels) {
      verts.put(label, g.insertVertex(label)); // put(K key, V value);
    	// g.insertVertex(label) returns a Vertex with the given element.
    	//label is a key, Vertex is value associated with label	
    }  

    // now add edges to the graph
    for (String[] edge : edges) {
      Integer cost = (edge.length == 2 ? 1 : Integer.parseInt(edge[2])); // edge length equals to 2 mean no weight/cost, so get default value of 1 for the edge 
      g.insertEdge(verts.get(edge[0]), verts.get(edge[1]), cost);
    }
    return g;
  }

  /** Returns the unweighted, directed graph from Figure 14.3 of DSAJ6. */
  
  public static Graph<String,Integer> Graph0() {
    String[][] edges = {
      {"A","C"}, {"A","D"}, {"B","D"}, {"B", "F"}, {"C","D"}, {"C","E"},
      {"C","H"}, {"D","F"}, {"E","G"}, {"F","G"}, {"F","H"}, {"G","H"}
    };
    return graphFromEdgelist(edges, true);
  }
  
  
  public static Graph<String,Integer> Graph1() {
    String[][] edges = {
      {"A","B"}, {"A","E"}, {"A","F"},
      {"B","C"}, {"B","F"}, 
      {"C","D"}, {"C","G"},
      {"D","G"}, {"D","H"}, 
      {"G","L"}, {"G","K"}, {"G","J"},
      {"J","K"}, {"J","I"},
      {"I","E"}, {"I","M"},{"I", "F"},{"I", "N"},
      {"E","F"},
      {"M","N"},
      {"N","K"},
      {"K","O"},
      {"L","H"}, {"L","P"},
    };
    return graphFromEdgelist(edges, false);
  }
  
  public static Graph<String,Integer> Graph2() {
	    String[][] edges = {
	      {"V0","V1","2"}, {"V0","V3"}, 
	      {"V1","V3","3"}, {"V1","V4","10"}, 
	      {"V2","V0","4"}, {"V2","V5","5"},
	      {"V3","V2","2"}, {"V3","V4","2"}, {"V3","V5","8"},{"V3","V6","4"},  
	      {"V4","V6","6"}, 
	      {"V6","V5","1"}
	    };
	    return graphFromEdgelist(edges, true);
  }
  
  /* Convert an element to a Vertex */

  /*public Vertex<V> convertToVertex(V element) {
     InnerVertex<V> v = new InnerVertex<>(element, isDirected);
     return v;
   }
  /* DSF Graph Traversal */
/*public static void DFS(Graph<String,Integer> g, String start, String end) {
	  //Set<Vertex<String>> visited = new HashSet<>();
	  ArrayList<Vertex<String>> visited = new  ArrayList<>();
	  HashMap<Vertex<String>, Edge<Integer>> forest = new HashMap<Vertex<String>, Edge<Integer>>();
	  AdjacencyMapGraph<String, Integer> amg = (AdjacencyMapGraph<String, Integer>) g; // casting Graph to Adjacency Map Graph
	  Vertex<String> s =  amg.getVertex(start);
	  Vertex<String> e =  amg.getVertex(end);
	  DFS(g, s, e, visited, forest);
  }
 private static void DFS(Graph<String,Integer> g, Vertex<String> start, Vertex<String> end, ArrayList<Vertex<String>> visited, HashMap<Vertex<String>, Edge<Integer>> forest) {  
	  if (start.getElement().equals(end.getElement())) {// reach to the end vertex, then print out path list that is visited
		  System.out.println("DFS Path from source to destination: ") ;
		  visited.add(end); // add end vertex to the list since 
		  for (Vertex<String> vtx : visited) {
			  System.out.println(vtx.getElement());
		  }
		  return;
	  }	
	  visited.add(start); // add a visited node
	  for (Edge<Integer> e : g.outgoingEdges(start)) { // for every outgoing edge from u
		  //System.out.println("Edge: " + e.getElement());
		  Vertex<String> v = g.opposite(start, e); // return the other end point of the edge
		  //System.out.println("Adjacent nodes with " + start.getElement() + ": "  + v.getElement());
		  if (!visited.contains(v)) {
			  //System.out.println("v is undiscovered: " + v.getElement());
			  forest.put(v, e);	
			  DFS(g, v, end, visited, forest);
			
		  }  
	  }

  }*/
  public static <V,E> void DFS(Graph<V,E> g, V start, V end) {
	  //Set<Vertex<String>> visited = new HashSet<>();
	  ArrayList<Vertex<V>> visited = new  ArrayList<>();
	  HashMap<Vertex<V>, Edge<E>> forest = new HashMap<Vertex<V>, Edge<E>>();
	  AdjacencyMapGraph<V, E> amg = (AdjacencyMapGraph<V, E>) g; // casting Graph to Adjacency Map Graph
	  Vertex<V> s =  amg.getVertex(start);
	  Vertex<V> e =  amg.getVertex(end);
	  DFS(g, s, e, visited, forest);
  }
 private static <V,E> void DFS(Graph<V,E> g, Vertex<V> start, Vertex<V> end, ArrayList<Vertex<V>> visited, HashMap<Vertex<V>, Edge<E>> forest) {  
	  if (start.getElement().equals(end.getElement())) {// reach to the end vertex, then print out path list that is visited
		  System.out.println("DFS Path from source to destination: ") ;
		  visited.add(end); // add end vertex to the list since 
		  for (Vertex<V> vtx : visited) {
			  System.out.println(vtx.getElement());
		  }
		  return;
	  }	
	  visited.add(start); // add a visited node
	  for (Edge<E> e : g.outgoingEdges(start)) { // for every outgoing edge from u
		  //System.out.println("Edge: " + e.getElement());
		  Vertex<V> v = g.opposite(start, e); // return the other end point of the edge
		  //System.out.println("Adjacent nodes with " + start.getElement() + ": "  + v.getElement());
		  if (!visited.contains(v)) {
			  //System.out.println("v is undiscovered: " + v.getElement());
			  forest.put(v, e);	
			  DFS(g, v, end, visited, forest);
			
		  }  
	  }

  }

 public static <V> ProbeHashMap<Vertex<V>, Integer> shortestPath(Graph<V,Integer> g, V src) {
	 ProbeHashMap<Vertex<V>, Integer> cloud = new ProbeHashMap<>(); // map includes reachable vertices
	 ProbeHashMap<Vertex<V>, Integer> d = new ProbeHashMap<>(); // map records distance from source to all other vertices
	 ProbeHashMap<Vertex<V>, Entry<Integer, Vertex<V>>> pqTokens = new ProbeHashMap<>();  // map save entry for future updates for PQ entry; store Integer as keys, minimum key at the top
	 SortedPriorityQueue<Integer, Vertex<V>> pq = new SortedPriorityQueue<>(); // PQ determine next vertex to examine shortest paths
	 
	 AdjacencyMapGraph<V, Integer> amg = (AdjacencyMapGraph<V, Integer>) g; // casting Graph to Adjacency Map Graph
	 Vertex<V> srcVtx =  amg.getVertex(src); // convert source to Vertex
	 // For each vertex of the graph, add entry to the PQ
	 // initialize the distance of 0 for source and infinite distances for all other vertices 
	 for (Vertex<V> v : g.vertices()) {	
		 if (v == srcVtx) { 
			 d.put(v, 0);
		 } else {
			 d.put(v, Integer.MAX_VALUE);
		 }
		 pqTokens.put(v, pq.insert(d.get(v),v)); // save entry to update PQ later
	 }
	 //System.out.println("PQ: " + pq.printEntry());
	 // Add reachable vertices to the cloud
	 while (!pq.isEmpty()) {
		 Entry<Integer, Vertex<V>> entry = pq.removeMin();
		 //System.out.println("Remove min "+ i + " : Vertex is " + entry.getValue().getElement() + " Distance: " + entry.getKey());
		 int key = entry.getKey(); // get distance of the vertex
		 Vertex<V> u = entry.getValue(); // get the vertex
		 cloud.put(u, key); // place vertex u with its associated distance (shortest distance from source to u) into the cloud
		 pqTokens.remove(u); // u is no longer in PQ, so don't need to keep it in PQ tokens for future updates
		 for (Edge<Integer> e : g.outgoingEdges(u)) {
			 Vertex<V> v = g.opposite(u,e);
			 //System.out.println("Vertex: "+ u.getElement() + " to Vertex " + v.getElement() + " edge: " + e.getElement());
			 if (cloud.get(v) == null) { // paths to vertex v is not discovered yet ?
				 int wgt = e.getElement(); // get distance(u,v)
				 //System.out.println("Shorter? New path from source to D[" + v.getElement() + "]: " + (d.get(u) + wgt));
				 //System.out.println("Current path from source to D[" + v.getElement() + "]: " + d.get(v)); 
				 if (d.get(u) + wgt < d.get(v)) { // shorter path from u to v or d[v]? 	 
					 d.put(v, d.get(u) + wgt); // update d[v]
					 pq.replaceKey(pqTokens.get(v), d.get(v));
					 //System.out.println("Updated PQ: ");
					 //pq.printEntry();
				 }
			 }
		 }
	 }
	 return cloud;
 }

  public static void main(String[] args) {
  
   //System.out.println("Graph 0");
    //System.out.println(Graph0());
    
    System.out.println("Graph 1");
    System.out.println(Graph1());
    Graph<String,Integer> g1 = Graph1();
    DFS(g1, "A", "O");
    System.out.println();
    
   System.out.println("Graph 2");
   System.out.println(Graph2());
   /* Shortest Paths from source to all other vertices in Graph 2*/
   ProbeHashMap<Vertex<String>, Integer> cloud = shortestPath(Graph2(), "V0");
   Iterator <Entry<Vertex<String>, Integer>>  entries = cloud.entrySet().iterator();
   System.out.println("Shortest paths from source to all other vertices in Graph 2: ");
   while (entries.hasNext()) {
	   Entry<Vertex<String>, Integer> entry = entries.next();
	   System.out.println("D[" + entry.getKey().getElement() + "]: " + entry.getValue());
   }

   
  }

}
