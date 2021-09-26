package programs

object Palindrome extends App {

  val givenNumber: Int = readInt()

  println("Given number" + givenNumber)
  var temp: Int = givenNumber
  var reversedNumber = 0
  var rem = 0

  while (temp != 0) {

    rem = temp % 10
    reversedNumber = reversedNumber * 10 + rem
    temp = temp / 10
    println("Reversed number is ss" + reversedNumber)
  }

  println("Reversed number is " + reversedNumber)

  if (reversedNumber == givenNumber) {
    println("Its a palindrome number")

  }
  else {
    println("Its not a palindrome number")

  }

  // Not working
  /*reversedNumber match {
    case givenNumber => { println("Its a palindrome")}
    case _ => {  println("Its not  a palindrome")}
  }*/

}
