package gamesys.presentation

case class SMoney(amount: Int = 0, currency: String = "USD")

object SMoneyRunner extends App {

  println(SMoney(1, "GBP"))
  println(SMoney(currency = "GBP"))
  println(SMoney(amount = 1))
  println(SMoney(currency = "GBP", amount = 3))
  println(SMoney())

}
