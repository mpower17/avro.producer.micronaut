package avro;

import avro.model.User;
import io.micronaut.runtime.Micronaut;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;

import java.io.IOException;

public class Application {

    private final static MediaType SCHEMA_CONTENT =
            MediaType.parse("application/vnd.schemaregistry.v1+json");

    public static void createScheme() throws IOException {
        Schema schema = ReflectData.get().getSchema(User.class);
        sendSchema(schema.toString(true));
    }

    public static void sendSchema(String schema) throws IOException {
        final OkHttpClient client = new OkHttpClient();
        //POST A NEW SCHEMA
        Request request = new Request.Builder()
                .post(RequestBody.create(SCHEMA_CONTENT, schema))
                .url("http://localhost:8081/subjects/User/versions")
                .build();
        String output = client.newCall(request).execute().body().string();
    }

    public static void main(String[] args) {
        try {
            createScheme();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Micronaut.run(Application.class);
    }
}