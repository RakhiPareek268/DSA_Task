package datastructures
trait Linkedlist[T] {
  def insertNode(data:T): Unit
  def appendNode(data:T): Unit
  def prependNode(data:T):Unit
  def display():Unit
}
class Implementations [T]() extends Linkedlist[T]{
  var startNode:Node[T]=null
  def insertNode(data:T): Unit ={
    startNode match{
      case null => startNode=Node(data,null)
      case _=>{
        var last:Node[T]=startNode
        while(last.next!=null){
          last=last.next
        }
      }
    }
  }
  def appendNode(data:T): Unit ={
    insertNode(data)
  }
  def prependNode(data:T):Unit={
    val newNode:Node[T]=new Node[T](data,startNode)
    startNode=newNode
  }
  def display(): Unit = {
    if (startNode != null) {
      startNode.printList();
    }
    println();
  }
}
sealed case class Node[T](var data:T,var next:Node[T]) {
  def getData: T = this.data

  def getNext: Node[T] = this.next

  def printList(): Unit = {
    print(data)
    if (next != null) {
      print(",")
      next.printList()
    }
  }
}





