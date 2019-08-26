import eu.timepit.refined.api.Refined
import eu.timepit.refined.collection.NonEmpty
import eu.timepit.refined.auto._

//repl.compiler.settings.YliteralTypes.value = true

val x = "foo"
x.isInstanceOf[String]

x.isInstanceOf[AnyRef]

//x.isInstanceOf["foo"]

type Name = Refined[String, NonEmpty]
val name1: Name = "Lukas"
//val name2: Name = ""