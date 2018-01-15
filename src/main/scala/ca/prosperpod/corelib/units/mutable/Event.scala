package ca.prosperpod.corelib.units.mutable

import java.text.SimpleDateFormat
import java.util.Date

class Event(val code: Int) extends Serializable {
  // A unique identifier code.
  override def toString: String = s"Event(code: $code)"
}

class TimeBasedEvent(code: Int) extends Event(code) {
  override def toString: String = s"TimeBasedEvent(code: $code)"
}

/**
  * Fires upon the market close for the day.
  */
case class MarketEndDayEvent(date: Date) extends TimeBasedEvent(1) {
  override def toString: String = s"MarketEndDayEvent(date: ${
    new SimpleDateFormat("yyyy-mm-dd").format(date)
  })"
}

/**
  * Fires upon the market close on the last day of the week.
  */
case class MarketEndWeekEvent(date: Date) extends TimeBasedEvent(2) {
  override def toString: String = s"MarketEndWeekEvent(date: ${
    new SimpleDateFormat("yyyy-mm-dd").format(date)
  })"
}

