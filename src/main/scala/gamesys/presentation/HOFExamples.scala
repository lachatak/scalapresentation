package gamesys.presentation

object HOFExamples extends App {

  def inc(x: Int) = x + 1
  val inc2 = (x: Int) => x + 1
  def inc3(x: => String) {
    println(x)
  }

  def addLogger(fn: Int => Int) = (a: Int) => {
    println("This is the input: " + a)
    fn.apply(a)
  }

  val loggingInc = addLogger(inc2)

  val five = loggingInc(4)

  println(five)

}
