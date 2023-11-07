package jsp_library;
 

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setEmail(email);
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setPassword(password);

		EmployeeCRUD crud = new EmployeeCRUD();

		try {
			int result = crud.signUp(employee);

			if (result != 0) {
				req.setAttribute("message", "SignUp Successfully, plz login");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);

			} else {

//				printWriter.print("Registration failed! ");
				RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");

				dispatcher.include(req, resp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
