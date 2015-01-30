package gamesys.presentation

import java.util.{ArrayList => JArrayList}

import com.google.common.collect.Lists

import scala.beans.BeanProperty

object ScalaJavaInteropExamples extends App {

  import scala.collection.JavaConversions._

  val jmoney1 = new JMoney(10)
  val jmoney2 = new JMoney(20)
  val jmoney3 = new JMoney(30)

  val jMoneyJavaList = new JArrayList[JMoney]()
  jMoneyJavaList.add(jmoney1)
  jMoneyJavaList.add(jmoney2)
  jMoneyJavaList.add(jmoney2)

  val jMoneyJavaList2 = Lists.newArrayList(jmoney1, jmoney2, jmoney3)

  val filteredScalaList1 = jMoneyJavaList.filter((jmoney: JMoney) => jmoney.getAmount > 5)
  val isGreaterThen5 = jMoneyJavaList.forall((jmoney) => jmoney.getAmount > 5)
  val filteredScalaList2 = jMoneyJavaList2.dropWhile(_.getAmount < 30)

  println(jmoney1)
  println(jmoney1.getAmount)

  println(filteredScalaList1)
  println(isGreaterThen5)
  println(filteredScalaList2)

  class Test(amount:Int){

    def printAmount(): Unit ={
      println(amount)
    }

    printAmount()

  }

  val t = new Test(4)
  t.printAmount();
}
