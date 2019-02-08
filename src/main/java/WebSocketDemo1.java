import java.io.IOException;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/demo1")
public class WebSocketDemo1 {

	@OnOpen
	public void greeting(Session session) {
		try {
			System.out.println("got new connection:" + session.getId());
			session.getBasicRemote().sendText("Hello from the server!");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			session.getBasicRemote().sendText("Hello Again!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
