package hive
package scala
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

import org.apache.hive.jdbc.HiveConnection

object jdbcConHive {
    var con = DriverManager.getConnection("jdbc:hive2://localhost:10000/default","","")
    var stmt = con.createStatement()
    val tableName = "youtubeData.usvideos"
    var result: Statement = null
    var creator = ""
    var table = ""
    def searchMostTrendingVids(choice: Int){
        try{
            val start = System.currentTimeMillis()
            choice match{
                case 0 => {creator = "Canada"
                            table = "youtubeData.cavideos"}
                case 1 => {creator = "Germany"
                            table = "youtubeData.devideos"}
                case 2 => {creator = "France"
                            table = "youtubeData.frvideos"}
                case 3 => {creator = "Britain"
                            table = "youtubeData.gbvideos"}
                case 4 => {creator = "India"
                            table = "youtubeData.invideos"}
                case 5 => {creator = "Japan"
                            table = "youtubeData.jpvideos"}
                case 6 => {creator = "Korea"
                            table = "youtubeData.krvideos"}
                case 7 => {creator = "Mexico"
                            table = "youtubeData.mxvideos"}
                case 8 => {creator = "Russia"
                            table = "youtubeData.ruvideos"}
                case 9 => {creator = "USA"
                            table = "youtubeData.usvideos"}
            }
            var result = stmt.executeQuery(s"select channel_title,count(*) as cnt from $table where channel_title is not NULL group by channel_title sort by cnt DESC limit 10")
            println(f"""____________________________________________
                       ||                                           |
                       ||    Trending Creators in $creator%-8s Results  |
                       |____________________________________________""".stripMargin)
            while(result.next){
                val creator = result.getString("channel_title")
                val count = result.getString("cnt")
                println(f"|$creator%-40s$count|")
                println("____________________________________________")
            }
            val end = System.currentTimeMillis()
            val time = ((end - start)/1000)
            println("Query Time To Run(seconds): " + time)
        }catch{
            case e: SQLException => println(e)
        }
    }


    def searchMostViewsByCreator(choice: Int){
        try{
            val start = System.currentTimeMillis()
            choice match{
                case 0 => {creator = "Canada"
                            table = "youtubeData.cavideos"}
                case 1 => {creator = "Germany"
                            table = "youtubeData.devideos"}
                case 2 => {creator = "France"
                            table = "youtubeData.frvideos"}
                case 3 => {creator = "Britain"
                            table = "youtubeData.gbvideos"}
                case 4 => {creator = "India"
                            table = "youtubeData.invideos"}
                case 5 => {creator = "Japan"
                            table = "youtubeData.jpvideos"}
                case 6 => {creator = "Korea"
                            table = "youtubeData.krvideos"}
                case 7 => {creator = "Mexico"
                            table = "youtubeData.mxvideos"}
                case 8 => {creator = "Russia"
                            table = "youtubeData.ruvideos"}
                case 9 => {creator = "USA"
                            table = "youtubeData.usvideos"}
            }
            var result = stmt.executeQuery(s"select T.channel_title,sum(T.views) as viewsTotal from(select DISTINCT video_id, channel_title, views from $table where channel_title is not NULL) as T group by channel_title sort by viewsTotal DESC limit 10")
            println(f"""
            
                        |____________________________________________
                       ||                                           |
                       ||    Trending Creators in $creator%-8s views    |
                       |____________________________________________""".stripMargin)
            while(result.next){
                val creator = result.getString("channel_title")
                val count = result.getString("viewsTotal")
                println(f"|$creator%-40s$count|")
                println("____________________________________________")
            }
            val end = System.currentTimeMillis()
            val time = ((end - start)/1000)
            println("Query Time To Run(seconds): " + time)
        }catch{
            case e: SQLException => println(e)
        }
    }

    def allCountriesVideos(){
        val start = System.currentTimeMillis()
        try{
            var result = stmt.executeQuery("""select T.channel_title, count(*) as cnt
                                                from (select channel_title from youtubeData.usvideos where channel_title is not NULL
                                                union all 
                                                select channel_title from youtubeData.cavideos where channel_title is not NULL
                                                union all 
                                                select channel_title from youtubeData.devideos where channel_title is not NULL
                                                union all 
                                                select channel_title from youtubeData.frvideos where channel_title is not NULL
                                                union all 
                                                select channel_title from youtubeData.gbvideos where channel_title is not NULL
                                                union all 
                                                select channel_title from youtubeData.invideos where channel_title is not NULL
                                                union all
                                                select channel_title from youtubeData.jpvideos where channel_title is not NULL
                                                union all
                                                select channel_title from youtubeData.krvideos where channel_title is not NULL
                                                union all
                                                select channel_title from youtubeData.mxvideos where channel_title is not NULL
                                                union all
                                                select channel_title from youtubeData.ruvideos where channel_title is not NULL) as T
                                                group by channel_title
                                                sort by cnt DESC
                                                limit 10""")
            println(f"""
                    |____________________________________________
                        ||                                           |
                        ||    Trending Creators in The World Videos  |
                        |____________________________________________""".stripMargin)
            while(result.next){
                val creator = result.getString("channel_title")
                val count = result.getString("cnt")
                println(f"|$creator%-40s$count|")
                println("____________________________________________")
            }
            val end = System.currentTimeMillis()
            val time = ((end - start)/1000)
            println("Query Time To Run(seconds): " + time)
        }catch{
            case e: SQLException => println(e)
        }
    }

    def allCountriesViews(){
        try{
            val start = System.currentTimeMillis()
            var result = stmt.executeQuery("""select T.channel_title, sum(T.views) as totalViews
                                                from (select channel_title, views from youtubeData.usvideos where channel_title is not NULL
                                                union  
                                                select channel_title, views from youtubeData.cavideos where channel_title is not NULL
                                                union   
                                                select channel_title, views from youtubeData.devideos where channel_title is not NULL
                                                union   
                                                select channel_title, views from youtubeData.frvideos where channel_title is not NULL
                                                union
                                                select channel_title, views from youtubeData.gbvideos where channel_title is not NULL
                                                union   
                                                select channel_title, views from youtubeData.invideos where channel_title is not NULL
                                                union  
                                                select channel_title, views from youtubeData.jpvideos where channel_title is not NULL
                                                union  
                                                select channel_title, views from youtubeData.krvideos where channel_title is not NULL
                                                union  
                                                select channel_title, views from youtubeData.mxvideos where channel_title is not NULL
                                                union  
                                                select channel_title, views from youtubeData.ruvideos where channel_title is not NULL) as T
                                                group by channel_title
                                                sort by totalViews DESC
                                                limit 10""")
            println(f"""
                    |____________________________________________
                        ||                                           |
                        ||    Trending Creators in The World views   |
                        |____________________________________________""".stripMargin)
            while(result.next){
                val creator = result.getString("channel_title")
                val count = result.getString("totalViews")
                println(f"|$creator%-40s$count|")
                println("____________________________________________")
            }
            val end = System.currentTimeMillis()
            val time = ((end - start)/1000)
            println("Query Time To Run(seconds): " + time)
        }catch{
            case e: SQLException => println(e)
        }
    }

    def closeConnection(){
        con.close()
        println("Connection Closed")
    }
}


