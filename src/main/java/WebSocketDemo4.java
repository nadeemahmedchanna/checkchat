import java.io.IOException;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/demo4")
public class WebSocketDemo4 {

	@OnOpen
	public void greeting(Session session) {
		try {
			System.out.println("got new connection:" + session.getId());
			long timeout = session.getMaxIdleTimeout();
			boolean isSecure = session.isSecure();
			int textMessageBufferSize = session.getMaxTextMessageBufferSize();
			session.getBasicRemote().sendText(
					"Your idle timeout limit is:" + timeout);
			session.getBasicRemote().sendText(
					"Your session is " + (isSecure ? "" : "not") + " secure");
			session.getBasicRemote().sendText(
					"Your max text message size is: " + textMessageBufferSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
