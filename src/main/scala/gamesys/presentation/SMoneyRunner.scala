package gamesys.presentation

case class SMoney(val amount:Int = 0, val currency:String="USD")

object SMoneyRunner extends App {

  println(SMoney(1,"GBP"))
  println(SMoney(currency = "GBP"))
  println(SMoney(amount = 1))
  println(SMoney())

}
