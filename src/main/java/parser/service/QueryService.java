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
        ArrayList<String> arrOut = new ArrayList<>();
        query.trim().replaceAll(" ","+");
        Double result = 0.0;
        Double result1 = 0.0;
        try {

            Document doc = Jsoup.connect("https://www.ebay.co.uk/sch/i.html?_from=R40&_trksid=p2540003.m570.l1311&_nkw="+query+"&_sacat=0&_ipg=200&_udhi=200&LH_BIN=1&rt=nc&LH_ItemCondition=3000%7C2500").get();
            Elements el = new Elements();
            el = doc.select("span.s-item__price");

                for (Element temp : el) {

//                int number = Integer.parseInt(temp.text().replaceAll("£",""));
//                result += number;
//                temp.text().replaceAll("£","");
                    if (temp.text().contains("to")) {
                        for (String retval : temp.text().split(" to ", 2)) {

                            Double number = Double.parseDouble(retval.replaceAll("£", "").replace(" ", ""));
                            if (number > 5) {
                                result += number;

                                arr.add(retval);
                            } else {
                                break;
                            }

                        }
                    } else {
                        Double number = Double.parseDouble(temp.text().replaceAll("£", "").replace(" ", ""));
                        if(number > 5){
                            result += number;
                            arr.add(temp.text());
                        }
                        else {
                            break;
                        }



                    }


                }
            for(int i = 0 ; i < arr.size(); i++) {

                arrOut.add(arr.get(i).replaceAll("£",""));
                Double number1 = Double.parseDouble(arrOut.get(i));
                result1 += number1;
                System.out.println(arrOut.get(i));
            }
            Double srCh1 = result1/arrOut.size();
            String srChSt1 = Double.toString(srCh1);
            System.out.println("result1 : " + result1 + " size : " + arrOut.size() + " srednee : " + srCh1);

//            Double srCh = result/(arr.size());
//            System.out.println("Средн: " + srCh + " кол-во эл: " + arr.size());
//            String srChSt = Double.toString(srCh);
//            arr.add(107, srChSt);
            arrOut.add(srChSt1);
            return arrOut;

        } catch (IOException ex) {
            System.out.println("error");
        }
            return arrOut;
    }

    
}
