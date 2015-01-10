package gamesys.presentation

object TuplesExamples extends App {

  //declaration
  val (a,b,c) = (12,"Joe",false)

  println(a)
  println(b)
  println(c)

  //return value - no need for new class!
  def statistics(numbers:List[Int]) = {
    val min = numbers.min
    val max = numbers.max
    val avg = numbers.sum.toDouble / numbers.size
    (min, max, avg)
  }

  println(statistics(List(1,2,3,4)))

}
