

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/demo2")
public class WebSocketDemo2 {

	@OnOpen
	public void greeting(Session session) {
		try {
			session.getBasicRemote().sendText("Hello from the server!");
			session.getBasicRemote().sendText("What's your name?");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnMessage
	public void message(String message, Session session) {
		System.out.println(message);
		try {
			session.getBasicRemote().sendText("Hello "+ message + ", let's play a game!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
