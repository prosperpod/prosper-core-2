package ca.prosperpod.corelib.units.mutable

import ca.prosperpod.corelib.indicators.immutable.RSI

import scala.collection.mutable

class Stock(val symbol: String,
            var price: BigDecimal,
            val rsiMap: mutable.HashMap[Int, RSI] = mutable.HashMap()
           ) extends Cloneable {

  def nDayRSI(n: Int): Option[RSI] = rsiMap get n

  override def clone(): Stock =
    new Stock(symbol, price, rsiMap.clone())

  override def equals(that: scala.Any): Boolean = that match {
    case other: Stock => other.symbol == symbol && other.price == price &&
      other.rsiMap == rsiMap
    case _ => false
  }

  override def hashCode(): Int = (symbol, price, rsiMap).##

  override def toString: String = s"mutable.Stock($symbol, $price, $rsiMap)"
}

object Stock {
  def apply(symbol: String, price: BigDecimal): Stock = new Stock(symbol, price)
}
