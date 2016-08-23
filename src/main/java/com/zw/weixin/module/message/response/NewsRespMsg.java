package com.zw.weixin.module.message.response;

import java.util.List;

import com.zw.weixin.module.message.BaseMsg;
import com.zw.weixin.module.message.response.bean.Article;

/**
 * 响应消息->图文消息
 * 
 * @author martin_zou
 * @version 创建时间：2016年8月10日
 */
public class NewsRespMsg extends BaseMsg {
	
	/** 图文消息个数，限制为10条以内 */
	private int ArticleCount;
	/** 多条图文消息信息，默认第一个item为大图 */
    private List<Article> Articles;
    
	public int getArticleCount() {
		return ArticleCount;
	}
	
	public List<Article> getArticles() {
		return Articles;
	}
	
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
	
}
