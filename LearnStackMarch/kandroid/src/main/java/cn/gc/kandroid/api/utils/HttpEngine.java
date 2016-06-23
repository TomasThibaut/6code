package cn.gc.kandroid.api.utils;

import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by 宫成 on 16/3/29 下午1:59.
 * 构建http请求 , 并异步得到结果
 */
public class HttpEngine {
    public static final int TIME_OUT = 20000;
    public static final String URL = "http://uat.b.quancome.com/platform/api";

    private HttpEngine() {}


    private static HttpEngine mInstance;


    /**
     * 构架http请求比较耗资源?所以用单例,不需要同步, 因为无所谓?
     * @return
     */
    public static HttpEngine getInstance() {
        if (mInstance == null) {
            mInstance = new HttpEngine();
        }
        return mInstance;
    }


    public <T> T postHandle(Map<String, String> paramMap, Type type) {
        HttpURLConnection conn = null;
        OutputStream os = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            //构造HttpUrlConnection对象
            String data = joinParams(paramMap);
            conn = (HttpURLConnection) new URL(URL).openConnection();
            conn.setReadTimeout(TIME_OUT);
            conn.setConnectTimeout(TIME_OUT);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("Response-Type", "json");
            conn.setRequestProperty("Content-length", String.valueOf(data.getBytes().length));
            conn.setChunkedStreamingMode(0);
            conn.connect();//连接服务器

            //写入请求体body , post请求请求参数在body中
            os = conn.getOutputStream();
            os.write(data.getBytes());
            os.flush();

            if (conn.getResponseCode() == 200) {

                is = conn.getInputStream();//这个方法的实现是异步请求的, 所以需要制定TIME_OUT
                //读取response内容
                bos = new ByteArrayOutputStream();
                int len;
                byte[] buffer = new byte[1024];
                while ((len = is.read()) != -1) {
                    bos.write(buffer, 0, len);
                }
                bos.flush();
                String result = new String(bos.toByteArray());
                //处理成为model,返回
                return new Gson().fromJson(result, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) conn.disconnect();
            try {
                if (os != null) os.close();
                if (is != null) is.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /**
     * 拼接请求参数
     */
    private String joinParams(Map<String, String> paramMap) throws UnsupportedEncodingException {
        StringBuilder builder = new StringBuilder();
        for (String s : paramMap.keySet()) {
            String value = paramMap.get(s);
            String encodeValue = URLEncoder.encode(value, "UTF-8");
            builder.append(s).append("=").append(encodeValue).append("&");
        }
        return builder.substring(0, builder.length() - 1);
    }
}
