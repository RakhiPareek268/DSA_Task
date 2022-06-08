package datastructures

import scala.annotation.tailrec

abstract class IntTree
case object EmptyTree extends IntTree
case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree

trait Tree[A <: Ordered[A]] {
  def incl(tree: IntTree, value:Int): IntTree
  def contains(tree: IntTree,value:Int): Boolean
}
class BinaryTree[A <: Ordered[A]] extends Tree[A]{
  override def incl(tree: IntTree, value:Int): IntTree = {
    tree match {
      case EmptyTree => Node(value, EmptyTree, EmptyTree)
      case Node(element, left, right) if (element < value) =>
        Node(element, incl(left, value), right)
      case Node(element, left, right) if (element > value) =>
        Node(element, left, incl(right, value))
      case _ => tree
    }
  }
  @tailrec
  final override def contains(tree: IntTree, value: Int): Boolean = {
    tree match {
      case EmptyTree => false
      case Node(e, left, _) if e < value => contains(left, value)
      case Node(e, _, right) if e > value => contains(right, value)
      case _ => true
    }
  }
}




