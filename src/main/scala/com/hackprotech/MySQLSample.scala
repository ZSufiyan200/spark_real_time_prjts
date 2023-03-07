package com.hackprotech

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

import java.util.Properties

object MySQLSample {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("MySQL Job")
      .master("local")
      .getOrCreate()

    val url = "jdbc:mysql://192.168.1.8:3306"
    val table = "world.city"
    val properties = new Properties()
    properties.put("user", "root")
    properties.put("password", "Su@329224")

    Class.forName("com.mysql.cj.jdbc.Driver")
    val mysqlDF = spark.read.jdbc(url, table, properties)

    mysqlDF.createOrReplaceTempView("city")
    val sz = spark.sql("select * from city limit 5")
    sz.show()
  }
}

