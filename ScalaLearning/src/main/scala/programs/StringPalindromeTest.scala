package programs

object StringPalindromeTest extends App {
  val givenString = readLine()

  var reversedString = ""

  for (i <- (0 to givenString.length - 1).reverse) {
    reversedString = reversedString + givenString.charAt(i)
  }

  println("The reversed string is " + reversedString)
  if (reversedString == givenString) {
    println("Its a palindrome")

  }
  else {
    println("Its not a palindrome")

  }
}
