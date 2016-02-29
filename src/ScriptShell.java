import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScriptShell
 */
@WebServlet("/ScriptShell")
public class ScriptShell extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ScriptShell() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
		SSH ssh = (SSH)httpSession.getAttribute("ssh");//return the successful ssh connection
		if (!ssh.getSession().isConnected())
		{
			ssh.OpenSessionSSH();
		}
		String command = request.getParameter("command");//take shell command written by user
		
		ssh.ExecuteCommand(command);//
		httpSession.setAttribute("ssh", ssh);//put the connection in a httpsession
		
		request.setAttribute("result", ssh.getResult());//put results in a the request object sothat they can be
														//shown in ScriptShell.jsp
		ssh.CloseSessionSSH();//close connection when results received 
		this.getServletContext().getRequestDispatcher("/ScriptShell.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
