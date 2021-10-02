package programs

object Fibonacci  extends App{

  var n1 =0
  var n2 = 1

  println(n1)
  println(n2)
  val count = 10
  for (i <- 0  to count ){

    var n3 = n1 + n2
    println(n3)
    n1= n2
    n2=n3

  }

}
