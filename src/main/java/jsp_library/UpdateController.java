package jsp_library;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")

public class UpdateController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		EmployeeCRUD crud = new EmployeeCRUD();

		try {
			Book book = crud.find(id);

			req.setAttribute("books", book);
			RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
			dispatcher.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
