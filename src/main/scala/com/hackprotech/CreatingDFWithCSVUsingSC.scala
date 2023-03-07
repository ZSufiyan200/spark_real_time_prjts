package com.hackprotech

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object CreatingDFWithCSVUsingSC {

  def main(args: Array[String]): Unit ={
    val spark = SparkSession.builder()
      .appName("Creating a Dataframe using CSV")
      .master("local")
      .getOrCreate()

    val df = spark.read
//      .option("header","true")
//      .option("inferSchema","true")
      .options(Map("header" -> "true" , "inferSchema" -> "true"))
      .csv("C:\\Users\\10720444\\IdeaProjects\\spark_real_time_prjts\\input\\Used_Bikes.csv")

    df.printSchema()

    df.show()

  }

}
