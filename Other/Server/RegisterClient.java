import org.json.simple.JSONObject;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.Socket; 
import java.net.UnknownHostException;

public class RegisterClient {
	private Socket sock = null;

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		
		//Creates JSON Object
		JSONObject obj = new JSONObject();
		obj.put("firstName", "Test");
		obj.put("lastName", "Testevez");
		obj.put("email", "test@test.com");	
		
		//Class instance
		RegisterClient client = new RegisterClient();
		
		// Socket TCP connection
		String ip = "localhost";
		int port = 8081;
		client.socketConnect(ip, port);
		
		System.out.println("Client Request: " + obj);
		String returnStr = client.echo(obj);
		System.out.println("Server Response: " + returnStr);
		client.sock.close();
	}
	
	// Makes connection with socket
	private void socketConnect(String ip, int port) throws UnknownHostException, IOException {
		System.out.println("[Connecting to Socket...]");
		this.sock = new Socket(ip, port);
	}
	
	// Writes and receives message in socket
	public String echo(JSONObject message){
		try {
			PrintWriter out = new PrintWriter(getSocket().getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));
			
			// Writes sends JSON Object
			out.println(message);
			
			// JSON Object returns by being read in and is converted to string
			String returnStr = in.readLine();
			return returnStr;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Socket getSocket()
	{
		return sock;
	}
}
