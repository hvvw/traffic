package com.huwang.traffic_manager;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ElasticsearchService {

    private ElascsearchUtil util = ElascsearchUtil.getInstance();

    public void insertData() {
        BulkRequest request = new BulkRequest();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            IndexRequest indexRequest = new IndexRequest("loadindex", "loadtype");
            Map<String, Object> jsonMap = new HashMap<>();
            if (i % 3 == 0) {
                jsonMap.put("cartype", "car");
                jsonMap.put("loadName", "inter a");
            } else if (i % 3 == 1) {
                jsonMap.put("cartype", "train");
                jsonMap.put("loadName", "miller a");
            } else {
                jsonMap.put("cartype", "air");
                jsonMap.put("loadName", "oppper d");
            }
            jsonMap.put("timestamp", new Date());
            jsonMap.put("desc", "Elasticsearch");
            jsonMap.put("speed", random.nextInt());
            indexRequest.source(jsonMap);
            request.add(indexRequest);
        }
        util.bulkRequest(request);
    }

    public void insertLoadData() {
        BulkRequest request = new BulkRequest();
        Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            IndexRequest indexRequest = new IndexRequest("loadindex", "loadtype");
            Map<String, Object> jsonMap = new HashMap<>();
            Map<String, Object> point = new HashMap<>();
            if (i % 3 == 0) {
                jsonMap.put("cartype", "car");
                jsonMap.put("loadName", "inter a");
                point.put("lat", 28.68019);
                point.put("lon", 115.850539);
            } else if (i % 3 == 1) {
                jsonMap.put("cartype", "train");
                jsonMap.put("loadName", "miller a");
                point.put("lat", 28.18019);
                point.put("lon", 115.150539);
            } else {
                jsonMap.put("cartype", "air");
                jsonMap.put("loadName", "oppper d");
                point.put("lat", 28.48019);
                point.put("lon", 115.650539);
            }
            long times = System.currentTimeMillis() - random.nextInt(3600 * 1000 * 48);
            jsonMap.put("timestamp", new Date(times));
            jsonMap.put("desc", "路网运行状态");
            jsonMap.put("speed", random.nextInt(200));
            jsonMap.put("centerPoint", point);
            indexRequest.source(jsonMap);
            request.add(indexRequest);
        }
        util.bulkRequest(request);
    }

    public void insertMonitorData() {
        BulkRequest request = new BulkRequest();
        Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            IndexRequest indexRequest = new IndexRequest("monitorindex", "monitortype");
            Map<String, Object> jsonMap = new HashMap<>();
            if (i % 3 == 0) {
                jsonMap.put("loadName", "inter a");
                jsonMap.put("pointName", "nuu");
            } else if (i % 3 == 1) {
                jsonMap.put("loadName", "miller a");
                jsonMap.put("pointName", "uii");
            } else {
                jsonMap.put("loadName", "oppper d");
                jsonMap.put("pointName", "rtt");
            }
            long times = System.currentTimeMillis() - random.nextInt(3600 * 1000 * 48);
            jsonMap.put("occurrenceTime", new Date(times));
            jsonMap.put("interruptRate", random.nextInt(100));
            jsonMap.put("crowdingRate", random.nextInt(100));
            indexRequest.source(jsonMap);
            request.add(indexRequest);
        }
        util.bulkRequest(request);
    }

    public void insertEventData() {
        int i;
        double u,t,n;
        double[] r = {5.0};
        //初始化正态分布的均值和方差
        u = 2.0;
        t = 3.5;
        n = 12.0;
        BulkRequest request = new BulkRequest();
        Random random = new Random();
        for (int j = 0; j < 20000; j++) {
            IndexRequest indexRequest = new IndexRequest("eventindex", "eventtype");
            Map<String, Object> jsonMap = new HashMap<>();
            Map<String, Object> point = new HashMap<>();
            if (j % 5 == 0) {
                jsonMap.put("loadName", "inter a");
            } else if (j % 5 == 1) {
                jsonMap.put("loadName", "miller a");
            } else if (j % 5 == 2) {
                jsonMap.put("loadName", "catter c");
            } else if (j % 5 == 3) {
                jsonMap.put("loadName", "lopper p");
            } else {
                jsonMap.put("loadName", "killer d");
            }
            long times = System.currentTimeMillis() - random.nextInt(3600 * 1000 * 48);
            jsonMap.put("timestamp", new Date(times));
            jsonMap.put("desc", "路网突发事件");
            jsonMap.put("dead", random.nextInt(10));
            jsonMap.put("hurt", random.nextInt(20));
            point.put("lat", 28.48019+RandomNumber.randZT(u,t,r,n));
            point.put("lon", 115.650539+RandomNumber.randZT(u,t,r,n));
            jsonMap.put("centerPoint", point);
            indexRequest.source(jsonMap);
            request.add(indexRequest);
        }
        util.bulkRequest(request);
    }
}
