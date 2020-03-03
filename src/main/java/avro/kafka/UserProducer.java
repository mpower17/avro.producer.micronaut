package avro.kafka;

import avro.model.User;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.http.annotation.Header;

@KafkaClient
public interface UserProducer {

    @Topic("user.created")
    void create(@KafkaKey String key,
                @Header(name = "tracerId") String traceId,
                User user);

}
