package kr.or.bit.main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JavaWebCrawler {

	 public static String getCurrentData(){
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	        return sdf.format(new Date());
	    }
	    public static void goCrawling() throws IOException {
	        System.out.println("Start Date : " + getCurrentData());
	 
	        Document doc2 = Jsoup.connect("http://archive.htrucci.com").get();
	        //System.out.println(doc2.data());
	        //System.out.println(doc2.body());
	        System.out.println("블로그 제목 :"+doc2.body().getElementsByClass("navbar-brand text-logo").text());
	        Elements posts = doc2.body().getElementsByClass("entry-title");
	        //System.out.println(doc2.body().getElementsByClass("entry-title"));
	        for(int i=0; i<posts.size(); i++){
	            System.out.println("Post Title : "+posts.eq(i).text());
	            System.out.println("Link : "+posts.eq(i).select("a").attr("href"));
	            System.out.println("Post Image : "+doc2.body().getElementsByClass("post-thumbnail post-thumbnail-small").eq(i).select("img").attr("src"));
	            System.out.println();
	 
	        }
	        System.out.println("End Date : " + getCurrentData());
	 
	 
//	        HttpPost http = new HttpPost("http://www.htrucci.com");
	//
//	        HttpClient httpClient = HttpClientBuilder.create().build();
	//
//	        HttpResponse response = httpClient.execute(http);
	//
//	        HttpEntity entity = response.getEntity();
	//
//	        ContentType contentType = ContentType.getOrDefault(entity);
//	        Charset charset = contentType.getCharset();
//	        if(charset == null){
//	            charset = Charset.defaultCharset();
//	        }
//	        BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
	//
//	        StringBuffer sb = new StringBuffer();
	//
//	        String line = "";
//	        while((line=br.readLine()) != null){
//	            sb.append(line+"\n");
//	        }
//	        System.out.println(sb.toString());
	//
//	        Document doc = Jsoup.parse(sb.toString());
	 
	    }
}
