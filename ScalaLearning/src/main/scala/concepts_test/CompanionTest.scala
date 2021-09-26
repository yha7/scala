package concepts_test

object CompanionTestBootstrap extends App {

  val companionTestObj = CompanionTest("Tester")
  companionTestObj.printName()
}

class CompanionTest {
  var name = ""

  def printName(): Unit = {
    println("My name is " + name)
  }
}

object CompanionTest {

  def apply(a: String) = {

    val p = new CompanionTest()
    p.name = a
    p
  }
}

/*
You type something like val p = Person("Fred")
The Scala compiler sees that there is no new keyword before Person

The compiler looks for an apply method in the companion object of the Person class that matches the type signature you entered
If it finds an apply method, it uses it; if it doesn’t, you get a compiler error

apply method in class itself will not help here.Compiler will not consider it.

 To access private member/ member of a class, we need to create an object of a class in companion object. */
