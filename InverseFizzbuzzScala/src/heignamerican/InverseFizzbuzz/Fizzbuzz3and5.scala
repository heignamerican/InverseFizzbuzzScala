package heignamerican.InverseFizzbuzz

case class Fizzbuzz3and5 extends FizzbuzzRule {
  def getMap() = Seq((3, "Fizz"), (5, "Buzz"))
}