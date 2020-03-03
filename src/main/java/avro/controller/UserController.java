package avro.controller;

import avro.kafka.UserProducer;
import avro.model.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Controller("/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserProducer producer;

    @Inject
    public UserController(UserProducer producer) {
        this.producer = producer;
    }

    @Post(produces = MediaType.APPLICATION_JSON)
    public CompletableFuture<MutableHttpResponse> create(@Body @NotBlank User user) {
        producer.create(UUID.randomUUID().toString(), UUID.randomUUID().toString(), user);
        return CompletableFuture.completedFuture(HttpResponse.accepted());
    }

}
