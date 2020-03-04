package avro.kafka;

import avro.model.Payment;
import avro.model.User;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Property;
import io.micronaut.http.annotation.Header;
import org.apache.kafka.clients.producer.ProducerConfig;

@KafkaClient(
        properties = {@Property(
                name = ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                value = "org.apache.kafka.common.serialization.StringSerializer"
        ), @Property(
                name = ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                value = "io.confluent.kafka.serializers.KafkaAvroSerializer"
        )}
)
public interface PaymentProducer {

    @Topic("payment.created")
    void create(@KafkaKey String key,
                @Header(name = "tracerId") String traceId,
                Payment payment);

}
