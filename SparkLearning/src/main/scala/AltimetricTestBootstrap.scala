import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.types.{IntegerType, StringType}

object AltimetricTestBootstrap extends App{

  val spark = SparkSession.builder().master("local[2]").appName("app-PalindromeTester").getOrCreate()
  val rawRdd = spark.sparkContext.parallelize(Seq(("banana"),("oppoisoppo")))

  // rawRdd.foreach(println(_))

  val rddWithLargestPalindromesInEachString = rawRdd.map(palindromeTest(_))
  println("FinalRESULT::::::::::::::::::::::::::")
  rddWithLargestPalindromesInEachString.foreach(println(_))
  val largestPalindromeArray: Array[(String, Int)] = rddWithLargestPalindromesInEachString.collect()
  val sortedlargestPalindromeArray = largestPalindromeArray.sortBy(x => x._2)
  val largestSubsetPalindrome = sortedlargestPalindromeArray(sortedlargestPalindromeArray.length-1)
  println("largestSubsetPalindrome is "+largestSubsetPalindrome)

  def palindromeTest(s:String) = {

    var list = scala.collection.mutable.MutableList[String]()
    var listOfPalindromes = scala.collection.mutable.MutableList[String]()

    val givenString = s

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
          //println(s"The string ${reversedString} is a palindrome")
          listOfPalindromes = listOfPalindromes.:+(myString)
        }

      }

    })

    //println("LISTOFPALINDROME:::::::")
    //listOfPalindromes.foreach(println(_))

    val listOfTuples = listOfPalindromes.map(x => (x,x.length))

    val sortedList = listOfTuples.sortBy(x => x._2)
    // sortedList.foreach(println(_))
    sortedList(sortedList.length-1)

    // println("The largest palindrome in a given string is " +sortedList(sortedList.length-1))

  }
}