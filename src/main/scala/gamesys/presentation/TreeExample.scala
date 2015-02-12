package gamesys.presentation

object TreeExample {
  /*
      sealed trait Tree[T <: Comparable] {

      }
      object EmptyTree extends Tree[Nothing]

      case class Node[T <: Comparable](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {

        def insert(x: T): Tree[T] = x match {
          case y if (x.compareTo(value) == 0) => Node(value, left, right)
          case y if (x.compareTo(value) == 1) => this.copy(left = left.insert(x))
          case _ => this.copy(right = right.insert(x))
        }

        def treeElem(x: T) = x match {
          case y if (x.compareTo(y) == 0) => true
          case y if (x.compareTo(y) == 1) => left.treeElem(x)
          case _ => right.treeElem(x)
        }
      }

    object Tree {
      def singleton[T <: Comparable](x: T) = Node(x, EmptyTree[T], EmptyTree[T])
      def buildTree[T <: Comparable](values: List[T]) = values.foldLeft(EmptyTree)((tree, value) => tree.insert(value))
    }
  */
}
