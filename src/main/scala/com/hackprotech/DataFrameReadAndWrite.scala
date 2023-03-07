package com.hackprotech

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col



object DataFrameReadAndWrite {

  Logger.getLogger( "org").setLevel(Level.ERROR)

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("DataFrameReadAndWrite")
    sparkConf.setMaster("local")

    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    // Read CSV
    val sourceBikeDF = sparkSession.read.option("header" , true).csv("C:\\Users\\10720444\\IdeaProjects\\spark_real_time_prjts\\input\\Used_Bikes.csv")

    // Manipulate DF

    val extractedDF = sourceBikeDF.select(col = "bike_name", cols = "brand","owner").where(col(colName = "owner") === "First Owner")

    println(sourceBikeDF.count())
    println(extractedDF.count())

    extractedDF.write.format("csv").mode("overwrite").save("C:\\Users\\10720444\\IdeaProjects\\spark_real_time_prjts\\target\\output")

//    val jdbcDF = sparkSession.read
//      .format(source = "jdbc")
//      .option("url" , "jdbc:postgresql://192.168.1.8:5432/postgres")
//      .option("dbtable" ,"\"employee\"")
//      .option("user" ,"postgres")
//      .option("password" ,"Su@329224")
//      .load()

    sparkSession.stop()
  }

}
