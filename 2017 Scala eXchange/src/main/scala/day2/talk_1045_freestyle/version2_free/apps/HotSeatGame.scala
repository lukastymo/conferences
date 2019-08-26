package day2.talk_1045_freestyle.version2_free.apps

import day2.talk_1045_freestyle.version2_free.algebras.PlayerOps.Player
import day2.talk_1045_freestyle.version2_free.interpreters.PlayerConsoleInterpreter
import day2.talk_1045_freestyle.version2_free.programs.HotSeat

object HotSeatGame extends App {

  HotSeat.program(new Player.Ops[Player])
    .foldMap(PlayerConsoleInterpreter)
    .unsafeRunSync()
}
