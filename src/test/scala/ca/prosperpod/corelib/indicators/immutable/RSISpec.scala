package ca.prosperpod.corelib.indicators.immutable

import org.scalatest.{FlatSpec, Matchers}

class RSISpec extends FlatSpec with Matchers {

  "An RSI" can "be initialized from an integer value" in {
    val rsi = RSI(50)
    println(s"RSI = $rsi")
  }

  it should "automatically implement value-based equality" in {
    val rsi1 = RSI(50)
    val rsi2 = RSI(50)
    assert(rsi1 == rsi2)
  }

  it must "have a value that satisfies 0 <= RSI <= 100" in {
    assertThrows[IllegalArgumentException] {
      val rsi = RSI(101)
    }
    assertThrows[IllegalArgumentException] {
      val rsi = RSI(-1)
    }
  }

}
