package com.project.kp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.kp.dto.MyDataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(DataService.class);

    public void sendData(MyDataDto myDatadto) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.writeValueAsString(myDatadto);
        logger.info("Sending weather as temperature = " + myDatadto.getTemperature() + ", humidity = " + myDatadto.getHumidity() + ", windspeed = " + myDatadto.getWindSpeed());
        kafkaTemplate.send("weather-topic", valueAsString);
    }
}
