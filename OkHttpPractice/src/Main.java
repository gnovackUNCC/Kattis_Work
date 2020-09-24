import com.google.gson.Gson;
import okhttp3.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static OkHttpClient client = new OkHttpClient();
    static Gson gson = new Gson();
    public static void main(String[] args) throws IOException {
        String json = run("https://api.football-data.org/v2/competitions/PL/standings?season=2018");
        LOGGER.log(Level.INFO, json);
        jSonObject wholeThing = gson.fromJson(json, jSonObject.class);
        System.out.print(wholeThing);


    }
    public static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Auth-Token", "2b66905717c54334a57bfc768faaf042")
                .build();
        try(Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
class jSonObject{
    private String userId;
    private int id;
    private String title;
    private boolean completed;

    public jSonObject(String userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return userId + "\n" + id + "\n" + title + "\n" + completed;
    }
}