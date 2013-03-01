package heignamerican.InverseFizzbuzz
import heignamerican.MyMath

trait FizzbuzzRule {
  def getMap(): Seq[(Int, String)]

  def minLength(): Int = {
    MyMath.lcm(getMap().map { case (num, _) => num }.toSeq)
  }

  def isFizzbuzz(num: Int): Boolean = getMap().exists { case (x, _) => num % x == 0 }
  def toFizzbuzz(num: Int) = getMap().collect { case (n, r) if num % n == 0 => r }.mkString
}
