/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var neighbors: List[Node] = List()
 * }
 */
import scala.collection.mutable._
object Solution {
    var valToNode = Map[Int, Node]()
    def clone(graph: Node): Node = {
        if(graph == null) return null;

        if(valToNode.contains(graph.value)) return valToNode(graph.value)

        var newGraph = new Node(graph.value)
        valToNode(graph.value) = newGraph

        for(node <- graph.neighbors) {
            newGraph.neighbors :+= clone(node);
        }

        newGraph
    }
    
    def cloneGraph(graph: Node): Node = {
        valToNode.clear()

        clone(graph)     
    }
}
