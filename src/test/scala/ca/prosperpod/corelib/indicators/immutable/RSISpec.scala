package ca.prosperpod.corelib.indicators.immutable

import org.scalatest.{FlatSpec, Matchers}

class RSISpec extends FlatSpec with Matchers{
  "An RSI" should "automatically implement value-based equality" in {
    val rsi1 = RSI(50)
    val rsi2 = RSI(50)
    assert(rsi1 == rsi2)
  }
}
