import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//put the entries of HomePage.jsp in strings
		String host = request.getParameter("host");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		//tries to open a session with server
		SSH ssh = new SSH(user, password, host);
		ssh.OpenSessionSSH();
		
		//if the creation fails ----> error.htmf
		if (!ssh.getSession().isConnected())
		{
			this.getServletContext().getRequestDispatcher("/Error.html").forward(request, response);

		}
		//if creation succeds ----> scriptshell.jsp ----->write the command
		else{
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("ssh", ssh);// put our successful ssh connection in a httpsession to conserve it  
		
		this.getServletContext().getRequestDispatcher("/ScriptShell.jsp").forward(request, response);
		  }
	}
		  
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
