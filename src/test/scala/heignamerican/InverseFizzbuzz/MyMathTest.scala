package heignamerican.InverseFizzbuzz
import org.scalatest.FunSuite
import heignamerican.MyMath

class MyMathTest extends FunSuite {
  test("gcd test") {
    assert(3 === MyMath.gcd(3, 3))
    assert(1 === MyMath.gcd(5, 7))
    assert(3 === MyMath.gcd(9, 3))
    assert(3 === MyMath.gcd(3, 9))
    assert(2 === MyMath.gcd(4, 6))
    assert(2 === MyMath.gcd(6, 4))
    assert(8 === MyMath.gcd(32, 24))
  }

  test("lcm test") {
    assert(1 === MyMath.lcm(List(1)))
    assert(15 === MyMath.lcm(List(3, 5)))
    assert(12 === MyMath.lcm(List(2, 3, 4)))
  }
}
