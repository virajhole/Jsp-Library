package jsp_library;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editp")
public class EditController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String author = req.getParameter("author");
		int price = Integer.parseInt(req.getParameter("price"));
		String gener = req.getParameter("gener");

		Book book= new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		book.setPrice(price);
		book.setGener(gener);
		 

		EmployeeCRUD crud = new EmployeeCRUD();

		try {
			int result = crud.update(book);

			if (result != 0) {
//				req.setAttribute("message", "Update Successfully");
				List<Book> books= crud.display();

				req.setAttribute("booksList", books);
				RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
				dispatcher.forward(req, resp);

			} else {

//				printWriter.print("Registration failed! ");
				RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");

				dispatcher.include(req, resp);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
