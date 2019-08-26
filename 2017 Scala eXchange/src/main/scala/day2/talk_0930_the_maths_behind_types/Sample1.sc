sealed trait Void

trait Elimination {
  def absurd[A]: Void => A
}

sealed trait Introduction {
  def unit[A]: A => Unit
}

trait Product[A, B, C] {
  def f: C => A
  def g: C => B

  def h(c: C) = (f(c), g(c))
}

