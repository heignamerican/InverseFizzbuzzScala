package heignamerican.InverseFizzbuzz;

object Result {
  def apply(number: Int) = new Result(number, number)
}

case class Result(left: Int, right: Int) extends Ordered[Result] {
  def length = right - left

  override def compare(another: Result): Int = (length - another.length) match {
    case 0 => -1
    case x => x
  }

  override def toString(): String = {
    length match {
      case 0 => "Result(%d)".format(left)
      case _ => "Result(%d,%d)".format(left, right)
    }
  }
}