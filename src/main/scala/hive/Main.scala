package hive

import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.fs.Path
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.Text

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

import org.apache.hive.jdbc.HiveConnection
import hive.scala.jdbcConHive

object Main extends App {
  val entry = 9
  println("Program Start")
  jdbcConHive.searchMostTrendingVids(entry)
  jdbcConHive.searchMostViewsByCreator(entry)
  jdbcConHive.allCountriesViews()
  jdbcConHive.allCountriesVideos()
  jdbcConHive.closeConnection()
  println("Program End")

//   val obstacles = Array(Array(1,2),Array(2,3))
//   var k = 0
//   val h = 1
//   val j = 2
//   for(k <- 0 until obstacles.size){
//     if(obstacles(k)(0) == h){
//       if(obstacles(k)(1) == j){
//         println(obstacles(k)(0) + " " + obstacles(k)(1) + " == " + h + " " + j)
//         println("at obstacle")
//       }else{
//         println(obstacles(k)(1) + " " + j)
//         println("not at")
//       }
//     }else{
//       println(obstacles(k)(0) + " " + h)
//       println("not at")
//     }
//   }
//   println(obstacles.size)

}