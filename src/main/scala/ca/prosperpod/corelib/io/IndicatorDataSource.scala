package ca.prosperpod.corelib.io

import java.util.Date

import ca.prosperpod.corelib.indicators.immutable.RSI

trait IndicatorDataSource extends Serializable

trait RSIDataSource extends IndicatorDataSource {
  def fetchRSI(symbol: String, date: Date): RSI

  // Default implementation.
  def fetchRSI(symbols: List[String], date: Date): List[(String, RSI)] =
    for (sym <- symbols) yield (sym, fetchRSI(sym, date))
}