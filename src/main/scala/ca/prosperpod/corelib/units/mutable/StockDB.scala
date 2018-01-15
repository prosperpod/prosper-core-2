package ca.prosperpod.corelib.units.mutable

import java.util.Date

trait StockDB extends Serializable {
  def put(date: Date, stocks: List[Stock]): Unit

  def get(date: Date): List[Stock]

  def getStockWithSymbol(date: Date, symbol: String): Option[Stock] = {
    for (stock <- get(date)) {
      if (stock.symbol == symbol) return Some(stock)
    }
    None
  }

  def apply(date: Date): List[Stock] = get(date)

  def update(date: Date, stocks: List[Stock]): Unit = put(date, stocks)
}
