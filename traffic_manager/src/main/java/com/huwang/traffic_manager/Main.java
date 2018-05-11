package com.huwang.traffic_manager;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class Main {

    public static void main(String args[])
    {
        /*RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("119.23.34.80", 9200, "http")));
    */
      new ElasticsearchService().insertData();
    }
}
