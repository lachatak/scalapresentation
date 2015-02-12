package gamesys.presentation

object FunctionalExamples extends App {

  val moneys = List(
    SMoney(2, "USD")
    , SMoney(3, "GBP")
    , SMoney(2, "USD")
    , SMoney(5, "USD")
    , SMoney(23, "GBP"))

  //FILTER ----------------------------------------
  println(moneys.filter(_.currency == "USD"))

  //MAP ----------------------------------------
  def multiplyBy10(m: SMoney) = m.copy(amount = m.amount * 10)


  println(moneys.map(multiplyBy10))

  //GROUP-BY ----------------------------------------
  println(moneys.groupBy(_.currency))

  //FOLD-LEFT  ----------------------------------------
  def add(m1: SMoney, m2: SMoney) = m1.copy(amount = m1.amount + m2.amount)

  def dollars = List(SMoney(1), SMoney(2), SMoney(3))

  println(dollars.foldLeft(SMoney())(add))

  //combine these
  val sumByCurrency =
    moneys
      .groupBy(_.currency)
      .map {
      keyVal => {
        val currency = keyVal._1
        val moneysWithThisCurrency = keyVal._2
        moneysWithThisCurrency.foldLeft(SMoney(0, currency))(add)
      }
    }

  println(sumByCurrency)


  /**
   * List<Student> students = persons.stream()
        .filter(p -> p.getAge() > 18)
        .map(Student::new)
        .collect(Collectors.toCollection(ArrayList::new));
   */
}
