package com.Utilities;

import com.main.DataObjects;
import com.main.StepDefinition;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

public class APIBase {

    public boolean testAPI(String URI, String HTTPMethod, String testname) throws IOException {

        DataObjects dObj= new DataObjects();
        Boolean flag = false;
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response;
        HttpEntity entity;
        String responseString;

        switch (HTTPMethod){
            case "GET":
                response = client.execute(new HttpGet(URI));
                entity = response.getEntity();
                responseString = EntityUtils.toString(entity, "UTF-8");
                dObj.setResponse(responseString);
                dObj.setStatusCode(response.getStatusLine().getStatusCode());
                StepDefinition.logger.info("The response is: "+ responseString);
                client.close();
                Files.write(Paths.get("StoredReports/"+testname+"_Set2"+".json"),responseString.getBytes());
                flag = true;
                break;
            case "POST":
                HttpPost httpPost = new HttpPost(URI);
                StringEntity sEntity = new StringEntity(dObj.getRequestPayload());
                httpPost.setEntity(sEntity);
                httpPost.setHeader("Accept", "application/json");
                httpPost.setHeader("Content-type", "application/json");
                response = client.execute(httpPost);
                entity = response.getEntity();
                responseString = EntityUtils.toString(entity, "UTF-8");
                dObj.setResponse(responseString);
                dObj.setStatusCode(response.getStatusLine().getStatusCode());
                client.close();
                Files.write(Paths.get("StoredReports/"+testname+"_Set2"+".json"),responseString.getBytes());
                flag = true;
                break;
            default:
                StepDefinition.logger.info("Incorrect HTTP Method");
                break;
        }
        return flag;
    }
}
