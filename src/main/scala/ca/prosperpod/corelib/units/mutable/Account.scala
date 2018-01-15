package ca.prosperpod.corelib.units.mutable

import scala.collection.mutable

class Account(val name: String,
              initBalance: BigDecimal,
              val investments: mutable.HashMap[String, BigDecimal],
              val criticalBalance: BigDecimal = 0
             ) extends Serializable {

  private var _balance: BigDecimal = initBalance

  def balance: BigDecimal = _balance

  def buy(symbol: String, quantity: BigDecimal, price: BigDecimal): Unit = {
    investments get symbol match {
      case Some(n) => investments update(symbol, n + quantity)
      case None => investments update(symbol, quantity)
    }
    val decrement = price * quantity
    if (_balance - decrement < criticalBalance) throw
      CriticalBalanceException(_balance, decrement, criticalBalance)
    _balance -= price * quantity
  }

  @throws[StockNotFoundException]
  def value(priceMap: mutable.Map[String, BigDecimal]): BigDecimal = {
    investments.foldRight(BigDecimal(0))((pair, total) => {
      priceMap get pair._1 match {
        case Some(price) => total + (price * pair._2)
        case None => throw new StockNotFoundException(s"'pair._1' NOT FOUND!")
      }
    })
  }

  @throws[StockNotFoundException]
  def value(stockList: List[Stock]): BigDecimal = {
    val values = for (stock <- stockList
                      if investments contains stock.symbol) yield
      investments(stock.symbol) * stock.price
    if (values.lengthCompare(investments.size) != 0)
      throw new StockNotFoundException("SIZE MISMATCH OF INVESTMENTS LIST " +
        "AND COMPUTED VALUES LIST!")
    values.sum
  }

  class StockNotFoundException(msg: String) extends NoSuchElementException {
    override def getMessage: String = msg
  }

  case class CriticalBalanceException(balance: BigDecimal,
                                      attemptedDecrement: BigDecimal,
                                      criticalBalance: BigDecimal
                                     ) extends RuntimeException {
    override def getMessage: String = s"ATTEMPTED TO DECREMENT " +
      s"'balance = $$$balance' BY '$$$attemptedDecrement', WHICH EXCEEDS THE " +
      s"CRITICAL BALANCE OF '$$$criticalBalance'!"
  }
}

object Account {
  def apply(name: String, balance: BigDecimal): Account =
    new Account(name, balance, mutable.HashMap())
}