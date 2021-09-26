package concepts_test

object ExceptionHandlingTestBootstrap extends App{

  val exceptionHandlingTestObj = new ExceptionHandlingTest()
  val result = exceptionHandlingTestObj.test(0,20)
  println(result)

}

class ExceptionHandlingTest {

  def test(a: Int, b:Int) ={
    try {
      throw  new IndexOutOfBoundsException("I am throwing this exception manually to test throw method")
      b/a
    }
    catch {
      case a: Exception => println("Encountered an Exception " +a)
      case q: IndexOutOfBoundsException => println("Encountered an IndexOutOfBoundsException " +q)
      case e:ArithmeticException=>println("Encountered an Arithmetic exception " +e)
    }
    finally {
      println("Exception caught in Catch block")
    }

  }

}

// Rule in Java : In catch block,the exception information should be from more specific to more general. It is not applied on scala.
// If there are multiple exceptions in a piece of code present in TRY block, the first exception is caught and handled in CATCH block and the rest of the exceptions are ignored.