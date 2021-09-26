
import org.apache.spark.sql.SparkSession
import org.apache.spark._

object Bootstrap extends App {

  // Creating spark session

  // approach 1: Creating Spark session and Spark context
  // val spark = SparkSession.builder().appName("TestJob").master("local[2]").getOrCreate()
  // val sc: SparkContext = spark.sparkContext

  // approach 2: Creating Spark session and Spark context

  val sparkConf = new SparkConf().setAppName("TestJob1").setMaster("local[2]")
  val spark = SparkSession.builder().config(sparkConf).getOrCreate()
  val sc: SparkContext = spark.sparkContext

  // approach 3: Creating Spark context directly without Spark session

  /*val sparkConf = new SparkConf().setAppName("TestJob1").setMaster("local[2]")
  val sc: SparkContext = new SparkContext(sparkConf)*/

  // approach 4: Creating Spark session with hive enabled

  /*val sparkConf = new SparkConf().setAppName("TestJob1").setMaster("local[2]")
  val spark = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate()
  val sc: SparkContext = spark.sparkContext*/



  // If master is local mode,  We should always put local[n], not Local[n] which throws an error.

  import spark.implicits._

  val testDf = spark.sparkContext.parallelize(Seq((1, "MSD"), (3, "Yuvraj singh"), (5, "Steve Smith"))).toDF("Rank", "Player")

  testDf.show()

  spark.catalog.

}
