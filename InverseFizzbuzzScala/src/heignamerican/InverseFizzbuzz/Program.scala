package heignamerican.InverseFizzbuzz
import javax.xml.transform.Result

object Program extends App {
  show("Fizz")
  show("Buzz")
  show("FizzBuzz")
  show("FizzBuzz", "Fizz")
  show("Fizz", "Buzz")
  show("Fizz", "Fizz", "Buzz")
  show("Fizz", "Buzz", "Fizz")

  def show(aInput: String*) = {
    val MIN = 1
    val MAX = 100
    println(aInput.toList + " => " + MinLoopLogic.invFizzbuzz(aInput, MIN, MAX))
  }
}
