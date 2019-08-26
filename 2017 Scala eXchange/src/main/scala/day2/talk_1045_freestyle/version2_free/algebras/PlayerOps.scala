package day2.talk_1045_freestyle.version2_free.algebras

import day2.talk_1045_freestyle.PrisonersDilemma.{Decision, Prisoner, Verdict}
import cats.:<:
import cats.free.Free

object PlayerOps {
  sealed trait Player[A]
  final case class MeetPrisoner(introduction: String) extends Player[Prisoner]
  final case class GetPrisonerDecision(prisoner: Prisoner, otherPrisoner: Prisoner) extends Player[Decision]
  final case class GiveVerdict(prisoner: Prisoner, verdict: Verdict) extends Player[Unit]

  object Player {
    class Ops[S[_]](implicit s: Player :<: S) {
      def meetPrisoner(introduction: String): Free[S, Prisoner] =
        Free.inject(MeetPrisoner(introduction))

      def prisonerDecision(prisoner: Prisoner, otherPrisoner: Prisoner): Free[S, Decision] =
        Free.inject(GetPrisonerDecision(prisoner, otherPrisoner))

      def giveVerdict(prisoner: Prisoner, verdict: Verdict): Free[S, Unit] =
        Free.inject(GiveVerdict(prisoner, verdict))
    }
  }
}
