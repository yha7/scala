package programs

object CollectionsTestBootstrap extends App {

  val rawList1 = List(1, 2, 3, 4, 5)
  val rawList2 = List(6, 7, 8, 9, 10)

  val prependedList = rawList1.+:(99)
  // prependedList.foreach(println(_))
  // println(prependedList(0))

  val appendedList = rawList1.:+(77)
  // appendedList.foreach(println(_))
  // println(appendedList(5))

  val concatenatedList = rawList1.++(rawList2)
  // println(concatenatedList)
  // concatenatedList.foreach(println(_))


  // adds an element at the beginning of the list
  val testList = rawList1.::(44)
  // println(testList)

  // The below code results in 'List(List(6, 7, 8, 9, 10), 1, 2, 3, 4, 5)' since it adds an element at the beginning of the list
  val testList1 = rawList1.::(rawList2)
  // println(testList1)

  // The below method adds the elements of rawList2 at the beginning of the rawList1 to form a new List i.e testList2
  val testList2 = rawList1.:::(rawList2)
  // println(testList2)

  val testList3 = rawList1.++:(rawList2)
  // println(testList3)

  // appendAll method is not available in List api
  // val tesList4 = rawList1.:++(rawList2)

  val testList4 = rawList1.drop(2)
  // println(testList4)

  // Finds the first element of the iterable collection satisfying a predicate, if any.
  val testList5 = rawList1.find(x => {
    x % 2 == 0
  })
  // println(testList5)

  // Creating a nested list
  val nestedList = List(List(1, 1, 1, 1, 1), List(2, 2, 2, 2, 2), List(3, 3, 3, 3, 3))

  // The below code just flattens the list
  val testList6 = nestedList.flatten.toList
  val testList7 = nestedList.flatMap(x => x)

  // The below code flattens as well as performs an some transformation
  val testList8 = nestedList.flatMap(x => {
    x.map(y => y + 1)
  })

  // wrong... Here x is a List
  // val testList_wrong = nestedList.flatMap(x => {x+1})

  // println(testList6)
  // println(testList7)
  // println(testList8)

  // groupBy
  val rawList3 = List("P_spark", "P_Adf", "S_HDFS", "S_S3Buckets", "V_PowerBI", "V_DatabricksSQL")

  val resultMap: Map[Char, List[String]] = rawList3.groupBy(x => x.charAt(0))
  // println(resultMap)

  // TODO : Need to check on the below code... Its returning true for both List[string] and List[Int]
  val boolResult = rawList1.isInstanceOf[List[String]]
  //println(boolResult)

  // reduce method
  val resultOfReduceMethod = rawList1.reduce((x, y) => {
    x + y
  })
  //  println(resultOfReduceMethod)

  //slice

  // until excludes the last index given. slice(from,until)
  val testList9 = rawList1.slice(0, 3)
  // println(testList9)


  // zip
  val testList10 = rawList1.zip(rawList2)
  // println(testList10)

  // If List1 is having 5 elements and List2 is having 3 elements.zip method ignores/truncates the last two elements from bigger list ie we get a tuple of only three elements.
  val testList11 = rawList1.zip(List(1, 2, 3))
  // println(testList11)

  val testList12 = rawList1.zipWithIndex
  //println(testList12)

  // unzip creates a tuple of two Lists

  val testList13: (List[Int], List[Int]) = testList10.unzip
  // println(testList13)

  val rawMap1 = Map("Peter" -> 30, "Tim" -> 20, "Charlie" -> 50)
  val rawMap2 = Map("MBBANK" -> 30, "Daimler" -> 20, "MBLD" -> 50)

  val appendMap = rawMap1 + ("Michael" -> 45)
  val appendMap1 = rawMap1.+("Trupti" -> 35, "Michael" -> 45)
  // println(appendMap)
  // println(appendMap1)

  val concatMap = rawMap1 ++ rawMap2
  // println(concatMap)

  // removing elements from Map

  // Please note that only key should be given for the removal of the elements
  val testMap1 = rawMap1 - ("Charlie")
  // println(testMap1)

  // testing -- method .Please note that it wont subtract two Maps.

  val testMap2 = concatMap -- List("Peter", "Tim", "MBLD")
 // println(testMap2)


  // We cannot iterate a tuple using foreach method directly since iterator is not unified over tuple elements as it is not homogeneous.So, we use productIterator method (of Product trait extended by tuples) which returns us an Iterator[Any] which is having foreach method.
  val rawTuple = (10, "Sachin Tendulkar", 50000, "India", "MI")
  rawTuple.productIterator.foreach(println(_))

}


