import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost; //----
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity; //----
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient; //----
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair; //----
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair; //----

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;//----
import java.util.List;//---

public class API1 {
    public static void main(String[] args) throws IOException
    {

        String URL = "https://speller.yandex.net/services/spellservice";

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            String text = URLEncoder.encode("Дылаем+ошыбки+спецыально", StandardCharsets.UTF_8.name());
            HttpGet httpGet = new HttpGet(URL + "/checkText?text=" + text);
            try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {
                System.out.println(response1.getCode());
                System.out.println(EntityUtils.toString(response1.getEntity()));
                HttpEntity entity1 = response1.getEntity();
                EntityUtils.consume(entity1);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            String URL = "https://speller.yandex.net/services/spellservice/checkText";
            String text = URLEncoder.encode("Дылаем ошыбки спецыально", StandardCharsets.UTF_8.name());

            HttpPost httpPost = new HttpPost(URL);
            List<NameValuePair> nvps = new ArrayList<>();
            nvps.add(new BasicNameValuePair("text", text));

            httpPost.setEntity(new UrlEncodedFormEntity(nvps));

            try (CloseableHttpResponse response2 = httpclient.execute(httpPost)) {
                System.out.println(EntityUtils.toString(response2.getEntity()));
                HttpEntity entity2 = response2.getEntity();
                EntityUtils.consume(entity2);

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        }

    }*/
}
