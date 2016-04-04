//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package me.chanjar.weixin.mp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

public class WxMpMaterialNews implements Serializable {
    private List<WxMpMaterialNews.WxMpMaterialNewsArticle> articles = new ArrayList();

    public WxMpMaterialNews() {
    }

    public List<WxMpMaterialNews.WxMpMaterialNewsArticle> getArticles() {
        return this.articles;
    }

    public void addArticle(WxMpMaterialNews.WxMpMaterialNewsArticle article) {
        this.articles.add(article);
    }

    public String toJson() {
        return WxMpGsonBuilder.INSTANCE.create().toJson(this);
    }

    public boolean isEmpty() {
        return this.articles == null || this.articles.isEmpty();
    }

    public String toString() {
        return "WxMpMaterialNews [articles=" + this.articles + "]";
    }

    public static class WxMpMaterialNewsArticle {
        private String thumbMediaId;
        private String thumbUrl;
        private String author;
        private String title;
        private String contentSourceUrl;
        private String content;
        private String digest;
        private boolean showCoverPic;
        private String url;

        public WxMpMaterialNewsArticle() {
        }

        public String getThumbMediaId() {
            return this.thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }

        public String getAuthor() {
            return this.author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContentSourceUrl() {
            return this.contentSourceUrl;
        }

        public void setContentSourceUrl(String contentSourceUrl) {
            this.contentSourceUrl = contentSourceUrl;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDigest() {
            return this.digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isShowCoverPic() {
            return this.showCoverPic;
        }

        public void setShowCoverPic(boolean showCoverPic) {
            this.showCoverPic = showCoverPic;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String toString() {
            return "WxMpMassNewsArticle [thumbMediaId=" + this.thumbMediaId + ", author=" + this.author + ", title=" + this.title + ", contentSourceUrl=" + this.contentSourceUrl + ", content=" + this.content + ", digest=" + this.digest + ", showCoverPic=" + this.showCoverPic + ", url=" + this.url + "]";
        }
    }
}
