package heignamerican.InverseFizzbuzz
import scala.math.Ordering
import heignamerican.InverseFizzbuzz.Fizzbuzz.isFizzbuzz
import heignamerican.InverseFizzbuzz.Fizzbuzz.toFizzbuzz
import scala.collection.immutable.Stream

object MinLoopLogic {
  val mMinLoop = Range(1, 16).filter(isFizzbuzz).map(x => Entry(x, toFizzbuzz(x)))
  val mInfinitLoop = getMugen()

  def inverseFizzbuzz = (aInput: Seq[String], aMin: Int, aMax: Int) => {
    val tList = Range(0, mMinLoop.size + 1)
      .map(aStart => mInfinitLoop.drop(aStart).take(aInput.size))
      .filter(_.zip(aInput).forall(x => x._1.fizzbuzz == x._2))
      .map(x => Result(x.head.number, x.last.number))
      .filter(x => aMin <= x.left && x.right <= aMax)

    tList.size match {
      case 0 => None
      case _ => tList.min
    }
  }

  case class Entry(number: Int, fizzbuzz: String) {
  }

  def getMugen(): Stream[Entry] = {
    def from(s: Seq[Entry], i: Int): Stream[Entry] = {
      val t = s(i % s.size)
      Stream.cons(Entry(t.number + 15 * (i / s.size), t.fizzbuzz), from(s, i + 1))
    }
    from(mMinLoop, 0)
  }
}
