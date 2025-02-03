package com.project.kc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.kp.dto.MyDataDto;
import com.project.kp.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DataConsumer {

    private static final Logger logger = LoggerFactory.getLogger(DataConsumer.class);
    @KafkaListener(topics = "weather-topic", groupId = "myGroup")
    public void consumeData(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MyDataDto myDataDto = objectMapper.readValue(message, MyDataDto.class);
        logger.info("Received weather as temperature = " + myDataDto.getTemperature() + ", humidity = " + myDataDto.getHumidity() + ", windspeed = " + myDataDto.getWindSpeed());
    }
}
