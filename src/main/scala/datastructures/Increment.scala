package datastructures
import datastructures.Increment.incr

import java.util.concurrent.atomic.AtomicInteger

class Increment extends Runnable{
  override def run(): Unit = {
    incr.incrementAndGet()
    println(s"Thread is running counter= $incr")
  }
}
object Increment{
  private var incr = new AtomicInteger
  def main(args: Array[String]): Unit = {
    for (x <- 1 to 2000) {
      val th = new Thread(new Increment())
      th.start()
    }
  }
}
