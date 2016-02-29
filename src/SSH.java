import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

 

public class SSH{
	 private String user; //user's name on distant server
	 private String password; // user's password on distant server
	 private String host; // server's ip address
     private List<String> result = new ArrayList<String>(); //receives the command's result
     private Session session; //session between client and server
     private ChannelExec channelExec; //channel to pass command from client to server
     private JSch jsch; //configuration object, allows us to create the Session object for the connection
     
    
	 public SSH(String usr,String psw,String hst)//constructor
	 {
		 user=usr;
		 password=psw;
		 host=hst;
	 }
	 
	 public void OpenSessionSSH() //serves to the creation of a connection and a tunnel between serv and client
	 {
		 try{
			 	jsch = new JSch();
	            session = jsch.getSession(user, host, 22);// connection ssh on port 22
	            session.setConfig("StrictHostKeyChecking", "no");//no need to verify public key of the ssh server
	            												// because the network is safe
	            session.setPassword(password);
	            session.connect(60000);//60 seconds per session
	            channelExec = (ChannelExec)session.openChannel("exec");//start a shell instance in server
		 }
		 catch(Exception e){
	            e.printStackTrace();
	        }
	 }
	 
	 public void CloseSessionSSH()
	 {
		 if (channelExec.isConnected())
			 channelExec.disconnect();
		 if (session.isConnected())
			 session.disconnect();
	 }
	 
			 
	 
	 public void ExecuteCommand(String cmd)
	 {
		 result.clear();
		 try{
			 	
	            InputStream in = channelExec.getInputStream();
	            channelExec.setCommand(cmd);
	            channelExec.connect();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	            String line;
	            while ((line = reader.readLine()) != null)//line receives one line of the results of the command
	            {											//and puts it the list
	                result.add(line);
	            }
	            channelExec.disconnect();
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        
	 }
	 
	 
	 
	 //getters and setters
	 

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public ChannelExec getChannelExec() {
		return channelExec;
	}

	public void setChannelExec(ChannelExec channelExec) {
		this.channelExec = channelExec;
	}

	public void setUser(String user) {
		this.user = user;
	}
	 public String getUser(){
    	 return user;
     }
	}
