package de.fichtelmax.mastermind

import scala.collection.JavaConversions._
import de.fichtelmax.mastermind.datadriven.DataDrivenTest
import de.fichtelmax.mastermind.datadriven.TestDataItem

class ScalaMastermindTest(val testData: TestDataItem) extends DataDrivenTest(testData) {

  def newMastermind(solution: java.util.List[String]): Mastermind[String] = {
    new ScalamastermindImpl(testData.getSolution.toList)
  }
}