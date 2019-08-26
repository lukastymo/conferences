

final case class Name(v: String) extends AnyVal

final case class TwitterHandle(v: String) extends AnyVal

final case class Developer(name: Name, twitterHandle: TwitterHandle)

Developer(Name("Lukasz"), TwitterHandle("@lukastymo"))
//Developer(TwitterHandle("@lukastymo"), Name("Lukasz"))
Developer(Name("@lukastymo"), TwitterHandle("Lukasz"))

