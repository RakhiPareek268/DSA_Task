package datastructures
object  Queve{
  def empty[A]:Queve[A]=new Queve(Nil,Nil)
}
class Queve[A](insert:List[A],remove:List[A]){
  def isEmpty:Boolean=insert.isEmpty && remove.isEmpty

  def push(elem:A):Queve[A]=new Queve(elem::insert,remove)
  def pop():(A,Queve[A])=
    remove match {
      case head::tail=>(head,new Queve(insert,tail))
      case Nil=>
        val head :: tail = insert.reverse
        (head, new Queve(Nil,tail))
    }

}