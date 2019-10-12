package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {
    public static boolean divisible(ArrayList<Integer> arr, int e) {
      System.out.println("inside search");
      if (arr == null) return false;
        double result=0;
      for (int elt : arr) {
          double tmp=e;
          result=(double)elt/tmp;
          if (result==(elt/e))
              return true;
      }
      return false;
    }

    public static void main(String[] args) {
            port(getHerokuAssignedPort());

            get("/", (req, res) -> "Hello, World");

            post("/compute", (req, res) -> {

              String input1 = req.queryParams("input1");
              java.util.Scanner sc1 = new java.util.Scanner(input1);
              sc1.useDelimiter("[;\r\n]+");
              java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
              while (sc1.hasNext())
              {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
              }
              System.out.println(inputList);


              String input2 = req.queryParams("input2").replaceAll("\\s","");
              int input2AsInt = Integer.parseInt(input2);

              boolean result = App.divisible(inputList, input2AsInt);

              String input3 = req.queryParams("input3");
              java.util.Scanner sc2 = new java.util.Scanner(input3);
              sc2.useDelimiter("[;\r\n]+");
              java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
              while (sc2.hasNext())
              {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
              }
              System.out.println(inputList2);


              String input4 = req.queryParams("input4").replaceAll("\\s","");
              int input4AsInt = Integer.parseInt(input4);
              System.out.println(input4);

              String result2 = average(input4AsInt,inputList2);

              Map map = new HashMap();
              map.put("result", result);
              map.put("result2", result2);
              return new ModelAndView(map, "compute.mustache");
            }, new MustacheTemplateEngine());


            get("/compute",
                (rq, rs) -> {
                  Map map = new HashMap();
                  map.put("result", "not computed yet!");
                  map.put("result2", "The result of the operator is not computed yet");
                  return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
        }

        static int getHerokuAssignedPort() {
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (processBuilder.environment().get("PORT") != null) {
                return Integer.parseInt(processBuilder.environment().get("PORT"));
            }
            return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
        }

        static String average(int n, ArrayList<Integer> list) {
          if (list == null || list.size() == 0) return "Input not found.";
          if (n>=list.size()) return "Input n is larger than array";
          double sum=0;
          for (int i=0;i<n-1;i++)
              sum+=(double)list.get(i);
          double average=sum/(double)n;
          return "avrage of 0 to n is "+ average;
        }
    }
