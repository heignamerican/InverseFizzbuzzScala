package heignamerican.InverseFizzbuzz
import scala.collection.immutable.Stream

import heignamerican.InverseFizzbuzz.MinLoopLogic.Entry

object MinLoopLogic {
  case class Entry(number: Int, fizzbuzz: String) {
  }
}

class MinLoopLogic(mRule: FizzbuzzRule, mMin: Int, mMax: Int) {
  val mMinLoopSize = mRule.minLength()
  val mMinLoop = Range.inclusive(1, mMinLoopSize).filter(mRule.isFizzbuzz).map(x => MinLoopLogic.Entry(x, mRule.toFizzbuzz(x)))
  val mInfinitLoop = from(mMinLoop).filter(x => x.number > mMin)

  def inverseFizzbuzz = (aInput: Seq[String]) => {
    val tList = Range.inclusive(0, mMinLoop.size)
      .map(aStart => mInfinitLoop.drop(aStart).take(aInput.size))
      .filter(_.zip(aInput).forall(x => x._1.fizzbuzz == x._2))
      .map(x => Result(x.head.number, x.last.number))
      .filter(x => x.right <= mMax)

    tList.size match {
      case 0 => None
      case _ => tList.min
    }
  }

  def from(seq: Seq[Entry]): Stream[Entry] = {
    def _from(s: Seq[Entry], r: Stream[Entry]): Stream[Entry] = {
      s match {
        case Nil => r
        case _ if (r == Nil) =>
          val nextSeq = seq.map { x => Entry(x.number + mRule.minLength(), x.fizzbuzz) }
          _from(s.dropRight(1), s.last #:: from(nextSeq))
        case _ => _from(s.dropRight(1), s.last #:: r)
      }
    }
    _from(seq, Stream.Empty)
  }
}
