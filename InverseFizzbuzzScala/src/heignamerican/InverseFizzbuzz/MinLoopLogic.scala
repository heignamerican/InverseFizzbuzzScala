package heignamerican.InverseFizzbuzz
import scala.math.Ordering

import heignamerican.InverseFizzbuzz.Fizzbuzz.isFizzbuzz
import heignamerican.InverseFizzbuzz.Fizzbuzz.toFizzbuzz

object MinLoopLogic {
  val mMinLoop = Range(1, 16).filter(isFizzbuzz).map(x => Entry(x, toFizzbuzz(x)))

  def inverseFizzbuzz = (aInput: Seq[String], aMin: Int, aMax: Int) => {
    val tList =
      Range(0, mMinLoop.size + 1)
        .map(aStart => getExtends(mMinLoop, aStart, aInput.size))
        .filter(_.zip(aInput).forall(x => x._1.fizzbuzz == x._2))
        .map(x => Result(x.head.number, x.last.number))
        .filter(x => aMin <= x.left && x.right <= aMax)

    tList.size match {
      case 0 => None
      case _ => tList.min
    }
  }

  case class Entry(number: Int, fizzbuzz: String) {
    def next = Entry(number + 15, fizzbuzz)
  }
  case class Result(left: Int, right: Int) extends Ordered[Result] {
    def length = right - left
    override def compare(another: Result): Int = (length - another.length) match {
      case 0 => -1
      case x => x
    }
  }

  def getExtends = (aInput: Seq[Entry], aStart: Int, aCount: Int) => {
    def extend(aList: List[Entry], aIndex: Int): List[Entry] = {
      if (aList.length == aCount)
        aList
      else {
        val tEntry = aInput(aIndex % aInput.size)
        extend(aList ::: List(
          if (!aList.isEmpty && tEntry.number < aList.last.number)
            tEntry.next
          else
            tEntry), aIndex + 1)
      }
    }
    extend(List(), aStart)
  }
}
