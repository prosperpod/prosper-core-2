package ca.prosperpod.corelib.units.mutable

import ca.prosperpod.corelib.indicators.Indicator

import scala.collection.mutable

class Stock(val symbol: String,
            var price: BigDecimal,
            val indicators: mutable.AnyRefMap[String, Indicator]
           ) extends Cloneable with Serializable {

  override def clone(): Stock =
    new Stock(symbol, price, indicators.clone())

  override def equals(that: scala.Any): Boolean = that match {
    case other: Stock => other.symbol == symbol && other.price == price &&
      other.indicators == indicators
    case _ => false
  }

  override def hashCode(): Int = (symbol, price, indicators).##

  override def toString: String = s"mutable.Stock($symbol, $price, $indicators)"
}

object Stock {
  def apply(symbol: String, price: BigDecimal): Stock =
    new Stock(symbol, price, mutable.AnyRefMap())

  def unapply(arg: Stock): (String, BigDecimal) = (arg.symbol, arg.price)
}