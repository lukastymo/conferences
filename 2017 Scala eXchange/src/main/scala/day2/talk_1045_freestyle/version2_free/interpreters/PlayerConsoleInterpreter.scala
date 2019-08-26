package day2.talk_1045_freestyle.version2_free.interpreters

import cats.effect.IO
import cats.~>
import day2.talk_1045_freestyle.PrisonersDilemma.{Decision, Guilty, Prisoner, Silence}
import day2.talk_1045_freestyle.version2_free.algebras.PlayerOps.{GetPrisonerDecision, GiveVerdict, MeetPrisoner, Player}

object PlayerConsoleInterpreter extends (Player ~> IO) {

  def say(what: String): IO[Unit] = IO { println(what) }

  def hear(): IO[String] = IO { scala.io.StdIn.readLine() }

  def apply[A](player: Player[A]): IO[A] = {
    val result = player match {
      case MeetPrisoner(intro) =>
        for {
          _ <- say(intro)
          _ <- say("What's your name?")
          name <- hear()
          _ <- say(s"Hello, $name!")
        } yield Prisoner(name)

      case GetPrisonerDecision(p, o) =>
        for {
          _ <- say(s"${p.name}, is ${o.name} guilty? (y if guilty, n if silent)")
          answer <- hear()
          decision = toDecision(answer)
          _ <- say(s"Your decision: $decision")
        } yield decision

      case GiveVerdict(p, v) =>
        say(s"Verdict for ${p.name} is $v")
    }

    result.map(_.asInstanceOf[A])
  }

  def toDecision(a: String): Decision = {
    if (a == "y") Guilty else Silence
  }

}

