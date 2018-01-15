package ca.prosperpod.corelib.units.mutable

abstract class EventHandler extends Serializable {
  def handle[T >: Event](event: T): Unit
}