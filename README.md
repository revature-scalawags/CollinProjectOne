# CollinProjectOne
## Project Description
This project is designed to take in a youtube dataset on trending videos in 2017 and run 
analysis on it for overall views of trending videos by creator and number of videos that 
entered trending by creator. Additionally this analysis was run by country and globally to
view any potential changes that would occur on different geographic stages.
## Technologies Used
* Hive - version 3.2.1
* Scala - version 2.13.4
* Hadoop - version 2.3.2
## Features
List of features:
* Query months of data based on view count and amount of times trending.
* Dynamically change query from main method.
* Display results in an easy to digest format.

To-do list:
* Pull in data directly from youtube to potentially gather more than 2017 data.
* Implement my own map and reduce method on the data before sending to hive.
* Using CLI get user input on changes made to query.
## Getting Started
* cd docker-hive
* docker-compose up -d
* docker exec -it docker-hive_namenode_1 bash
* mkdir input
* cd documents/project1
* docker cp input/CAvideos.csv docker-hive_namenode_1:input/CAvideos.csv
* docker cp input/DEvideos.csv docker-hive_namenode_1:input/DEvideos.csv
* docker cp input/FRvideos.csv docker-hive_namenode_1:input/FRvideos.csv
* docker cp input/GBvideos.csv docker-hive_namenode_1:input/GBvideos.csv
* docker cp input/INvideos.csv docker-hive_namenode_1:input/INvideos.csv
* docker cp input/JPvideos.csv docker-hive_namenode_1:input/JPvideos.csv
* docker cp input/KRvideos.csv docker-hive_namenode_1:input/KRvideos.csv
* docker cp input/MXvideos.csv docker-hive_namenode_1:input/MXvideos.csv
* docker cp input/RUvideos.csv docker-hive_namenode_1:input/RUvideos.csv
* docker cp input/USvideos.csv docker-hive_namenode_1:input/USvideos.csv
* docker exec docker-hive_namenode_1 bash -c "hadoop fs -mkdir -p input"
* cd docker-hive
* docker exec -it docker-hive_namenode_1 bash
* hadoop fs -put input/CAvideos.csv input/
* hadoop fs -put input/DEvideos.csv input/
* hadoop fs -put input/FRvideos.csv input/
* hadoop fs -put input/GBvideos.csv input/
* hadoop fs -put input/INvideos.csv input/
* hadoop fs -put input/JPvideos.csv input/
* hadoop fs -put input/KRvideos.csv input/
* hadoop fs -put input/MXvideos.csv input/
* hadoop fs -put input/RUvideos.csv input/
* hadoop fs -put input/USvideos.csv input/
* exit
* docker exec -it docker-hive_hive-server_1 bash
* hive
* create database youtubeData;

* use youtubeData;
* create table CAvideos (video_id STRING, trending_date STRING, title STRING, channel_title STRING, category_id INT, publish_time STRING, tags STRING, views INT, likes INT, dislikes INT 
* comment_count INT, thumbnail_link STRING, comments_disabled BOOLEAN, ratings_disabled BOOLEAN, video_error_or_removed BOOLEAN, description STRING)
* row format delimited fields terminated by ','
* tblproperties("skip.header.line.count"="1");
* create table DEvideos (video_id STRING, trending_date STRING, title STRING, channel_title STRING, category_id INT, publish_time STRING, tags STRING, views INT, likes INT, dislikes INT, 
* comment_count INT, thumbnail_link STRING, comments_disabled BOOLEAN, ratings_disabled BOOLEAN, video_error_or_removed BOOLEAN, description STRING)
* row format delimited fields terminated by ','
* tblproperties("skip.header.line.count"="1");
* create table FRvideos (video_id STRING, trending_date STRING, title STRING, channel_title STRING, category_id INT, publish_time STRING, tags STRING, views INT, likes INT, dislikes INT, 
* comment_count INT, thumbnail_link STRING, comments_disabled BOOLEAN, ratings_disabled BOOLEAN, video_error_or_removed BOOLEAN, description STRING)
* row format delimited fields terminated by ','
* tblproperties("skip.header.line.count"="1");
* create table GBvideos (video_id STRING, trending_date STRING, title STRING, channel_title STRING, category_id INT, publish_time STRING, tags STRING, views INT, likes INT, dislikes INT, 
* comment_count INT, thumbnail_link STRING, comments_disabled BOOLEAN, ratings_disabled BOOLEAN, video_error_or_removed BOOLEAN, description STRING)
* row format delimited fields terminated by ','
* tblproperties("skip.header.line.count"="1");
* create table INvideos (video_id STRING, trending_date STRING, title STRING, channel_title STRING, category_id INT, publish_time STRING, tags STRING, views INT, likes INT, dislikes INT, 
* comment_count INT, thumbnail_link STRING, comments_disabled BOOLEAN, ratings_disabled BOOLEAN, video_error_or_removed BOOLEAN, description STRING)
* row format delimited fields terminated by ','
* tblproperties("skip.header.line.count"="1");
* create table JPvideos (video_id STRING, trending_date STRING, title STRING, channel_title STRING, category_id INT, publish_time STRING, tags STRING, views INT, likes INT, dislikes INT, 
* comment_count INT, thumbnail_link STRING, comments_disabled BOOLEAN, ratings_disabled BOOLEAN, video_error_or_removed BOOLEAN, description STRING)
* row format delimited fields terminated by ','
* tblproperties("skip.header.line.count"="1");
* create table KRvideos (video_id STRING, trending_date STRING, title STRING, channel_title STRING, category_id INT, publish_time STRING, tags STRING, views INT, likes INT, dislikes INT, 
* comment_count INT, thumbnail_link STRING, comments_disabled BOOLEAN, ratings_disabled BOOLEAN, video_error_or_removed BOOLEAN, description STRING)
* row format delimited fields terminated by ','
* tblproperties("skip.header.line.count"="1");
* create table MXvideos (video_id STRING, trending_date STRING, title STRING, channel_title STRING, category_id INT, publish_time STRING, tags STRING, views INT, likes INT, dislikes INT, 
* comment_count INT, thumbnail_link STRING, comments_disabled BOOLEAN, ratings_disabled BOOLEAN, video_error_or_removed BOOLEAN, description STRING)
* row format delimited fields terminated by ','
* tblproperties("skip.header.line.count"="1");
* create table RUvideos (video_id STRING, trending_date STRING, title STRING, channel_title STRING, category_id INT, publish_time STRING, tags STRING, views INT, likes INT, dislikes INT, 
* comment_count INT, thumbnail_link STRING, comments_disabled BOOLEAN, ratings_disabled BOOLEAN, video_error_or_removed BOOLEAN, description STRING)
* row format delimited fields terminated by ','
* tblproperties("skip.header.line.count"="1");
* create table USvideos (video_id STRING, trending_date STRING, title STRING, channel_title STRING, category_id INT, publish_time STRING, tags STRING, views INT, likes INT, dislikes INT, 
* comment_count INT, thumbnail_link STRING, comments_disabled BOOLEAN, ratings_disabled BOOLEAN, video_error_or_removed BOOLEAN, description STRING)
* row format delimited fields terminated by ','
* tblproperties("skip.header.line.count"="1");
* load data inpath 'input/CAvideos.csv' into table cavideos;
* load data inpath 'input/DEvideos.csv' into table devideos;
* load data inpath 'input/FRvideos.csv' into table frvideos;
* load data inpath 'input/GBvideos.csv' into table gbvideos;
* load data inpath 'input/INvideos.csv' into table invideos;
* load data inpath 'input/JPvideos.csv' into table jpvideos;
* load data inpath 'input/KRvideos.csv' into table krvideos;
* load data inpath 'input/MXvideos.csv' into table mxvideos;
* load data inpath 'input/RUvideos.csv' into table ruvideos;
* load data inpath 'input/USvideos.csv' into table usvideos;
## Usage
> sbt run
