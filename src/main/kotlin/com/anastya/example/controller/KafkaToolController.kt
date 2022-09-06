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

    @ApiOperation(value = "Отправка данных в топик Kafka")
    @PostMapping("/producer/string")
    fun sendMessageToKafka(
        @RequestBody(required = true)
        message: String,

        @ApiParam("Имя topica")
        @RequestParam(name = "topicName", required = true) topicName: String,

        @ApiParam("Партиция topica", example = "0")
        @RequestParam(name = "topicPartition", required = false, defaultValue = "0") topicPartition: Int
    ) {
        kafkaToolService.sendMessageToKafka(topicName, topicPartition, message)
    }
}