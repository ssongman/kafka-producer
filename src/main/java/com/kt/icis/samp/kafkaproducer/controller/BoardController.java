package com.kt.icis.samp.kafkaproducer.controller;

import com.kt.icis.samp.kafkaproducer.events.BoardCreateEvent;
import com.kt.icis.samp.kafkaproducer.events.BoardDeleteEvent;
import com.kt.icis.samp.kafkaproducer.events.BoardUpdateEvent;
import com.kt.icis.samp.kafkaproducer.model.ResultMessage;
import com.kt.icis.samp.kafkaproducer.service.BoardEventService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardEventService boardEventService;

    @PostMapping("/create")
	public ResultMessage createBoard(@RequestBody BoardCreateEvent event ) {
   
		return   boardEventService.boardCreate(event);
	}

    @PostMapping("/update")
	public ResultMessage updateBoard(@RequestBody BoardUpdateEvent event ) {   
		return   boardEventService.boardUpdate(event);
	}

    @PostMapping("/delete")
	public ResultMessage deleteBoard(@RequestBody BoardDeleteEvent event ) {   
		return   boardEventService.boardDelete(event);
	}


}
