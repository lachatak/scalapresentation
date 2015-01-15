package gamesys.presentation

object ControlStructureExample extends App {

  def loopWhile(cond: => Boolean)(body: => Unit):Unit =
    if (cond) {
      body
      loopWhile(cond)(body)
    }

  var i =10
  loopWhile(i > 0) {
    println(i)
    i = i - 1
  }

}
