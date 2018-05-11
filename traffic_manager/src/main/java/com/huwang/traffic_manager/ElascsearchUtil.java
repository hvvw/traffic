package com.huwang.traffic_manager;

import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElascsearchUtil {

    private static Logger log=LoggerFactory.getLogger(ElascsearchUtil.class);

    private static ElascsearchUtil elascsearchUtil;
    private static String host="119.23.34.80";
    private static int port=9200;
    private static RestHighLevelClient client;
    private static RestClientBuilder builder;

    public static ElascsearchUtil getInstance()
    {
        if(elascsearchUtil==null)
        {
            elascsearchUtil=new ElascsearchUtil();
            elascsearchUtil.init();
            return elascsearchUtil;
        }else return elascsearchUtil;
    }

    private void init()
    {
        builder=RestClient.builder(new HttpHost(host, port, "http"));
        client = new RestHighLevelClient(builder);
    }

    public void bulkRequest(BulkRequest request)
    {
        ActionListener<BulkResponse> listener = new ActionListener<BulkResponse>() {
            @Override
            public void onFailure(Exception e) {
                log.error("数据发送失败");
            }
            @Override
            public void onResponse(BulkResponse bulkResponse) {
                for (BulkItemResponse bulkItemResponse : bulkResponse) {
                    if (bulkItemResponse.getOpType() == DocWriteRequest.OpType.INDEX) {
                        log.info("成功数据发送一条");
                    }
                }
            }
        };
        client.bulkAsync(request, listener);
    }

}
