package concepts_test

object ImplictsBootstrap extends App {

  // use case 1: Implicit parameters
  implicit val defaultImplicitName = "YUVARAJ"
  // implicit val alice = "Alice"


  def greet(implicit name: String) = {
    println(s"Hello ${name}!!!")
  }

  greet("ABD")

  // uses implicit value
  greet

  // use case 2: Type conversions with implicit functions
  implicit def intToString(x: Int): String = {
    s"Implicit method is converting INT value ${x} to STRING VALUE"
  }

  val result = 42.toUpperCase()
  println("The result is " + result)

  def functionTakesString(str: String) = {
    println("The string value is " + str)
    str
  }
  // passing Int as an argument
  functionTakesString(100)

}
