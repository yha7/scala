package concepts_test

object InstanceVariableTestBootstrap extends App {

  val instanceVariableTestObj = new InstanceVariableTest(1)
}

class InstanceVariableTest(var instanceVariable: Int) {
  println(instanceVariable)
}

// We can’t create a value in scala without initialization. Need to initialize even for instance variables.
// Instance variables is usually declared in argument list of class in scala so that value is passed when we are creating an object. ie var instanceVariable
