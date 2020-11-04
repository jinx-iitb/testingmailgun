package tetsing;

import okhttp3.*;

import java.io.IOException;

public class test1 {

    public static void main(String[] args) throws IOException {
        String key = "";
        String url = "https://api.mailgun.net/v3/" + "sandbox286a43229b2645c7ba17e5bd0bab86b2.mailgun.org" + "/messages";
                //https://api.mailgun.net/v3/sandbox286a43229b2645c7ba17e5bd0bab86b2.mailgun.org";
        String from = "yolo@iitb.ac.in";
        String[] emails = new String[]{"jumbadajinkya@gmail.com","203050032@iitb.ac.in"};
        String fullEmailString = String.join(",", emails);
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("from", from)
                .add("to", fullEmailString)
                .add("subject", "mailgun test 4")
                .add("text", "ignore this")
                .build();
        String credential = Credentials.basic("api", key);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", credential)
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());

    }


}
