/**
 * ClassName: ChatGpt
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 段亚龙
 * @Create 2023/6/6 22:50
 * @Version 1.0
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class ChatGpt {
    public static void main(String[] args) {
        // 创建HttpClient实例
        HttpClient httpClient = HttpClientBuilder.create().build();

        // 创建HttpPost请求对象
        HttpPost httpPost = new HttpPost("https://api.openai.com/v1/chat/completions");

        // 设置请求头
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer YOUR_API_KEY");
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        // 构建请求体
        String requestBody = "{\"messages\":[{\"role\":\"system\",\"content\":\"You are a helpful assistant.\"},{\"role\":\"user\",\"content\":\"Who won the world series in 2020?\"}]}";
        HttpEntity entity = new StringEntity(requestBody, "UTF-8");
        httpPost.setEntity(entity);

        try {
            // 发送请求并获取响应
            HttpResponse response = httpClient.execute(httpPost);

            // 获取响应状态码
            int statusCode = response.getStatusLine().getStatusCode();

            // 获取响应内容
            String responseBody = EntityUtils.toString(response.getEntity());

            // 处理响应数据
            System.out.println("Status code: " + statusCode);
            System.out.println("Response body: " + responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}