package com.huwang.traffic_manager;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ElasticsearchService {

    private ElascsearchUtil util=ElascsearchUtil.getInstance();

    public void insertData()
    {
        BulkRequest request = new BulkRequest();
        Random random=new Random();
        for(int i=0;i<1000;i++)
        {
            IndexRequest indexRequest = new IndexRequest("loadindex", "loadtype");
            Map<String, Object> jsonMap = new HashMap<>();
            if(i%3==0) {
                jsonMap.put("cartype", "car");
                jsonMap.put("loadName", "inter a");
            }
            else if(i%3==1) {
                jsonMap.put("cartype", "train");
                jsonMap.put("loadName", "miller a");
            }
            else {
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
}
