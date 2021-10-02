package programs

object Armstrong extends App {

  val number = 153
  var temp = number
  var testNumber = 0

  while (temp > 0) {

    var a = temp % 10
    testNumber = testNumber + (a * a * a)
    temp = temp / 10

  }
  println(testNumber)

  if (number == testNumber) {
    println(s"The given number $number is an Armstrong number.")
  }

  else {
    println(s"The given number $number is not an Armstrong number.")

  }

}
