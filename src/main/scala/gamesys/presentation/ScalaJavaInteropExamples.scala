package gamesys.presentation

object ScalaJavaInteropExamples extends App {

  val jmoney = new JMoney()

  println(jmoney)
  println(jmoney.getAmount)

}
