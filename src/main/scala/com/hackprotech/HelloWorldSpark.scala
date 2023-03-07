package com.hackprotech

import org.apache.spark.SparkContext

object HelloWorldSpark extends App{

  val sparkContext = new SparkContext(master = "local" , appName = "Hello World")
  val sourceRDD = sparkContext.textFile(path = "C:\\temp\\sample.txt")
  sourceRDD.take(num = 1).foreach(println)

}
