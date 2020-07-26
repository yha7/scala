package com.foodDelivery

import com.util.libcommons.libcommon._
import java.time.LocalDateTime

import scala.util.Random
import java.time._
import java.time.format.DateTimeFormatter

import com.foodDelivery.FoodEventGenerator.status
import com.foodDelivery.FoodEventGenerator.status.Value
import com.google.gson.Gson

class FoodEventGenerator(numberOfOrders: Int, batchSize: Int, interval: Int, output_directory: String) {
  def process() = {

    for (i <- 1 to numberOfOrders) {

      val initialStatus = status.initialOrderStatus
      val finalStatus = if (i % 5 != 0) status.succeededOrderStatus else status.failedOrderStatus

      FoodEventGenerator.generateJsonEvents(initialStatus, finalStatus)
    }

  }

}

object FoodEventGenerator {
  //Enumerator (enumerator object has to be created. No enum keyword in scala)
  object status extends Enumeration {
    type status = Value
    val initialOrderStatus = Value("Order Placed")
    val succeededOrderStatus = Value("Order Delivered")
    val failedOrderStatus = Value("Order cancelled")

  }
  case class Order_info(orderID: Long, timestampUTC: String)
  case class OrderStatus(Type: status.Value, info: Order_info)

  def generateJsonEvents(initialStatus: status.Value, finalStatus: status.Value) = {
    val orderID = getRandomOrderId
    val timestampUTC = getTimeStampUTC

    val orderEvent = Order_info(orderID: Long, timestampUTC: String)
    val initial_orderEvent = OrderStatus(initialStatus, orderEvent: FoodEventGenerator.Order_info)
    val final_orderEvent = OrderStatus(finalStatus, orderEvent: FoodEventGenerator.Order_info)

    /*PRINTING EVENT OBJECTS*/
    println(initial_orderEvent)
    println(final_orderEvent)

    val initial_orderEventAsJsonString: String = toJsonString(initial_orderEvent)
    val final_orderEventAsJsonString: String = toJsonString(final_orderEvent)

    /*PRINTING JSON STRINGS
    println(initial_orderEventAsJsonString)
    println(final_orderEventAsJsonString)*/
  }

}
