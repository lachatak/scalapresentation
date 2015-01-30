package gamesys.presentation

object ImplicitsExample extends App {

  val text = "This is some important text with lots of unnecessary spaces!"

}

object StringImplicits {

  implicit class StringManipulator(text: String) {
    def removeWhiteSpaces = text.replaceAll(" ", "")

    def flipWords = text.split(" ").map(_.reverse).mkString(" ")
  }

}


