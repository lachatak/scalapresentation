package gamesys.presentation


object WithMainMethod {

  def main(args: Array[String]) {
    println("Hello " + args(0))
  }

}

object WeDontNeedMainMethod extends App {
  println("Look, I don't need a static main method! Hello " + args(0))
}


