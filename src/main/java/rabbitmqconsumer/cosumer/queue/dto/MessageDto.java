package rabbitmqconsumer.cosumer.queue.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("message")
	private String message;
	
	public MessageDto() {
		
	}

	public MessageDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageDto [message=" + message + "]";
	}
	
	
}
