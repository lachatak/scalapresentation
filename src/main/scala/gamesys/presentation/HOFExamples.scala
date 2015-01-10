package gamesys.presentation

object HOFExamples extends App {

  def inc(x:Int) = x + 1

  def addLogger(fn:Int=>Int) = (a:Int) => {
    println("This is the input: " + a)
    fn.apply(a)
  }

  val loggingInc = addLogger(inc)

  val five = loggingInc(4)

  println (five)

}
