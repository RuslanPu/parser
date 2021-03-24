package parser.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import org.jsoup.nodes.Document;
import java.io.IOException;

@Service
public class QueryService {
    public String parsing(String query) throws IOException{
        query.trim().replaceAll(" ","+");
        try {

            Document doc = Jsoup.connect("https://www.ebay.co.uk/sch/i.html?_from=R40&_trksid=p2540003.m570.l1311&_nkw="+query+"&_sacat=0").get();
            Element el = doc.select("span.s-item__price").first();
            String cost = el.text();
            return cost;

        } catch (IOException ex) {
            System.out.println("error");
        }
            return "error";
    }

    
}
