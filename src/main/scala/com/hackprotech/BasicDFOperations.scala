package com.hackprotech



import org.apache.spark.sql.{Row, SparkSession}

object BasicDFOperations {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Basic DF Operations")
      .master("local")
      .getOrCreate()

    val userDF = spark.read
      .options(Map("header" -> "true" , "inferSchema" -> "true"))
      .orc("C:\\Users\\10720444\\IdeaProjects\\spark_real_time_prjts\\input\\TestOrcFile.testDate1900.orc")

    userDF.printSchema()
    userDF.show(truncate = false)

  }
}
