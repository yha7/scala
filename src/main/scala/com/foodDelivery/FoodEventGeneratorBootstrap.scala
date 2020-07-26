package com.foodDelivery
import com.google.gson.Gson
import java.time.LocalDateTime

import scala.util.Random
import java.io._
import java.time.format.DateTimeFormatter

object FoodEventGeneratorBootstrap {
  def main(args: Array[String]): Unit = {
    /*  val numberOfOrders: Int = args(1).toInt
    val batchSize: Int = args(2).toInt
    val interval: Double = args(3).toInt
    val output_directory: String = args(4)*/

    val numberOfOrders: Int = 5
    val batchSize: Int = 5
    val interval: Int = 1
    val output_directory: String =""

    val foodEventGenerator = new FoodEventGenerator(numberOfOrders: Int, batchSize: Int, interval: Int, output_directory: String)
    foodEventGenerator.process()
  }
}




