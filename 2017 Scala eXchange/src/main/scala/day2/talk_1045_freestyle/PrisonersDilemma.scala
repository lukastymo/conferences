package day2.talk_1045_freestyle

object PrisonersDilemma {

  final case class Prisoner(name: String)

  sealed trait Decision
  case object Guilty extends Decision
  case object Silence extends Decision

  final case class Verdict(years: Int)

  final case class Strategy(f: Prisoner => Decision)

  def verdict(prisoner: Decision, otherPrisoner: Decision): Verdict = (prisoner, otherPrisoner) match {
    case (Silence, Silence) => Verdict(1)
    case (Guilty, Silence) => Verdict(0)
    case (Guilty, Guilty) | (Silence, Guilty) => Verdict(3)
  }

}
