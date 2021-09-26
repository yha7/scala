package concepts_test

object GenericsBootstrap extends App {

  // Approach 1
  val intAdderObj = new IntAdder()
  val result1 = intAdderObj.addition(10, 20)
  println("The result is " + result1)

  val doubleAdderObj = new DoubleAdder()
  val result2 = doubleAdderObj.addition(10.0, 30.0)
  println("The result is " + result2)

  // Approach 2
  def randomElement[A](seqOfNames: Seq[A]): A = {
    val randomNum = util.Random.nextInt(seqOfNames.length)
    seqOfNames(randomNum)
  }

  val res: String = randomElement(Seq("Aleka", "Christina", "Tyler", "Molly"))
  println(res)


  // Error
  /*def testt[B](x: B, y: B) = {
    x + y
  }*/

  // No error
 /* def testt[B](x: B) = {
    x
  }*/

}

abstract class Test[T] {
  def addition(a: T, b: T): T
}

class IntAdder extends Test[Int] {
  override def addition(a: Int, b: Int): Int = {
    a + b
  }
}

class DoubleAdder extends Test[Double] {
  override def addition(a: Double, b: Double): Double = {
  a + b

  }

}

// In approach 1, Generics is applied at a class level. Precisely, It is applied for abstract class

/* def addition[T](a: T, b: T): T = {
   a + b
 }*/

// TODO Need to implement generics directly for a method
// https://www.geeksforgeeks.org/scala-upper-bound/

