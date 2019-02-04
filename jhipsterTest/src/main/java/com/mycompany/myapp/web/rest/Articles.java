package com.mycompany.myapp.web.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import com.mycompany.myapp.security.AuthoritiesConstants;
import org.json.*;
import java.io.StringWriter;

@RestController
//@Secured(AuthoritiesConstants.ADMIN)
@RequestMapping("/api/articles")
public class Articles {

    /**
     * @param title
     * titre de l'article
     * @param content
     * le contenu de l'article
     * @param topics
     * sujet(s) de l'article
     * @param keywords
     * on verra apres
     */
    @PostMapping(path="/create", produces={"application/JSON"})
    public String createArticle(@RequestParam(value = "title") String title,
    @RequestParam(value = "content") String content,
    @RequestParam(value = "topics") String[] topics,
    @RequestParam(value = "keywords") String[] keywords)
    {

        JSONObject obj = new JSONObject();

        obj.put("sujet",JSONify(topics));
        obj.put("titre",title);
        obj.put("keywords",JSONify(keywords));
        obj.put("contenu",content);

        //put in db
        DBConnection.insert("articles",obj);

        return obj.toString();
    }

    @RequestMapping(path="/all", produces={"application/JSON"})
    public String getAllArticles(){
        System.out.println("\n\n\n\n-------------------------\n\n");
        JSONArray listArticles = DBConnection.getArticles();
        JSONArray res = new JSONArray();

        System.out.println(listArticles + "\n");
         
        JSONObject obj = new JSONObject();
        for(int count = 0; count < listArticles.length(); count++){
            JSONObject jobj = new JSONObject();
            switch (count % 10) {
                case 0://id
                    break;
                case 1://sujet
                    break;
                case 2://titre
                    jobj = (JSONObject) listArticles.get(count);
                    if(!jobj.has("titre")){
                        break;
                    }
                     obj.put("actuHeader", ((JSONObject) listArticles.get(count)).get("titre"));
                    break;
                case 3://keywords
                    jobj = (JSONObject) listArticles.get(count);
                    if(!jobj.has("keywords")){
                        break;
                    }
                    System.out.println(jobj);
                    String keywords = jobj.getString("keywords");
                    JSONArray categs = new JSONArray();
                    if(keywords.contains("},{")){
                         categs = JSONify(keywords.split("\\},\\{"),"categName");
                    }else {
                        String[] a = new String[1];
                        a[0] = keywords;
                        categs = JSONify(a,"categName");
                    }
                    obj.put("actuCategs",categs);
                    break;
                case 4://auteur
                    break;
                case 5://date-creation
                    break;
                case 6://date-modif
                    jobj = (JSONObject) listArticles.get(count);
                    if(!jobj.has("date-modif")){
                        break;
                    }
                    obj.put("actuDate", jobj.get("date-modif"));
                    break;
                case 7://contenu
                    jobj = (JSONObject) listArticles.get(count);
                    if(!jobj.has("contenu")){
                        break;
                    }
                    String parsedContent = jobj.getString("contenu");
                    obj.put("actuText",parsedContent);
                    break;
                case 8://reference
                    break;
                case 9://resume

                    //faire des trucs avec resume

                    //puis
                    obj = new JSONObject();
                    res.put(obj);
                    break;
            }
            // JSONObject elem = new JSONObject(temp.toString());
            // System.out.println(elem + "");
            // JSONArray categs = JSONify(elem.getString("keywords").split("},{"),"categName");
            // String parsedContent = (elem.get("contenu")).toString();
            // JSONObject obj = new JSONObject();
            // obj.put("actuHeader",elem.get("titre"));
            // obj.put("actuCategs",categs);
            // obj.put("actuText",parsedContent);
            // obj.put("actuDate",elem.get("date-modif"));
        }
        return res.toString();
    }

    /**
     * table to JSON
     */
    private JSONArray JSONify(String[] list,String categName){
        JSONArray res = new JSONArray();

        for(String s : list){
            res.put(new JSONObject("{"+categName+":"+s+"}"));
        }

        return res;
    }

    private JSONArray JSONify(String[] list){
        JSONArray res = new JSONArray();

        for(String s : list){
            res.put(s);
        }

        return res;
    }
}
