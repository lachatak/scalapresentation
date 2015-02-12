package gamesys.presentation

object Darse extends App {

  val NEW_VALUE_WEIGHT = 0.4
  val A_DAY = 24 * 60 * 60 * 1000
  type PlayerId = Long

  //----------------- DATA structure we save in DB
  case class Count(val playerId: PlayerId,
                        val value: Double, // between 0 and 1
                        val timestamp: Long) //last updated timestamp




  //--------------- THE API ------------------------------------------------------------------

  //this is called when HandHistoryEvent arrives
  def processHandHistory(playerId:PlayerId) {
    val regularity = getFromDB(playerId)
    val updatedRegularity = updateCounterWhenHandIsPlayed(regularity, System.currentTimeMillis())
    saveToDB(updatedRegularity)
  }

  //this is called when we query the value to calculate Commmunity Score
  def queryValue(regularity: Count, currentTimestamp: Long) = {
    val daysPassedSinceLastCalculation = calculateDifferenceInDays(regularity.timestamp, currentTimestamp)
    calculateNewValue(regularity.value, daysPassedSinceLastCalculation, false)
  }
  //------------------------------------------------------------------------------------------





  //----------------- AUXILIARY METHODS --------------------------------------------------------------------
  def updateCounterWhenHandIsPlayed(regularity: Count, currentTimestamp: Long) = {

    //calculate the difference in days between regularity.timestamp and currentTimestamp
    val daysPassedSinceLastCalculation = calculateDifferenceInDays(regularity.timestamp, currentTimestamp)
    val newValue = calculateNewValue(regularity.value, daysPassedSinceLastCalculation, true)
    regularity.copy(value = newValue, timestamp = currentTimestamp)
  }

  // naive implementation, probably needs refinement
  def calculateDifferenceInDays(c1: Long, c2: Long):Int = (c2 - c1).toInt / (A_DAY)

  def getFromDB(playerId:PlayerId) = ???
  def saveToDB(regularity: Count) = ???
  // -----------------------------------------------------------------------------------------------------------------------





  //----------------- ALGORITHM TO CALCULATE VALUE -----------------------------------
  def calculateNewValue(oldValue: Double, daysPassedSinceLastCalculation: Int, playedToday: Boolean): Double = {

    //calculated already, ignore
    if (daysPassedSinceLastCalculation == 0) oldValue
    //played yesterday
    else if (daysPassedSinceLastCalculation == 1 && playedToday) calculateNextDaysValue(oldValue, 1)
    else {
      val nextDaysDecreasedValue = calculateNextDaysValue(oldValue, 0)
      calculateNewValue(nextDaysDecreasedValue, daysPassedSinceLastCalculation - 1, playedToday)
    }
  }
  //IMPORTANT: newValue is 0 if the player didn't play, 1 if she did
  def calculateNextDaysValue(oldValue: Double, newValue: Double) = NEW_VALUE_WEIGHT * newValue + (1 - NEW_VALUE_WEIGHT) * oldValue

  //-------------------------------------------------------------------------------------





  //----------------- TEST IT --------------------------------------------------------------------
  def assertDoubleEquals(d1:Double, d2:Double) =  assert ( Math.abs(d1-d2) < 0.0001 )

  // on Day 0 the value is initialized as 0.0

  // player played on Day 1: 0.4 * 1 + 0.6 * 0.0 = 0.4
  assertDoubleEquals(0.4, calculateNewValue(oldValue = 0.0,daysPassedSinceLastCalculation = 1, playedToday = true))

  // player played on Day 2: 0.4 * 1 + 0.6 * 0.4 = 0.64
  assertDoubleEquals(0.64, calculateNewValue(oldValue = 0.4,daysPassedSinceLastCalculation = 1, playedToday = true))

  // player didn't play on Day 3, but played on Day 4
  // Day 3: 0.4 * 0 + 0.6 * 0.64 = 0.384
  // Day 4: 0.4 * 1 + 0.6 * 0.384 = 0.6304
  assertDoubleEquals(0.6304, calculateNewValue(oldValue = 0.64,daysPassedSinceLastCalculation = 2, playedToday = true))


}
