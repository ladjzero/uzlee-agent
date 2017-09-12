package ladjzero.hipda.core.parsers;

import com.google.gson.Gson;
import ladjzero.hipda.core.api.Response;

/**
 * Created by chenzhuo on 8/29/17.
 */
public class JsonParser extends Parser {
    private Gson mGson;

    public JsonParser() {
        mGson = new Gson();
    }

    @Override
    public Response parse(String json) {
        return mGson.fromJson(json, Response.class);
    }
}
