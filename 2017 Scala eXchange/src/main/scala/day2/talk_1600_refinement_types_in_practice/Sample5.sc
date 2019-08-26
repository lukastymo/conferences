import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.collection.NonEmpty
import eu.timepit.refined.string.StartsWith

type Name = Refined[String, NonEmpty]

type TwitterHandle = String Refined StartsWith[W.`"@"`.T]

final case class Developer(name: Name, twitterHandle: TwitterHandle)

Developer(
  name          = "Lukasz",
//  name          = "",
  twitterHandle = "@lukastymo"
)


