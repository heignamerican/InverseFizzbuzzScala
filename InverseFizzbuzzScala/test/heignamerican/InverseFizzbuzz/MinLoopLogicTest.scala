package heignamerican.InverseFizzbuzz
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit
import org.junit.Ignore

class MinLoopLogicTest extends AssertionsForJUnit {
  @Test def testMugen() {
    val extractedLocalValue = MinLoopLogic.getMugen
    extractedLocalValue.take(30).foreach(println)
  }

  @Test def test() {
    show(Result(3), "Fizz")
    show(Result(5), "Buzz")
    show(Result(15), "FizzBuzz")
    show(Result(15, 18), "FizzBuzz", "Fizz")
    show(Result(9, 10), "Fizz", "Buzz")
    show(Result(6, 10), "Fizz", "Fizz", "Buzz")
    show(Result(3, 6), "Fizz", "Buzz", "Fizz")
  }

  def show(aExpected: Result, aInput: String*) = {
    assert(aExpected == MinLoopLogic.inverseFizzbuzz(aInput, 1, 100))
  }
}