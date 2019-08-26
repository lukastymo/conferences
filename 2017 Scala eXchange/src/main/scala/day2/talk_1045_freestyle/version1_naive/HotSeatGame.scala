package day2.talk_1045_freestyle.version1_naive

import day2.talk_1045_freestyle.PrisonersDilemma._

import scala.io.StdIn.readLine


/**
  * Hot Seat Logic -> Computing Verdict
  *                -> Player Interaction
  *                -> Player Communication using Console
  *
  * Player Communication using Console <-> Player Interaction
  */
object HotSeatGame extends App {

  def meetPrisoner(): Prisoner = {
    val name = readLine("Welcome to the Hot Seat Game! What's your name?")
    Prisoner(name)
  }

  def prisonersDecision(prisoner: Prisoner, otherPrisoner: Prisoner): Decision = {
    val answer = readLine(s"${prisoner.name}, is ${otherPrisoner.name} guilty?")
    answer match {
      case "y" => Guilty
      case "n" => Silence
    }
  }

  def giveVerdict(prisoner: Prisoner, verdict: Verdict): Unit = {
    println(s"Verdict for ${prisoner.name} is $verdict")
  }

  val prisonerA = meetPrisoner()
  val prisonerB = meetPrisoner()
  val decisionA = prisonersDecision(prisonerA, prisonerB)
  val decisionB = prisonersDecision(prisonerB, prisonerA)
  giveVerdict(prisonerA, verdict(decisionA, decisionB))
  giveVerdict(prisonerB, verdict(decisionB, decisionA))
}
