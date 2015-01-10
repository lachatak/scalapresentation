package gamesys.presentation

object PatternMatchingExamples extends App {

  val a = 5
  val b = "Scala world!"
  val list = List(2, 5, 6)
  val pair = ("key", "config.value")
  val items = Map("item1" -> 100, ("item2", 200))
  val optional = Some("optionalValue")

  def simpleMatcher(m: Any) = m match {
    case i: Integer => println(s"We have an Integer $i")
    case s: String => println( s"""We have a String "$s"""")
    case head :: tail => println(s"We have a list with tail $tail")
    case m: Map[String, Integer] if m.get("item1") == Some(100) => println(s"We have a map with size ${m.size}")
    case s@Some(value) => println( s"""We have a "$value" wrapped to $s""")
    case (_, second) => println(s"We have a pair where the value is $second")
    case _ => println("Cannot process!!")
  }

  simpleMatcher(a)
  simpleMatcher(b)
  simpleMatcher(list)
  simpleMatcher(pair)
  simpleMatcher(items)
  simpleMatcher(optional)
  simpleMatcher(None)


  println("--------------------------------")

  //Events ----------------------------------------

  sealed trait Event {
    val name: String
  }

  case class BoughtInEvent(name: String, amount: SMoney) extends Event

  case class BustOutEvent(name: String) extends Event

  //no need for explicit casting
  //deconstruction
  def printEvent(event: Event) = event match {
    case BoughtInEvent(id, SMoney(5, _)) => println(s"${id} has bought in with five something")
    case BoughtInEvent("Joe", amount) => println(s"Joe has bought in with ${amount}")
    case BustOutEvent("Joe") => println("Joe has bust out")
    case _ => println("Something unexpected happened")
  }

  printEvent(BoughtInEvent("Jack", SMoney(5, "GBP")))
  printEvent(BoughtInEvent("Joe", SMoney()))
  printEvent(BustOutEvent("Joe"))
  printEvent(BustOutEvent("Jack"))

  println("--------------------------------")

  //Fibonacci ------------------------------------------------------
  def fib(n: Int): Int = n match {
    case 0 => 1
    case 1 => 1
    case x => fib(x - 1) + fib(x - 2)
  }

  println("Fib 0: " + fib(0))
  println("Fib 1: " + fib(1))
  println("Fib 5: " + fib(5))

  println("--------------------------------")

  val PATTERN = """.*(\d\d)-(\d\d)?-(\d\d\d\d).*""".r

  def regexMatcher(text: String) = text match {
    case PATTERN(day, month, year) => println(s"$year/$month/$day")
  }

  regexMatcher("The release is going to happen on 20-03-2015 which is great!!")
}
