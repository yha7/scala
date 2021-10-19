package programs

import scala.collection.mutable._
object AltimetricTest extends App {

  var list = scala.collection.mutable.MutableList[String]()
  var listOfPalindromes = scala.collection.mutable.MutableList[String]()

  val givenString = "OPPOISOPPO"

  var temp = 0
  val n = givenString.length - 1

  for (j <- 0 to n) {
    for (k <- j to n) {
      var definedSubstring = givenString.substring(j,k+1)
      list = list.:+(definedSubstring)
    }
  }

 // list.foreach(println(_))

  list.foreach(myString => {

    var reversedString = ""

    if(myString.length > 1)
      {

        for (i <- (0 to myString.length - 1).reverse) {
          reversedString = reversedString + myString(i)
        }

       // println("The reversed string is " + reversedString)

        if (myString == reversedString) {
          println(s"The string ${reversedString} is a palindrome")
          listOfPalindromes = listOfPalindromes.:+(myString)
        }

      }

  })

  println("LISTOFPALINDROME:::::::")
  listOfPalindromes.foreach(println(_))

  val listOfTuples = listOfPalindromes.map(x => (x,x.length))

  val sortedList = listOfTuples.sortBy(x => x._2)
  sortedList.foreach(println(_))

  println("The largest palindrome in a given string is " +sortedList(sortedList.length-1))


/*  for (i <- (0 to givenString.length - 1).reverse) {
    reversedString = reversedString + givenString(i)
  }

  println("The reversed string is " + reversedString)

  if (givenString == reversedString) println("Its a palindrome")*/

}
