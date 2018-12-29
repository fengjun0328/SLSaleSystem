package cn.bdqn.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupDemo {

    public static void main(String[] args) {
        try {
            Document document=Jsoup.connect("https://tieba.baidu.com/f?fr=wwwt&kw=mvn%20repository").get();
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
