package day2.talk_1045_freestyle.version2_free.programs

import cats.free.Free
import day2.talk_1045_freestyle.PrisonersDilemma.verdict
import day2.talk_1045_freestyle.version2_free.algebras.PlayerOps.Player
import day2.talk_1045_freestyle.version2_free.algebras.PlayerOps.Player.Ops

object HotSeat {
  def program(implicit playerOps: Ops[Player]): Free[Player, Unit] = {
    import playerOps._

    for {
      prisonerA <- meetPrisoner("Welcome to the Hot Seat Game! What's your name?")
      prisonerB <- meetPrisoner("Welcome to the Hot Seat Game! What's your name?")
      decisionA <- prisonerDecision(prisonerA, prisonerB)
      decisionB <- prisonerDecision(prisonerB, prisonerA)
      _ <- giveVerdict(prisonerA, verdict(decisionA, decisionB))
      _ <- giveVerdict(prisonerB, verdict(decisionB, decisionA))
    } yield ()
  }
}
