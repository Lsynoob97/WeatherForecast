package com.example.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	
	public static void sendHttpRequest(final String address,
			final HttpCallbackListener listener) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				HttpURLConnection connection = null;
				try {
					URL url = new URL(address); //创建URL实例，打开URLConnection
					connection = (HttpURLConnection) url.openConnection(); //得到connection对象。
					connection.setRequestMethod("GET"); //设置请求方式
					connection.setConnectTimeout(8000); //超时链接时间设置为8秒
					connection.setReadTimeout(8000);
					InputStream in = connection.getInputStream(); //读取外部链接数据
					BufferedReader reader = new BufferedReader(new InputStreamReader(in)); //读数据：
					StringBuilder response = new StringBuilder();
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}
					if (listener != null) {
						listener.onFinish(response.toString());
					}
				} catch (Exception e) {
					if (listener != null) {
						listener.onError(e);
					}
				} finally {
					if (connection != null) {
						connection.disconnect();
					}
				}
			}
		}).start();
	}

}