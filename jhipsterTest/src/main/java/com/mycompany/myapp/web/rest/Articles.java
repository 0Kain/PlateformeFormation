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



        obj.put("title",title);
        obj.put("content",content);
        obj.put("topics",JSONify(topics));
        obj.put("keywords",JSONify(keywords));
        return obj.toString();
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
}