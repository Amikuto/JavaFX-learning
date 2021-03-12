package sample.request;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Request {

    private final String url = "http://localhost:8080/clients";

    Request() {
    }

    public String requestGET() throws IOException {
        HttpURLConnection httpClient = (HttpURLConnection) new URL(this.url).openConnection();
        httpClient.setRequestMethod("GET");

        InputStream is = httpClient.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String jsonString = rd.readLine();

        return jsonString;
    }

    public void requestPOST() throws IOException {
        HttpURLConnection httpClient = (HttpURLConnection) new URL(this.url).openConnection();
        httpClient.setRequestMethod("POST");

        httpClient.setRequestProperty("Content-Type", "application/json; utf-8");
        httpClient.setRequestProperty("Accept", "application/json");
        httpClient.setDoOutput(true);
        String jsonInputString = "{'name': 'TestName, 'surname': 'TestSurname', 'postalCode': '123'}";

        try(OutputStream os = httpClient.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

//        try(BufferedReader br = new BufferedReader(
//                new InputStreamReader(httpClient.getInputStream(), "utf-8"))) {
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            System.out.println(response.toString());
//        }

//        List<Object> params = new ArrayList<Object>();


//        OutputStream os = httpClient.getOutputStream();
//        BufferedWriter writer = new BufferedWriter(
//                new OutputStreamWriter(os, "UTF-8"));
//        writer.write(getQuery(params));
//        writer.flush();
//        writer.close();
//        os.close();
//
//        conn.connect();
    }
}
