package com.cgi.workshop;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.workshop.publishers.DirectExchangePublisher;
import com.cgi.workshop.publishers.FanoutExchangePublisher;
import com.cgi.workshop.publishers.RequestReplyPublisher;
import com.cgi.workshop.publishers.TopicExchangePublisher;

@Component
public class Producer {
	
	private PublishTypes type = PublishTypes.DIRECT_EXCHANGE;
	
	@Autowired
	DirectExchangePublisher directExchangePublisher;
	@Autowired
	FanoutExchangePublisher fanoutExchangePublisher;
	@Autowired
	TopicExchangePublisher topicExchangePublisher;
	@Autowired
	RequestReplyPublisher requestReplyPublisher;

	public Producer publishTo(PublishTypes type) {
		this.type = type;
		return this;
	}
	
	public void with(Supplier<Object> payloadFunction) throws InterruptedException{
		switch(this.type){
			case DIRECT_EXCHANGE:
				directExchangePublisher.publish(payloadFunction);
			case FANOUT_EXCHANGE:
				fanoutExchangePublisher.publish(payloadFunction);
			case TOPIC_EXCHANGE: 
				topicExchangePublisher.publish(payloadFunction);
			case REQUEST_REPLY:
				requestReplyPublisher.publish(payloadFunction);
	}
	}

}
