package ca.prosperpod.corelib.units.immutable

import ca.prosperpod.corelib.indicators.Indicator

import scala.collection.immutable.HashMap

@deprecated // NOT SAFE TO IMPLEMENT YET
case class Stock(symbol: String, price: BigDecimal,
                 private val indicators: HashMap[String, Indicator] = HashMap()
                ) extends Serializable {

  def getIndicator[T >: Indicator](id: String): Option[T] =
    indicators get id

  def setIndicator(id: String, indicator: Indicator): Stock =
    copy(indicators = indicators + (id -> indicator))

  /*
  override def toString: String =
    s"immutable.Stock($symbol, $price, $indicators)"
  */

  override def toString: String = "immutable." + super.toString
}
