package com.mycompany.myapp.web.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import com.mycompany.myapp.security.AuthoritiesConstants;
import org.json.JSONObject;
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
    public String createArticle(){
        JSONArray listArticles = resultSetToJSON(DBConnection.getArticles());

        return listArticles;
    }

    /**
     * table to JSON
     */
    private String JSONify(String[] list){
        String res = "[";

        for(String s : list){
            res+="{"+s+"},";
        }

        return res.substring(0,res.length()-1)+"]";
    }

    /**
    * ResultSet to JSON
    */
    public static JSONArray resultSetToJSON(ResultSet resultSet)
            throws Exception {
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            for (int i = 0; i < total_rows; i++) {
                JSONObject obj = new JSONObject();
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1)
                        .toLowerCase(), resultSet.getObject(i + 1));
                jsonArray.put(obj);
            }
        }
        return jsonArray;
    }
}
