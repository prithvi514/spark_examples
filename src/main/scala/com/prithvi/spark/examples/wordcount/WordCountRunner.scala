package com.prithvi.spark.examples.wordcount

import org.apache.spark.{SparkConf, SparkContext, Logging}

/**
  * Created by prithvi514 on 11/28/15.
  */
object WordCountRunner{

  /*Note that applications should define a main() method instead of extending scala.App. Subclasses of scala.App may not work correctly*/

  def main (args: Array[String]) {

    if (args.length < 1) System.err.println("Program needs an Input file");System.exit(1)

    val Array(inputPath) = args
    val conf  = new SparkConf().setAppName("WordCount")
    val sc  = new SparkContext(conf)
    val data = sc.textFile(inputPath)

    val counts = WordCount.count(data)

    //log.info(counts.collect().mkString(","))

    System.out.println(counts.collect().mkString(","))
  }

}
