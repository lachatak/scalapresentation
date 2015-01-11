package gamesys.presentation

class SMoney(val amount: Int = 0, val currency: String = "USD")

object SMoney {
  def apply(amount: Int = 0, currency: String = "USD") = new SMoney(amount, currency)
}

object ClassDefinition extends App {

  println(new SMoney(1, "GBP"))
  println(new SMoney(currency = "GBP"))

  println(SMoney(amount = 1))
  println(SMoney(currency = "GBP", amount = 3))
  println(SMoney())

}



