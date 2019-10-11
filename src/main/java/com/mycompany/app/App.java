package com.mycompany.app;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
public class App
   {
     public static boolean search(ArrayList<Integer> array, int e) {
          System.out.println("inside search");
          if (array == null) return false;
          for (int elt : array) {
               if (elt == e) return true;
          }
          return false;
   }
