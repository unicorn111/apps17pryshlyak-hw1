package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */

public class JsonNull extends Json {
    private final Object nll;

    public JsonNull() {
        this.nll = null;
    }

    public JsonNull(Object nll) {
        this.nll = null;
    }

    @Override
    public String toJson(){
        return "null";
    }
}