package com.anastya.example.controller

import com.anastya.example.service.KafkaToolService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class KafkaToolController(
    private val kafkaToolService: KafkaToolService
) {

    @ApiOperation(value = "Send data to Kafka topic")
    @PostMapping("/producer/string")
    fun sendMessageToKafka(
        @RequestBody(required = true)
        message: String,

        @ApiParam("Topic name")
        @RequestParam(name = "topicName", required = true) topicName: String,

        @ApiParam("Topic partition", example = "0")
        @RequestParam(name = "topicPartition", required = false, defaultValue = "0") topicPartition: Int
    ) {
        kafkaToolService.sendMessageToKafka(topicName, topicPartition, message)
    }
}