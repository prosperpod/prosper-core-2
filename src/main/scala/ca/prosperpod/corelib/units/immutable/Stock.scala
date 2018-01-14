package ca.prosperpod.corelib.units.immutable

import ca.prosperpod.corelib.indicators.immutable.RSI

import scala.collection.immutable.HashMap

case class Stock(symbol: String, price: BigDecimal,
                 private val rsiMap: HashMap[Int, RSI] = HashMap()
                ) extends Serializable {

  def nDayRSI(n: Int): Option[RSI] = rsiMap get n

  def addRSI(n: Int, rsi: RSI): Stock = copy(rsiMap = rsiMap + (n -> rsi))

  override def toString: String = s"immutable.Stock($symbol, $price, $rsiMap)"
}

object Stock {

  def apply(symbol: String, price: BigDecimal): Stock = new Stock(symbol, price)

}