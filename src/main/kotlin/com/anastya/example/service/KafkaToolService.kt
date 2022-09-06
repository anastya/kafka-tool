package com.anastya.example.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class KafkaToolService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendMessageToKafka(topicName: String, topicPartition: Int, message: String) {
        kafkaTemplate.send(topicName, topicPartition, UUID.randomUUID().toString(), message)
    }
}