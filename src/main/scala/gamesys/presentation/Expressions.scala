package gamesys.presentation

object Expressions extends App {


  def parser(text: String) = try {
    Some(Integer.parseInt(text))
  } catch {
    case e: Exception => None
  }

  println(parser("10"))
  println(parser("text"))

  val list = 1 to 5
  val result = if (list.size > 10) true else false
  println(result)

  def matchResult(value: Option[Integer]) = value match {
    case Some(v) => Some(v * v)
    case None => None
  }

  println(matchResult(Some(10)))

  val forCompResult = for {
    l <- 1 to 10
  } yield l + "text"

  println(forCompResult)

}
