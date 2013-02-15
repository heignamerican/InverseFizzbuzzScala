package heignamerican.InverseFizzbuzz
import heignamerican.MyMath

trait FizzbuzzRule {
  def getMap(): Seq[(Int, String)]

  def minLength(): Int = {
    MyMath.lcm(getMap().map(x => x._1).toSeq)
  }

  def isFizzbuzz(num: Int): Boolean = getMap().exists(x => num % x._1 == 0)
  def toFizzbuzz(num: Int) = getMap().filter(x => num % x._1 == 0).map(x => x._2).mkString
}
