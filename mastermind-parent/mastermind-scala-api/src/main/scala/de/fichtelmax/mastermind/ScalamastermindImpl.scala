package de.fichtelmax.mastermind

import scala.collection.JavaConversions._

class ScalamastermindImpl[T](solution: List[T]) extends Mastermind[T] {

  override def guess(guess: java.util.List[T]): GuessResult = {
    scalaGuess(guess.toList)
  }

  override def guess(guess: T*): GuessResult = {
    scalaGuess(guess.toList)
  }

  def scalaGuess(guess: List[T]): GuessResult = ???
}