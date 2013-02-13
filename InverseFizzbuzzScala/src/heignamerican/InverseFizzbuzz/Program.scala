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
    println(aInput.toList + " => " + MinLoopLogic.inverseFizzbuzz(aInput, 1, 100))
  }
}
