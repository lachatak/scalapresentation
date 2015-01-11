package gamesys.presentation

object TuplesExamples extends App {

  //declaration
  val triple = (12, "Joe", false)
  val pair1 = ("key", 10000)
  val pair2 = "key2" -> 2345

  println(triple._1)
  println(triple._2)
  println(triple._3)

  val (a, b, _) = triple
  println(a)
  println(b)

  //return value - no need for new class!
  def statistics(numbers: List[Int]) = {
    val min = numbers.min
    val max = numbers.max
    val avg = numbers.sum.toDouble / numbers.size
    (min, max, avg)
  }

  println(statistics(List(1, 2, 3, 4)))

}
