package ca.prosperpod.corelib.units.mutable

import scala.reflect.api.Universe

class Algorithm(val name: String,
                val account: Account,
                var universe: List[Stock],
                var eventHandlers: List[EventHandler],
                val stockDB: StockDB) extends Serializable

class AutoSavingAlgorithm(name: String, account: Account, universe: List[Stock],
                          eventHandlers: List[EventHandler], stockDB: StockDB
                         ) extends Algorithm(name, account, universe, {
  new EventHandler {
    override def handle[T >: Event](event: T): Unit = event match {
      case MarketEndDayEvent(date) => {

      }
      case _ => Unit
    }
  } :: eventHandlers
}, stockDB)


class RSIAlgorithm(account: Account,
                   universe: List[Stock],
                   stockDB: StockDB,
                  ) extends Algorithm("rsi-alg-1", account, universe, {

  val handler = new EventHandler {
    override def handle[T >: Event](event: T): Unit = event match {
      case MarketEndDayEvent(date) => {

      }
      case _ => Unit
    }
  }

  List(handler)
}, stockDB)
