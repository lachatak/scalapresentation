package gamesys.presentation.experiment

object ImplicitTest extends App {

  implicit var x = 0

  def increaseIt(a:Int)(implicit x:Int) = a + x

  def fiddle() {
    ImplicitTest.x = ImplicitTest.x + 1
  }

  def giveANumber()  = ImplicitTest.increaseIt(3)

  println(giveANumber())
  fiddle()
  println(giveANumber())
}
