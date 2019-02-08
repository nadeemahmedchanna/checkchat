import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/demo3/{client-id}")
public class WebSocketDemo3 {

	@OnOpen
	public void greeting(Session session,
			@PathParam("client-id") String clientId) {
		try {
			session.getBasicRemote().sendText(
					"Hello " + clientId + " welcome to the party!");
			for (Session s : session.getOpenSessions()) {
				s.getBasicRemote().sendText(clientId + " Joined the chat room");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnMessage
	public void message(String message, Session session,
			@PathParam("client-id") String clientId) {
		try {
			for (Session s : session.getOpenSessions()) {
				s.getBasicRemote().sendText(clientId + " says:" + message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnClose
	public void close(Session session, @PathParam("client-id") String clientId) {
		try {
			for (Session s : session.getOpenSessions()) {
				s.getBasicRemote().sendText(clientId + " Left the chat room");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
