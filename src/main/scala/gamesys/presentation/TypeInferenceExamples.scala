package gamesys.presentation

object TypeInferenceExamples extends App {

  val text: String = "With defined type"
  val name = "Joe"
  val number = 20
  val items = List(1, 2, 3, 4, 5)
  val numbers = 1 to 6
  val map: Map[String, String] = Map.empty
  val map2 = Map("key" -> 1000)
  val list = List(2, "adad", true)

  //  val message: String = 20

  //no need to specify return type
  def add(a: Int, b: Int) = a + b

  def print(text: Any) {
    println(text)
  }

}
