package ca.prosperpod.corelib.indicators.immutable

case class RSI(value: Int) extends Indicator(1) {
  // Bounds for RSI
  require(0 <= value && value <= 100)

  override def toString: String = value.toString
}

object RSI {

}


