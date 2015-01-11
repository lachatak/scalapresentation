package gamesys.presentation

object ImplicitsExample extends App {

  import gamesys.presentation.StringImplicits._

  val text = "This is some important text with lots of unnecessary spaces!"

  println(text.removeWhiteSpaces)
  println(text.flipWords)

}

object StringImplicits {

  implicit class StringManipulator(text: String) {
    def removeWhiteSpaces = text.replaceAll(" ", "")

    def flipWords = text.split(" ").map(_.reverse).mkString(" ")
  }

}


