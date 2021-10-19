package programs

object Test extends App {

  val name: String = " YUVI "
  val x: Array[String] = name.split(" ")

  val y = name.sorted
  //println(y)

  val arr = Array(1, 2, 3, 4, 5)
  val sum = arr.reduce(_ + _)
  println(sum)

  val i = name.trim

  /* println(i)
   println(name.length)
   println(i.length )*/

  val n = 5

  for (i <- 0 to n) {
    for (j <- 0 to i) {

      print("*")

    }
    println("")

  }



}


