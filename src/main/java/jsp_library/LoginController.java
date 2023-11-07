package jsp_library;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginp")
public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");

		String password = req.getParameter("password");

		Employee employee = new Employee();

		employee.setEmail(email);
		employee.setPassword(password);

		EmployeeCRUD crud = new EmployeeCRUD();
		Book book = new Book();
		try {

			String dpPassword = crud.login(employee);
			List<Book> books = crud.display();

			req.setAttribute("booksList", books);
			if (password.equals(dpPassword)) {

				RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req, resp);

			} else {
//						printWriter.print("logins failed");
				req.setAttribute("failed", "Plz enter correct credentionals");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");

				dispatcher.include(req, resp);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
