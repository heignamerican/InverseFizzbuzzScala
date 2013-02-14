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
    checkSingle(Result(3), "Fizz")
    checkSingle(Result(5), "Buzz")
    checkSingle(Result(15), "FizzBuzz")
    checkSingle(Result(15, 18), "FizzBuzz", "Fizz")
    checkSingle(Result(9, 10), "Fizz", "Buzz")
    checkSingle(Result(6, 10), "Fizz", "Fizz", "Buzz")
    checkSingle(Result(3, 6), "Fizz", "Buzz", "Fizz")
  }

  def checkSingle(aExpected: Result, aInput: String*) = {
    assert(aExpected == MinLoopLogic.inverseFizzbuzz(aInput, 1, 100))
  }
}