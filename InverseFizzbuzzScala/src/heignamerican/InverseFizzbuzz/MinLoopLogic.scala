package heignamerican.InverseFizzbuzz
import scala.collection.immutable.Stream

import heignamerican.InverseFizzbuzz.MinLoopLogic.Entry

object MinLoopLogic {
  case class Entry(number: Int, fizzbuzz: String) {
  }
}

class MinLoopLogic(mRule: FizzbuzzRule) {
  val mMinLoopSize = mRule.minLength()
  val mMinLoop = Range.inclusive(1, mMinLoopSize).filter(mRule.isFizzbuzz).map(x => MinLoopLogic.Entry(x, mRule.toFizzbuzz(x)))
  val mInfinitLoop = from(mMinLoop, 0)

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

  def from(s: Seq[Entry], i: Int): Stream[Entry] = {
    val t = s(i % s.size)
    Stream.cons(Entry(t.number + mMinLoopSize * (i / s.size), t.fizzbuzz), from(s, i + 1))
  }
}
