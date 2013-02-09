package heignamerican.InverseFizzbuzz
import heignamerican.InverseFizzbuzz.Fizzbuzz._

object MinLoopLogic {
  val mMinLoop = Range(1, 16).filter(isFizzbuzz).map(x => Entry(x, toFizzbuzz(x)))

  def invFizzbuzz = (aInput: Seq[String], aMin: Int, aMax: Int) => {
    val tList =
      Range(0, mMinLoop.size + 1)
        .map(aStart => getExtends(mMinLoop, aStart, aInput.size))
        .filter(_.zip(aInput).forall(x => x._1.fizzbuzz == x._2))
        .map(x => Result(x.head.number, x.last.number))
        .filter(x => aMin <= x.left && x.right <= aMax)
    if (tList.size == 0)
      None
    else
      tList.min(new Ordering[Result]() { def compare(left: Result, right: Result) = left.length - right.length })
  }

  case class Entry(number: Int, fizzbuzz: String) {
    def next = Entry(number + 15, fizzbuzz)
  }
  case class Result(left: Int, right: Int) {
    def length = right - left
  }

  def getExtends = (aInput: Seq[Entry], aStart: Int, aCount: Int) => {
    def ee(aList: List[Entry], aIndex: Int): List[Entry] = {
      if (aList.length == aCount)
        aList
      else {
        val tEntry = aInput(aIndex % aInput.size)
        ee(aList ::: List(
          if (!aList.isEmpty && tEntry.number < aList.last.number)
            tEntry.next
          else
            tEntry), aIndex + 1)
      }
    }
    ee(List(), aStart)
  }
}
