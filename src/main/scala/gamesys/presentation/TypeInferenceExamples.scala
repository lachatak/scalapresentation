package gamesys.presentation

object TypeInferenceExamples extends App {

  //vals
  val text = "John"

  //vars
  var text3 = "Joe1"
  text3 = "Jane"

  val text2: String = "With defined type"
  val name = "Joe"
  val number = 20

  //collections
  val itemList = List(1, 2, 3, 4, 5)
  val itemSet = Set(1, 2, 3, 4, 5)
  val numbers = 1 to 6

  val map: Map[String, String] = Map.empty
  var map2 = Map.empty[String, Int]
  map2 = map2 + (""->1)
  val map3 = Map("key1" -> 1, "key2" -> 2, "key3" -> 3)

  val list = List(2, "adad", true)

//  val message: String = 20

  //tuples
  val (a,b) = (12,"")
  val aTuple = (45,"23",true)

  //methods
  def add(a: Int, b: Int):Int = {
    a + b
  }

  def add2(a: Int, b: Int):Int = a + b

  def add3(a: Int, b: Int) = a + b

  debug("item" + "value" + "key" + "text")
  def debug(text: => String): Unit ={
    print(text)
  }

  def print(text: Any) {
    println(text)
  }

  class Test(amount:Int){
      println(amount)
  }

}
