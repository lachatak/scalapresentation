package gamesys.presentation

object FunctionalExamples extends App {

  val moneys = List(
    CaseClassMoney(2, "USD")
    , CaseClassMoney(3, "GBP")
    , CaseClassMoney(2, "USD")
    , CaseClassMoney(5, "USD")
    , CaseClassMoney(23, "GBP"))

  //FILTER ----------------------------------------
  println(moneys.filter(_.currency == "USD"))

  //MAP ----------------------------------------
  def multiplyBy10(m: CaseClassMoney) = m.copy(amount = m.amount * 10)

  println(moneys.map(multiplyBy10))

  //GROUP-BY ----------------------------------------
  println(moneys.groupBy(_.currency))

  //FOLD-LEFT  ----------------------------------------
  def add(m1: CaseClassMoney, m2: CaseClassMoney) = m1.copy(amount = m1.amount + m2.amount)

  def dollars = List(CaseClassMoney(1), CaseClassMoney(2), CaseClassMoney(3))

  println(dollars.foldLeft(CaseClassMoney())(add))

  //combine these
  val sumByCurrency =
    moneys
      .groupBy(_.currency)
      .map {
      keyVal => {
        val currency = keyVal._1
        val moneysWithThisCurrency = keyVal._2
        moneysWithThisCurrency.foldLeft(CaseClassMoney(0, currency))(add)
      }
    }

  println(sumByCurrency)


}
