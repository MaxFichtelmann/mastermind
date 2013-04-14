package de.fichtelmax.mastermind

import scala.collection.JavaConversions._
import scala.beans.BeanProperty

class ScalaGuessResult(@BeanProperty var directHits: Int, @BeanProperty var colorHits: Int)

class ScalaMastermind[T](javaSolution: java.util.List[T]) {
	val solution = javaSolution.toList

	def guess(javaGuess: java.util.List[T]) = guess1(javaGuess.toList)

	def guess1(guess: List[T]) = {
		require(guess.length == solution.length, "guess must be of same size as solution")

		val pairs = guess zip solution
		val (dhPairs, restPairs) = pairs.partition { case (g, s) => g == s }
		val directHits = dhPairs.length
		val (restGuess, restSolution) = restPairs.unzip

		def helper(ch: Int, guess: List[T], solution: List[T]): ScalaGuessResult = {
			if (guess.isEmpty) {
				new ScalaGuessResult(directHits, ch)
			} else {
				val g = guess.head
				if (solution contains g) {
					helper(ch + 1, guess.tail, solution diff List(g))
				} else {
					helper(ch, guess.tail, solution)
				}
			}
		}

		helper(0, restGuess, restSolution)
	}
}
