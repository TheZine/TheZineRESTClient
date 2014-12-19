package app.thezineclient;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;


public class TheZineClient {
	//localhost rest server 10.0.2.2:5000
    private static final String API_BASE_URL = "http://thezine.herokuapp.com/v1/";
    private static AsyncHttpClient client = new AsyncHttpClient();
    
    // Getting List of Articles
    public static void getArticles(JsonHttpResponseHandler handler,int issue) {
    	String url;
    	if(issue>0)
    		url = getApiUrl("articles/"+issue);
    		
    	else
    		url = getApiUrl("articles");
        client.get(url, null, handler);
    } 
    
    //Getting a single article details
    public static void getArticle(JsonHttpResponseHandler handler,String articleId){
    	String url;
    	if(articleId.length() > 0)
    		url = getApiUrl("article/"+articleId);
    	else
    		url = "";
    	client.get(url, null,handler);
    }    
    
    //Getting a single author details
    public static void getAuthor(JsonHttpResponseHandler handler,String authorId){
    	String url;
    	// Validating authorId
    	if(authorId.length() > 0)
    		url = getApiUrl("author/"+authorId);
    	else
    		url = "";
    	client.get(url, null,handler);
    }
    
    // helper function
    private static String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }
}
