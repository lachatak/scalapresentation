package gamesys.presentation

object PatternMatchingExamples extends App {

  //Events ----------------------------------------

  trait Event {
    val name:String
  }

  case class BoughtInEvent(val name:String, val amount:SMoney) extends Event
  case class BustOutEvent(val name:String) extends Event

  //no need for explicit casting
  //deconstruction
  def printEvent(event:Event) = event match {
    case BoughtInEvent(id, SMoney(5,_)) => println(s"${id} has bought in with five something")
    case BoughtInEvent("Joe",amount) => println(s"Joe has bought in with ${amount}")
    case BustOutEvent("Joe") => println("Joe has bust out")
    case _ => println("Something unexpected happened")
  }
  
  printEvent(BoughtInEvent("Jack",SMoney(5,"GBP")))
  printEvent(BoughtInEvent("Joe",SMoney()))
  printEvent(BustOutEvent("Joe"))
  printEvent(BustOutEvent("Jack"))

  //Fibonacci ------------------------------------------------------
  def fib(n:Int):Int = n match {
    case 0 => 1
    case 1 => 1
    case x => fib(x-1) + fib(x-2)
  }

  println("Fib 0: "+ fib(0))
  println("Fib 1: "+ fib(1))
  println("Fib 5: "+ fib(5))

}
