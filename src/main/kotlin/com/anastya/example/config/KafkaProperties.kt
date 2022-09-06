package com.anastya.example.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.boot.autoconfigure.kafka.KafkaProperties as SpringKafkaProperties

@Primary
@Component
@ConfigurationProperties(prefix = "app.kafka")
class KafkaProperties() : SpringKafkaProperties() {

    override fun buildProducerProperties(): MutableMap<String, Any> {
        val properties: MutableMap<String, Any> = super.buildProducerProperties()

        properties[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        properties[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java

        return properties
    }

}