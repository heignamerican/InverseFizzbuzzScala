package heignamerican.InverseFizzbuzz
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

import heignamerican.InverseFizzbuzz.MinLoopLogic.Entry

class MinLoopLogicTest extends AssertionsForJUnit {
  @Test def testMugen() {
    val actual = new MinLoopLogic(Fizzbuzz3and5, 1, 100).mInfinitLoop.take(30)
    val expected = Seq(Entry(3, "Fizz"), Entry(5, "Buzz"), Entry(6, "Fizz"), Entry(9, "Fizz"), Entry(10, "Buzz"), Entry(12, "Fizz"), Entry(15, "FizzBuzz"), Entry(18, "Fizz"), Entry(20, "Buzz"), Entry(21, "Fizz"), Entry(24, "Fizz"), Entry(25, "Buzz"), Entry(27, "Fizz"), Entry(30, "FizzBuzz"), Entry(33, "Fizz"), Entry(35, "Buzz"), Entry(36, "Fizz"), Entry(39, "Fizz"), Entry(40, "Buzz"), Entry(42, "Fizz"), Entry(45, "FizzBuzz"), Entry(48, "Fizz"), Entry(50, "Buzz"), Entry(51, "Fizz"), Entry(54, "Fizz"), Entry(55, "Buzz"), Entry(57, "Fizz"), Entry(60, "FizzBuzz"), Entry(63, "Fizz"), Entry(65, "Buzz"))
    assert(expected === actual)
  }

  @Test def test() {
    checkSingle(Seq("Fizz"), Result(3))
    checkSingle(Seq("Buzz"), Result(5))
    checkSingle(Seq("FizzBuzz"), Result(15))
    checkSingle(Seq("FizzBuzz", "Fizz"), Result(15, 18))
    checkSingle(Seq("Fizz", "Buzz"), Result(9, 10))
    checkSingle(Seq("Fizz", "Fizz", "Buzz"), Result(6, 10))
    checkSingle(Seq("Fizz", "Buzz", "Fizz"), Result(3, 6))
  }

  def checkSingle(aInput: Seq[String], aExpected: Result) = {
    assert(aExpected === new MinLoopLogic(Fizzbuzz3and5, 1, 100).inverseFizzbuzz(aInput))
  }

  @Test def test2() {
    checkSingle2(Seq("Fizz"), Result(21))
    checkSingle2(Seq("Buzz"), Result(25))
    checkSingle2(Seq("FizzBuzz"), Result(30))
    checkSingle2(Seq("FizzBuzz", "Fizz"), Result(30, 33))
    checkSingle2(Seq("Fizz", "Buzz"), Result(24, 25))
    checkSingle2(Seq("Fizz", "Fizz", "Buzz"), Result(21, 25))
    checkSingle2(Seq("Fizz", "Buzz", "Fizz"), Result(24, 27))
  }

  def checkSingle2(aInput: Seq[String], aExpected: Result) = {
    assert(aExpected === new MinLoopLogic(Fizzbuzz3and5, 20, 100).inverseFizzbuzz(aInput))
  }
}