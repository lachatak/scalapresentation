package gamesys.presentation

// Normal class definition
class NormalClassMoney(val amount: Int = 0, val currency: String = "USD") {

  def +(value: Int) = NormalClassMoney(this.amount + value, this.currency)

  def canEqual(other: Any): Boolean = other.isInstanceOf[NormalClassMoney]

  override def equals(other: Any): Boolean = other match {
    case that: NormalClassMoney =>
      (that canEqual this) &&
        amount == that.amount &&
        currency == that.currency
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(amount, currency)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString() = s"Money($amount,$currency)"
}

object NormalClassMoney {
  def apply(amount: Int, currency: String) = new NormalClassMoney(amount, currency)
}

object NormalClassRunner extends App {

  val money = NormalClassMoney(50, "USD")
  println(money + 40)

  val set = Set(NormalClassMoney(100, "USD"), NormalClassMoney(200, "USD"), NormalClassMoney(100, "USD"))

  println(set)
}

// Case class

case class CaseClassMoney(amount: Int = 0, currency: String = "USD"){
  def +(value: Int) = copy(amount = this.amount + value)
}

object CaseClassRunner extends App {

  val money = CaseClassMoney(50, "USD")
  println(money + 40)

  val set = Set(CaseClassMoney(100, "USD"), CaseClassMoney(200, "USD"), CaseClassMoney(100, "USD"))

  println(set)

}
