package heignamerican.InverseFizzbuzz
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

import heignamerican.InverseFizzbuzz.MinLoopLogic.Entry

class MinLoopLogicTest extends AssertionsForJUnit with org.scalatest.junit.JUnitSuite {
  @Test def testMugen() {
    val actual = new MinLoopLogic(Fizzbuzz3and5, 1, 100).mInfinitLoop.take(30)
    val expected = Seq(Entry(3, "Fizz"), Entry(5, "Buzz"), Entry(6, "Fizz"), Entry(9, "Fizz"), Entry(10, "Buzz"), Entry(12, "Fizz"), Entry(15, "FizzBuzz"), Entry(18, "Fizz"), Entry(20, "Buzz"), Entry(21, "Fizz"), Entry(24, "Fizz"), Entry(25, "Buzz"), Entry(27, "Fizz"), Entry(30, "FizzBuzz"), Entry(33, "Fizz"), Entry(35, "Buzz"), Entry(36, "Fizz"), Entry(39, "Fizz"), Entry(40, "Buzz"), Entry(42, "Fizz"), Entry(45, "FizzBuzz"), Entry(48, "Fizz"), Entry(50, "Buzz"), Entry(51, "Fizz"), Entry(54, "Fizz"), Entry(55, "Buzz"), Entry(57, "Fizz"), Entry(60, "FizzBuzz"), Entry(63, "Fizz"), Entry(65, "Buzz"))
    assert(expected === actual)
  }

  @Test def test() {
    assertAnswer(1, 100, Seq("Fizz"), Result(3))
    assertAnswer(1, 100, Seq("Buzz"), Result(5))
    assertAnswer(1, 100, Seq("FizzBuzz"), Result(15))
    assertAnswer(1, 100, Seq("FizzBuzz", "Fizz"), Result(15, 18))
    assertAnswer(1, 100, Seq("Fizz", "Buzz"), Result(9, 10))
    assertAnswer(1, 100, Seq("Fizz", "Fizz", "Buzz"), Result(6, 10))
    assertAnswer(1, 100, Seq("Fizz", "Buzz", "Fizz"), Result(3, 6))

    assertAnswer(20, 100, Seq("Fizz"), Result(21))
    assertAnswer(20, 100, Seq("Buzz"), Result(25))
    assertAnswer(20, 100, Seq("FizzBuzz"), Result(30))
    assertAnswer(20, 100, Seq("FizzBuzz", "Fizz"), Result(30, 33))
    assertAnswer(20, 100, Seq("Fizz", "Buzz"), Result(24, 25))
    assertAnswer(20, 100, Seq("Fizz", "Fizz", "Buzz"), Result(21, 25))
    assertAnswer(20, 100, Seq("Fizz", "Buzz", "Fizz"), Result(24, 27))
  }

  private def assertAnswer(start: Int, end: Int, aInput: Seq[String], aExpected: heignamerican.InverseFizzbuzz.Result): Unit = {
    assert(aExpected === new MinLoopLogic(Fizzbuzz3and5, start, end).inverseFizzbuzz(aInput))
  }
}