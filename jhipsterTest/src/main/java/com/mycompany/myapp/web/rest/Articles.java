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
        JSONArray listArticles = DBConnection.getArticles();
        JSONArray res = new JSONArray();

        
        for(Object temp : listArticles){
            JSONObject elem = new JSONObject((String) temp);
            Object a = elem.get("keywords");
            JSONArray categs = JSONify(((String) a).split("},{"),"categName");
            String parsedContent = (String)elem.get("contenu");
            JSONObject obj = new JSONObject();
            obj.put("actuHeader",elem.get("titre"));
            obj.put("actuCategs",categs);
            obj.put("actuText",parsedContent);
            obj.put("actuDate",elem.get("date-modif"));
            res.put(obj);
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
