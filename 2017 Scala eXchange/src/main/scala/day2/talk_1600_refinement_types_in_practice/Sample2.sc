
type Name = String
type TwitterHandle = String

final case class Developer(name: Name, twitterHandle: TwitterHandle)

val name: Name = "Lukasz"
val handle: TwitterHandle = "@lukastymo"

Developer(name, handle)
Developer(handle, name)

