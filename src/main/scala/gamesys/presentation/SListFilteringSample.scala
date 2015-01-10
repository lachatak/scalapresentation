package gamesys.presentation

object SListFilteringSample extends App {

  val elements = List(1, 2, 3, 4, 5)

  //work starts
  val filteredElements = elements.filter(_ < 4)
  //work ends

  println("filteredElements:" + filteredElements)
}
