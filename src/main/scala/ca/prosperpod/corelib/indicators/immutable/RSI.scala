package ca.prosperpod.corelib.indicators.immutable

import ca.prosperpod.corelib.indicators.Indicator

@throws[IllegalArgumentException]
case class RSI(value: Int) extends Indicator(1) {
  // Bounds for RSI
  require(0 <= value && value <= 100)
}

