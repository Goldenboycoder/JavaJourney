# Graph

A Graph is a non-linear data structure consisting of vertices and edges. The vertices are sometimes also referred to as nodes and the edges are lines or arcs that connect any two nodes in the graph. More formally a Graph is composed of a set of vertices( V ) and a set of edges( E ). The graph is denoted by G(E, V).


![graph](../Media/graph.jpg)

## Components of a Graph

- Vertices: Vertices are the fundamental units of the graph. Sometimes, vertices are also known as vertex or nodes. Every node/vertex can be labeled or unlabelled.
- Edges: Edges are drawn or used to connect two nodes of the graph. It can be ordered pair of nodes in a directed graph. Edges can connect any two nodes in any possible way. There are no rules. Sometimes, edges are also known as arcs. Every edge can be labeled/unlabelled.



Graphs are used to solve many real-life problems. Graphs are used to represent networks. The networks may include paths in a city or telephone network or circuit network. Graphs are also used in social networks like linkedIn, Facebook. For example, in Facebook, each person is represented with a vertex(or node). Each node is a structure and contains information like person id, name, gender, locale etc.


## Directed Graph

Characteristics of Directed Graph
Directed graphs have several characteristics that make them different from undirected graphs. Here are some key characteristics of directed graphs:

- Directed edges: In a directed graph, edges have a direction associated with them, indicating a one-way relationship between vertices.
- Indegree and Outdegree: Each vertex in a directed graph has two different degree measures: indegree and outdegree. Indegree is the number of incoming edges to a vertex, while outdegree is the number of outgoing edges from a vertex.
- Cycles: A directed graph can contain cycles, which are paths that start and end at the same vertex and contain at least one edge. Cycles can be important for understanding feedback loops or other patterns in the graph.
- Paths and reachability: Paths in a directed graph follow the direction of the edges, and can be used to analyze reachability between vertices.



### Applications of Directed Graph

Directed graphs have many applications across a wide range of fields. Here are some examples:

- Social networks: Social networks are often modeled as directed graphs, where each person is a vertex and relationships such as friendships or following are represented as edges.
- Transportation networks: Transportation systems such as roads, airports, or subway systems can be modeled as directed graphs, with vertices representing locations and edges representing connections between them.
- Computer networks: Computer networks such as the internet can be represented as directed graphs, with vertices representing devices such as computers or routers and edges representing connections between them.
- Project management: Project management can be modeled as a directed graph, with vertices representing tasks and edges representing dependencies between them.



### Advantages of Directed Graph
- Can model complex relationships: Directed graphs are useful for modeling complex relationships where directionality is important, such as social networks or transportation systems.
- Can be used for analysis: Directed graphs allow for analysis of the flow of relationships or information in a system, which can be useful for optimization or understanding of the system’s behavior.
- Can represent dependencies: Directed graphs are useful for representing dependencies between entities, such as in project management or recommender systems.

### Disadvantages of Directed Graph
- May be more complex: Directed graphs can be more complex than undirected graphs, since each edge has a direction associated with it.
- May require more processing power: Analyzing directed graphs may require more processing power than analyzing undirected graphs, since the directionality of the edges must be taken into account.
- Maybe less intuitive: Since directed graphs are less common than undirected graphs, they may be less intuitive for people to work with or understand.



# Reference

https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/

https://www.geeksforgeeks.org/what-is-directed-graph-directed-graph-meaning/

