package avro.controller;

import avro.kafka.PaymentProducer;
import avro.kafka.UserProducer;
import avro.model.Payment;
import avro.model.User;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.inject.Inject;
import javax.validation.constraints.NotBlank;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Controller("/payments")
public class PaymentController {
    private final PaymentProducer producer;

    @Inject
    public PaymentController(PaymentProducer producer) {
        this.producer = producer;
    }

    @Post(produces = MediaType.APPLICATION_JSON)
    public CompletableFuture<MutableHttpResponse> create(@Body @NotBlank Payment payment) {
        producer.create(UUID.randomUUID().toString(), UUID.randomUUID().toString(), payment);
        return CompletableFuture.completedFuture(HttpResponse.accepted());
    }

}
