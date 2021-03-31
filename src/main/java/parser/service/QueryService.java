package parser.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class QueryService {


    public ArrayList<String> parsingList(String query) throws IOException{
        ArrayList<String> arr = new ArrayList<>();
        query.trim().replaceAll(" ","+");
        Double result = 0.0;
        try {

            Document doc = Jsoup.connect("https://www.ebay.co.uk/sch/i.html?_from=R40&_trksid=p2540003.m570.l1311&_nkw="+query+"&_sacat=0&_ipg=100&_udhi=100").get();
            Elements el = new Elements(100);
            el = doc.select("span.s-item__price");

            for(Element temp : el) {

//                int number = Integer.parseInt(temp.text().replaceAll("£",""));
//                result += number;
//                temp.text().replaceAll("£","");
                if (temp.text().contains("to")) {
                    for (String retval : temp.text().split(" to ", 2)) {

                        Double number = Double.parseDouble(retval.replaceAll("£","").replace(" ",""));
                        result += number;
                        arr.add(retval);
                    }
                } else {
                    Double number = Double.parseDouble(temp.text().replaceAll("£","").replace(" ",""));
                    result += number;
                    arr.add(temp.text());


                }




            }
            Double srCh = result/(arr.size());
            String srChSt = Double.toString(srCh);
            arr.add(107, srChSt);
            return arr;

        } catch (IOException ex) {
            System.out.println("error");
        }
            return arr;
    }

    
}
