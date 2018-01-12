package json;

import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
     ArrayList<JsonPair> objs;

    public JsonObject() {
        this.objs = new ArrayList<>();
    }

    public JsonObject(JsonPair... jsonPairs) {
        this.objs = new ArrayList<>();
        for (JsonPair p : jsonPairs) {
            this.add(p);
        }
    }

    @Override
    public String toJson() {
        if (objs.isEmpty() == true){
            return "{}";
        }
        String s_objs = "{";
        for (int i=0; i < objs.size(); i++){
            s_objs += "'" + objs.get(i).key.toString() + "'" + ": " + objs.get(i).value.toJson();
            if (i != objs.size() - 1){
                s_objs += ", ";
            }
        }
        return s_objs + "}";
    }

    public void add(JsonPair jsonPair) {
        this.objs.add(jsonPair);

    }

    public Json find(String name) {
        for (int i=0; i<objs.size(); i++){
            if (objs.get(i).key.equals(name)){
                return objs.get(i).value;
            }
        }
        return null ;
    }

    public JsonObject projection(String... names) {
        JsonObject j = new JsonObject();
        for (String name : names){
            Json res = this.find(name);
            if (res != null){
                j.add(new JsonPair(name, res));
            }
        }
        return j;
    }
}
