package concepts_test

object TestReaderAndWriterBootstrap extends App{

  // When we define VAR field in Scala class. It defines two methods. Reader(getter) and writer(setter).
  // VAl field has only Reader but not writer
  // We no need to define them. We get it for free.
  // Using default writer provided by scala. testVar_= is a method name where arg 8 is passed.

  val testObj = new TestReaderAndWriter()
  val valueOfTestVarBeforeWrite =  testObj.testVar

  testObj.testVar_=(8)
  val valueOfTestVarAfterWrite =  testObj.testVar

  println(valueOfTestVarBeforeWrite)
  println(valueOfTestVarAfterWrite)
}

class TestReaderAndWriter() {
  var testVar = 0
}