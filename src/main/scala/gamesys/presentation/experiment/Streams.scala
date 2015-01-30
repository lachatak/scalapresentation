package gamesys.presentation.experiment

object Streams extends App {

  //val ints = Stream.c

  def successors(n:Int):Stream[Int] = Stream.cons(n, successors(n+1))

  val posIntegers = successors(1)
  println(posIntegers.head)
  println(posIntegers.head)
}
