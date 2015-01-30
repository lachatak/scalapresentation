package gamesys.presentation

object SyntaxExamples extends App {

  //vals
  val text = "John"

  //vars
  var text3 = "Joe1"
  text3 = "Jane"

  //collections
  val itemList = List(1, 2, 3, 4, 5)
  val itemSet = Set(1, 2, 3, 4, 5)
  val numbers = 1 to 6
  val map = Map("key1" -> 1, "key2" -> 2, "key3" -> 3)

  //tuples
  val (a,b) = (12,"")
  val aTuple = (45,"23",true)


  //methods
  def add(a: Int, b: Int):Int = {
    a + b
  }

  def add2(a: Int, b: Int):Int = a + b

  def add3(a: Int, b: Int) = a + b




}
