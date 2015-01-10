package gamesys.presentation

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._

object ForComprehensionExamples extends App {

  val numbers = 1 to 5

  val simpleCopyResult = for {n <- numbers} yield n
  println("simpleCopyResult: " + simpleCopyResult)

  val mapResult = for {n <- numbers} yield n * 2
  println("mapResult: " + mapResult)

  val result = for {n <- numbers if n > 3} yield n * 2
  println("result: " + result)

  //combine two lists
  val letters = 'a' to 'c'
  val combinations = for {
    n <- numbers
    l <- letters
    if n > 3
  } yield (n, l)

  println("combinations: " + combinations)

  val x = Future {
    2 + 5
  }
  val y = Future {
    5 + 7
  }
  println("x: " + x)
  println("y: " + y)

  val sum = for {
    xval <- x
    yval <- y
  } yield xval + yval

  sum onSuccess {
    case x => println("Sum of the futures: " + x)
  }


}
