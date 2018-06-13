package com.ccydhz.site.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Utils {

	
	public static String sendHttpGet(HttpGet httpGet, RequestConfig requestConfig) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = HttpClients.createDefault();
			httpGet.setConfig(requestConfig);
			// 执行请求
			response = httpClient.execute(httpGet);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭连接,释放资源
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}
	
	public static String sendHttpPost(HttpPost httpPost, RequestConfig requestConfig) {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String responseContent = null;
		try {
			// 创建默认的httpClient实例.
			httpClient = HttpClients.createDefault();
			httpPost.setConfig(requestConfig);
			// 执行请求
			response = httpClient.execute(httpPost);
			entity = response.getEntity();
			responseContent = EntityUtils.toString(entity, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭连接,释放资源
				if (response != null) {
					response.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}
	
	public static byte[] compress(byte[] buff) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gzos = new GZIPOutputStream(baos);
		gzos.write(buff);
		gzos.close();
		baos.close();
		return baos.toByteArray();
	}
	
	public static byte[] uncompress(byte[] buff) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream bais = new ByteArrayInputStream(buff);
		GZIPInputStream gzis = new GZIPInputStream(bais);
		byte[] temp = new byte[1024];
		int len = 0;
		while ((len = gzis.read(temp)) >= 0) {
			out.write(temp, 0, len);
		}
		byte[] receive = out.toByteArray();
		gzis.close();
		bais.close();
		return receive;
	}
	
	public static void main(String[] args) throws IOException {
		byte[] b  = new byte[1000];
		for (int i = 0;i < b.length;++i) {
			b[i] = 65;
		}
		byte[] buff = compress(b);
		System.out.println(buff.length);
		
		byte[] c = uncompress(buff);
		System.out.println(c.length);
	}
}
