package com.hackprotech

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StringType


object DFWithSS {
  def main(args: Array[String]): Unit ={
    val spark = SparkSession.builder()
      .appName("Creating a Dataframe using Spark Session")
      .master("local")
      .getOrCreate()

    val rdd = spark.sparkContext.parallelize(Array("1","2","3","4","5"))

    val schema = StructType(
      StructField("Integers as a String",StringType , true)::Nil)

    val rowRDD = rdd.map(element => Row(element))

    val df = spark.createDataFrame(rowRDD,schema)

    df.printSchema()

    df.show(3)

  }
}
