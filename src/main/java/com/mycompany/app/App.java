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
    public static boolean search(ArrayList<Integer> array, int e) {
      System.out.println("inside search");
      if (array == null) return false;

      for (int elt : array) {
        if (elt == e) return true;
      }
      return false;
    }

    public static void main(String[] args) {
            port(getHerokuAssignedPort());

            get("/", (req, res) -> "Hello, World");

            post("/compute", (req, res) -> {

// INPUT LIST
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
// END OF INPUT LIST

              String input2 = req.queryParams("input2").replaceAll("\\s","");
              int input2AsInt = Integer.parseInt(input2);

              boolean result = App.search(inputList, input2AsInt);


// INPUT LIST 2
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
// END OF INPUT LIST 2

              String input4 = req.queryParams("input4").replaceAll("\\s","");
              System.out.println(input4);

              String result2 = operator(input4,inputList2);

              Map map = new HashMap();
              map.put("result", result);
              map.put("result2", result2);
              return new ModelAndView(map, "compute.mustache");
            }, new MustacheTemplateEngine());
// END OF POST

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

        static String operator(String operator, ArrayList<Integer> list) {
          if (list == null || list.size() == 0) return "Input not found.";
          int result2;
          switch (operator) {
            case "+":
              result2 = 0;
              for (int i : list) {
                result2 += i;
              }
              return "The sum of the integers in the list: "+result2;
            case "-":
              result2 = 0;
              for (int i : list) {
                result2 -= i;
              }
              return "The minus sum of the integers in the list: "+result2;
            case "*":
              result2 = 1;
              for (int i : list) {
                result2 *= i;
              }
              return "The multiply of the integers in the list: "+result2;
            default:
              return "Wrong operator input";
          }
        }
    }
