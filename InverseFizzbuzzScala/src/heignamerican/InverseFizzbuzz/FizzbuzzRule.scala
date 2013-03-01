package heignamerican.InverseFizzbuzz
import heignamerican.MyMath

trait FizzbuzzRule {
  def minLength(): Int
  def isFizzbuzz(num: Int): Boolean
  def toFizzbuzz(num: Int): String
}
