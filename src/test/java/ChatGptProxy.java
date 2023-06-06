import com.alibaba.fastjson.JSON;

import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ChatGptProxy {
    public static void main(String[] args) {
        // 设置代理服务器的主机和端口
        String proxyHost = "127.0.0.1";
        int proxyPort = 7890;

        // 创建代理选择器对象
        ProxySelector proxySelector = ProxySelector.of(new InetSocketAddress(proxyHost, proxyPort));

        // 创建 HttpClient.Builder 对象，并设置代理选择器
        HttpClient.Builder builder = HttpClient.newBuilder().proxy(proxySelector);

        // 构建 HttpClient 对象
        HttpClient httpClient = builder.build();

        // GPT-3.5 Chat API的URL
        String apiUrl = "https://api.openai.com/v1/chat/completions";

        // 请求头中的认证信息
        String apiKey = "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";

        // 构建模型参数
        String modelParams = "\"model\": \"gpt-3.5-turbo\", \"temperature\": 2.0, \"max_tokens\": 2000, \"stream\": true";

        //从终端获取请求内容
        String content = new Scanner(System.in).next();

        // 构建请求体
        String requestBody = " \"messages\": [{\"role\": \"user\", \"content\": \"" + content + "\"}],";

        // 创建请求对象
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl)) // 设置请求的 URI
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString("{" + requestBody + modelParams + "}")) // 设置请求的内容
                .build();
        System.out.println("{" + requestBody + modelParams + "}");
        try {
            // 发送请求并获取响应
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

//            //获取content，用json解析
//            String output = JSON.parseObject(response.body()).getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content");
//
//            // 获取响应输入流
//            InputStream inputStream = new ByteArrayInputStream(output.getBytes(StandardCharsets.UTF_8));
//
//            // 获取响应输出流
//            OutputStream outputStream = System.out;
//
//            // 定义缓冲区大小
//            byte[] buffer = new byte[4096];
//            int bytesRead;
//
//            // 逐块将输入流的内容写入输出流
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//
//            // 刷新输出流
//            outputStream.flush();

            // 处理响应
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

            //获取content，用json解析
            System.out.println("回答：" + JSON.parseObject(response.body()).getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
