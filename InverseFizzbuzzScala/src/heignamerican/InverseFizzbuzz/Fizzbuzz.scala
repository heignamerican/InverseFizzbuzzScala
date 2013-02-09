package heignamerican.InverseFizzbuzz

object Fizzbuzz {
  def isFizzbuzz = (x: Int) => x % 3 == 0 || x % 5 == 0
  def toFizzbuzz = (x: Int) => {
    (x % 3, x % 5) match {
      case (0, 0) => "FizzBuzz"
      case (0, _) => "Fizz"
      case (_, 0) => "Buzz"
    }
  }
}
