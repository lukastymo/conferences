

final case class Name private(v: String) extends AnyVal

object Name {
  def fromString(s: String): Option[Name] =
    if (s.nonEmpty) Some(Name(s)) else None
}

final case class TwitterHandle private(v: String) extends AnyVal

object TwitterHandle {

  def fromString(s: String): Option[TwitterHandle] =
    if (s.startsWith("@")) Some(TwitterHandle(s)) else None
}

final case class Developer(name: Name, twitterHandle: TwitterHandle)

Developer(
  name          = Name.fromString("Lukasz").get,
  twitterHandle = TwitterHandle.fromString("@lukastymo").get
)


