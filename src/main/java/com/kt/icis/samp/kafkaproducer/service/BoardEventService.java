package com.kt.icis.samp.kafkaproducer.service;

import com.kt.icis.samp.kafkaproducer.events.BoardCreateEvent;
import com.kt.icis.samp.kafkaproducer.events.BoardDeleteEvent;
import com.kt.icis.samp.kafkaproducer.events.BoardUpdateEvent;
import com.kt.icis.samp.kafkaproducer.model.ResultMessage;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class BoardEventService {
    
    private final StreamBridge streamBridge;
    private static String SUCCESS = "Y";

    public ResultMessage boardCreate(BoardCreateEvent event){
 
        boolean result = streamBridge.send("boardCreate-out-0", event);
        log.info("====[Producer]====== boardCreate send to kafka Topic  BoardCreateEvent: {} , result :{}", event , result);
        return getReturnResultMessage(result);

    }
    
    public ResultMessage boardUpdate( BoardUpdateEvent event){
      
        boolean result = streamBridge.send("boardUpdate-out-0", event);
        log.info("====[Producer]====== boardCreate send to kafka Topic  BoardUpdateEvent: {} , result :{}", event , result);
        return getReturnResultMessage(result);
        
    }
    public ResultMessage boardDelete(BoardDeleteEvent event){
        
        boolean result = streamBridge.send("boardDelete-out-0", event);
         log.info("====[Producer]======boardDelete send to kafka Topic  BoardDeleteEvent: {} , result :{}", event , result);
        return getReturnResultMessage(result);
        
    }

    private ResultMessage getReturnResultMessage(boolean result) {
		ResultMessage resultMsg = new ResultMessage("N", "실패");			 
		if (result) {
            resultMsg.setSuccessYn(SUCCESS);
            resultMsg.setMessage("성공");
			return resultMsg;
		}
		return resultMsg;

	}


}
