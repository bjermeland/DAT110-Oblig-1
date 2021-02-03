package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	public void connect() {
		
		this.connection = msgclient.connect();	

	}
	
	public void disconnect() {
		
		this.connection.close();
		
	}
	
	public byte[] call(byte[] rpcrequest) {
		
		connection.send(new Message(rpcrequest));
		return connection.receive().getData();
		
	}

}
