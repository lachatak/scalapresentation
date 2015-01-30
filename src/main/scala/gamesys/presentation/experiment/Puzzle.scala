package gamesys.presentation.experiment

object Puzzle extends App {

  def steps(nums: List[Int]): Option[List[Int]] = nums match {
    case List() => None
    case head :: tail => steps(nums, List())
  }

  def steps(nums: List[Int], acc: List[Int]): Option[List[Int]] = {
    val jumpRange = nums.head
    val newAcc = acc :+ jumpRange
    if (jumpRange >= nums.size) Some(newAcc)
    else {
      val rest = for {
        i <- 1 to jumpRange
        c <- steps(nums.drop(i), newAcc)
      } yield c
      if (rest.isEmpty) None else Some(rest.minBy(_.size))
    }
  }

  def steps2(nums: List[Int]): Option[List[Int]] =
    if (nums.isEmpty) None
    else {
      val jumpRange = nums.head
      if (jumpRange >= nums.size) Some(List(jumpRange))
      else {
        val rest = for {
          i <- 1 to jumpRange
          c <- steps2(nums.drop(i))
        } yield jumpRange :: c
        if (rest.isEmpty) None else Some(rest.minBy(_.size))
      }
    }

  assert(steps(List(4, 0, 5, 0, 1, 2)) == Some(List(4, 5)))
  assert(steps(List()) == None)
  assert(steps(List(0, 1, 2)) == None)
  assert(steps(List(2, 0, 0, 1)) == None)
  assert(steps(List(1, 1, 1)) == Some(List(1, 1, 1)))
  assert(steps(List(3, 4, 1, 1)) == Some(List(3, 4)))
  assert(steps(List(3, 1, 1)) == Some(List(3)))
  assert(steps(List(2, 2, 0, 3, 3, 1, 1)) == Some(List(2, 2, 3, 3)))


  println (steps2(List(4, 0, 5, 0, 1, 2)))
  assert(steps2(List(4, 0, 5, 0, 1, 2)) == Some(List(4, 5)))
  assert(steps2(List()) == None)
  assert(steps2(List(0, 1, 2)) == None)
  assert(steps2(List(2, 0, 0, 1)) == None)
  assert(steps2(List(1, 1, 1)) == Some(List(1, 1, 1)))
  assert(steps2(List(3, 4, 1, 1)) == Some(List(3, 4)))
  assert(steps2(List(3, 1, 1)) == Some(List(3)))
  assert(steps2(List(2, 2, 0, 3, 3, 1, 1)) == Some(List(2, 2, 3, 3)))
  /**/
}

