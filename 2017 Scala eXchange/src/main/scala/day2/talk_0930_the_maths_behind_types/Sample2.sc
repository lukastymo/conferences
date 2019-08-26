//type Bool = Either[Unit, Unit]
sealed trait Bool
case class False() extends Bool
case class True() extends Bool

//type Nat = Either[Unit, Either[Unit, Either[...]]]
sealed trait Nat
case class One() extends Nat
case class Two() extends Nat
case class Three() extends Nat

trait Functor[F[_]] {
  def fmap[A, B](f: A => B)(v: F[A]): F[B]
}

/*
    A ---> F[A]
    |       |
    f      F[f]
    |       }
    B ---> F[B]
 */

implicit object ListFunctor extends Functor[List] {
  def fmap[A, B](f: A => B)(v: List[A]): List[B] = v match {
    case head :: tail => f(head) :: fmap(f)(tail)
    case Nil => Nil
  }
}