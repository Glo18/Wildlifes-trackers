import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/AnimalsForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "AnimalsForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/addAnimal", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String animalName = request.queryParams("animalName");

            Animals animals = new Animals(animalName);
            animals.save();
            model.put("animals", animals);
            return new ModelAndView(model, "SuccessAnimal.hbs");
        }, new HandlebarsTemplateEngine());

        get("/Animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("Animals", Animals.getAllAnimals());
            return new ModelAndView(model, "Animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/EndangeredForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "EndangeredForm.hbs");
        }, new HandlebarsTemplateEngine());


        post("/report", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            Endagered endangered = new Endagered(name, health,age);
            endangered.save();
            model.put("endangered", endangered);
            return new ModelAndView(model, "SuccessEndangered.hbs");
        }, new HandlebarsTemplateEngine());

        get("/Endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("Endangered", Endagered.getAllEndagered());
            return new ModelAndView(model, "Endangered.hbs");
        }, new HandlebarsTemplateEngine());

//        Sightings
        get("/SightingsForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "SightingsForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/spotted", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            String aniName = request.queryParams("animalName");

            Sightings sightings = new Sightings(location,rangerName, aniName);
            sightings.save();
            model.put("sightings", sightings);
            return new ModelAndView(model, "SuccessSightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/Sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("Sightings", Sightings.getAllSightings());
            return new ModelAndView(model, "Sightings.hbs");
        }, new HandlebarsTemplateEngine());


    }
}


