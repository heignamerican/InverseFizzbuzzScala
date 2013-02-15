package heignamerican.InverseFizzbuzz
import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test
import heignamerican.MyMath

class MyMathTest extends AssertionsForJUnit {
  @Test def test() {
    assert(1 === MyMath.lcm(List(1)))
    assert(15 === MyMath.lcm(List(3, 5)))
    assert(12 === MyMath.lcm(List(2, 3, 4)))
  }
}
