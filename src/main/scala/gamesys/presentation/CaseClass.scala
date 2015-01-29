package gamesys.presentation


// Case class
case class SMoney(amount: Int = 0, currency: String = "USD")

case class SMoney2(amount: Int = 0, currency: String = "USD"){
  def +(value: Int) = copy(amount = this.amount + value)
}

object CaseClassRunner extends App {


  println(SMoney(1, "GBP"))
  println(SMoney(currency = "GBP"))

  println(SMoney(amount = 1))
  println(SMoney(currency = "GBP", amount = 3))
  println(SMoney())



  val set = Set(SMoney(100, "USD"), SMoney(200, "USD"), SMoney(100, "USD"))

  println(set)


  //---------------------------------------- operator = method
  val money = SMoney2(50, "USD")
  println(money + 40)




}
