package heignamerican

object MyMath {
  def gcd(left: Int, right: Int): Int = {
    (left, left > right) match {
      case (0, _) => right
      case (_, true) => gcd(right, left)
      case (_, _) => gcd(left, right - left)
    }
  }

  def lcm(values: Seq[Int]) = {
    values match {
      case Nil => 0
      case x :: Nil => x
      case xs => xs.fold(1)((x, y) => lcmBase(x, y))
    }
  }

  private def lcmBase(left: Int, right: Int): Int = left * right / gcd(left, right)
}