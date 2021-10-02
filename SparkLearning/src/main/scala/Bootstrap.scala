
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types
import org.apache.spark._
import org.apache.spark.sql.types.{IntegerType, StringType}

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
  val testDf1 = spark.sparkContext.parallelize(Seq((1, "MSD"), (3, "Yuvraj singh"), (5, "Steve Smith"))).toDF

  // testDf.show()

  // Converting Dataframe to Dataset
  case class PlayersInfo(Rank: Int, Player: String)

  val ds = testDf.as[PlayersInfo]
  // ds.show()

  import org.apache.spark.sql.functions._

// https://docs.databricks.com/spark/latest/dataframes-datasets/complex-nested-data.html 
  val rawDf =  Seq (
    (0, """{"device_id": 0, "device_type": "sensor-ipad", "ip": "68.161.225.1", "cca3": "USA", "cn": "United States", "temp": 25, "signal": 23, "battery_level": 8, "c02_level": 917, "timestamp" :1475600496 }"""),
    (1, """{"device_id": 1, "device_type": "sensor-igauge", "ip": "213.161.254.1", "cca3": "NOR", "cn": "Norway", "temp": 30, "signal": 18, "battery_level": 6, "c02_level": 1413, "timestamp" :1475600498 }"""),
    (2, """{"device_id": 2, "device_type": "sensor-ipad", "ip": "88.36.5.1", "cca3": "ITA", "cn": "Italy", "temp": 18, "signal": 25, "battery_level": 5, "c02_level": 1372, "timestamp" :1475600500 }""")).toDF("id", "device")

  /*rawDf.printSchema()
  rawDf.show()*/


  val modifiedDf = rawDf.withColumn("test",get_json_object(col("device"),"$.device_type")).drop(col("device"))

  /*modifiedDf.printSchema()
  modifiedDf.show()*/


  val jsonDf = spark.read.json("src/main/resources/data/testData.json")
  jsonDf.printSchema()
  jsonDf.show()

  val testdf9 = jsonDf.select("skills.storage")
  testdf9.printSchema()
  testdf9.show()
}
