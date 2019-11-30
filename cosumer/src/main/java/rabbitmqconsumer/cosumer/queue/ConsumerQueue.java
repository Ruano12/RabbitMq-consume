package rabbitmqconsumer.cosumer.queue;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rabbitmqconsumer.cosumer.queue.dto.MessageDto;

@Service
public class ConsumerQueue {

	@RabbitListener(queues="${fila.entrada}")
    public void onMessage(Message message) throws JsonParseException, JsonMappingException, IOException   {
		
		String json = new String(message.getBody(), "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		MessageDto messageDto = mapper.readValue(json, MessageDto.class);
		
		System.out.println(messageDto.getMessage());
	}
}
