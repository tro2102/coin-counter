package com.github.tro2102

object Coin {
  def penny: Coin = Coin("Penny", 1)
  def nickel: Coin = Coin("Nickel", 5)
  def dime: Coin = Coin("Dime", 10)
  def quarter: Coin = Coin("Quarter", 25)
}
case class Coin(name: String, value: Int)

case class IndividualCoinCount(coin: Coin, count: Int = 0) {
  def incrementCount: IndividualCoinCount = new IndividualCoinCount(coin, count+1)
}

object CoinCount {
  def initDefault: CoinCount = new CoinCount(Array(
    new IndividualCoinCount(Coin.penny),
    new IndividualCoinCount(Coin.nickel),
    new IndividualCoinCount(Coin.dime),
    new IndividualCoinCount(Coin.quarter)), 100)
}
class CoinCount(coins: Array[IndividualCoinCount], remainingValue: Int) {

  private val individualCounts = coins.sortBy(_.coin.value)

  def calculateCounts: Option[CoinCount] = {
    if ( remainingValue == 0 )
      return Option(this)
      
  }

  def largestCoinCountDenomination(value: Int): Option[IndividualCoinCount] = individualCounts.find(_.coin.value < value)
}

