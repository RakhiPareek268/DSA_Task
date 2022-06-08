package datastructures

class Stack(size:Int){
  private val stack = new Array[Double](size)
  private var top= -1

  def push(ele: Double): Unit = {
    top += 1
    stack(top)=ele
  }
  def pop(ele:Double):Double={
    val popEle=stack(top)
    top-=1
    popEle
  }
  def peek():Double={
    val peekEle=stack(top)
    peekEle
  }
  def isEmpty:Boolean={
    (top == -1)
  }
  def isFull:Boolean={
   (top == size-1)
  }
}
