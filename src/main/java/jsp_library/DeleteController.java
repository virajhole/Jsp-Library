package jsp_library;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		EmployeeCRUD crud = new EmployeeCRUD();

		try {

			int result = crud.delete(id);

			if (result != 0) {
				List<Book> book = crud.display();

				req.setAttribute("booksList", book);

				RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req, resp);
			} else {

				RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				dispatcher.forward(req, resp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
