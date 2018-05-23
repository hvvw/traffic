package com.huwang.traffic_manager;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String args[])
    {
      new ElasticsearchService().insertMonitorData();
    }
}
