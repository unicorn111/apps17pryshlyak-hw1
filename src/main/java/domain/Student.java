package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    protected ArrayList<Tuple> exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = new ArrayList<>(Arrays.asList(exams));
    }
    @Override
    public JsonObject toJsonObject(){
        JsonObject jsonObject = new JsonObject(new JsonPair("name", new JsonString(this.name)),
                new JsonPair("surname", new JsonString(this.surname)),
                new JsonPair("year", new JsonNumber(this.year)));
        ArrayList<JsonObject> array = new ArrayList<>();
        for (int i=0; i<exams.size(); i++){
            JsonPair course = new JsonPair("course", new JsonString(exams.get(i).key.toString()));
            JsonPair mark = new JsonPair("mark", new JsonNumber((int)exams.get(i).value));
            JsonPair passed = new JsonPair("passed", new JsonBoolean((int)exams.get(i).value >=3 == true));
            array.add(new JsonObject(course, mark, passed));
        }
        JsonObject[] n_array = new JsonObject[exams.size()];
        array.toArray(n_array);
        jsonObject.add(new JsonPair("exams", new JsonArray(n_array)));


        return jsonObject;
    }
}

