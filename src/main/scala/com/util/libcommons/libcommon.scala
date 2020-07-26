package com.util.libcommons
import java.time.LocalDateTime
import java.time._
import java.time.format.DateTimeFormatter

import com.foodDelivery.FoodEventGenerator.OrderStatus
import com.google.gson.Gson

object libcommon {
 val gson =new Gson()
  def getRandomOrderId:Long={scala.util.Random.nextInt()}
  def getTimeStampUTC={LocalDateTime.now.format(DateTimeFormatter.ofPattern("YYYYMMdd_HHmmss"))}
  def ifDirectoryExists={}
  def createDirectory={}
  def toJsonString[A](x:A):String=
  {
    gson.toJson(x)
  }
}
