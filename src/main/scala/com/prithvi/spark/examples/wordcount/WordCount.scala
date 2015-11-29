package com.prithvi.spark.examples.wordcount

import org.apache.spark.rdd.RDD

/**
  * Created by prithvi514 on 11/28/15.
  */
class WordCount(var word:String, count:Int)

  object WordCount{

    def count(lines: RDD[String]):RDD[WordCount]=
    {
      //val words = lines.toString().split(".")
      val words = lines.flatMap(_.split("\\s+"))
      val wordCounts = words.map(word => (word, 1)).reduceByKey(_ + _).map{
        case(word: String, count: Int) => new WordCount(word, count)
      }
      wordCounts
    }

  }


