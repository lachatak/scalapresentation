package gamesys.presentation

object ControlStructureExample extends App {

  //------ CUSTOM LOOP ----------
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

  //------ UNLESS ----------

  def unless(cond:Boolean)(pos: => Unit) = if (!cond) pos

  unless(3 > 4) { println("ha") }

}
