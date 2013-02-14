package heignamerican.InverseFizzbuzz
import org.scalatest.junit.AssertionsForJUnit
import org.junit._
import heignamerican.InverseFizzbuzz.MinLoopLogic.Result

class MinLoopLogicTest extends AssertionsForJUnit {
  @Test def test() {
    show("Fizz")
    show("Buzz")
    show("FizzBuzz")
    show("FizzBuzz", "Fizz")
    show("Fizz", "Buzz")
    show("Fizz", "Fizz", "Buzz")
    show("Fizz", "Buzz", "Fizz")
  }

  def show(aInput: String*) = {
    val tVal = MinLoopLogic.inverseFizzbuzz(aInput, 1, 100)
    println(aInput.toList + " => " + tVal)
  }
}