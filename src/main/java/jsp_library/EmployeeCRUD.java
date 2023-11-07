package jsp_library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCRUD {

	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?user=root&password=root");
		return connection;
	}

	public int signUp(Employee employee) throws Exception {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());

		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

	public String login(Employee employee) throws Exception {

		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT PASSWORD FROM employee WHERE EMAIL=?");

		preparedStatement.setString(1, employee.getEmail());

		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString("password");

		}
		connection.close();
		return password;
	}

	public List<Book> display() throws Exception {
		Connection con = getConnection();

		PreparedStatement preparedStatement = con.prepareStatement("select * from books");

		ResultSet resultSet = preparedStatement.executeQuery();
		List<Book> list = new ArrayList<Book>();
		while (resultSet.next()) {
			Book book = new Book();
			book.setId(resultSet.getInt("id"));
			book.setName(resultSet.getString("name"));
			book.setAuthor(resultSet.getString("author"));
			book.setPrice(resultSet.getInt("price"));
			book.setGener(resultSet.getString("gener"));

			list.add(book);

		}
		con.close();
		return list;
	}

	public int delete(int id) throws Exception {
		Connection con = getConnection();

		PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM books WHERE ID=?");
		preparedStatement.setInt(1, id);
		int count = preparedStatement.executeUpdate();

		return count;
	}

	public Book find(int id) throws Exception {
		Connection con = getConnection();

		PreparedStatement preparedStatement = con.prepareStatement("select * from books where id=?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		Book book = new Book();
		while (resultSet.next()) {

			book.setId(resultSet.getInt("id"));
			book.setName(resultSet.getString("name"));
			book.setAuthor(resultSet.getString("author"));
			book.setPrice(resultSet.getInt("price"));
			book.setGener(resultSet.getString("gener"));

		}
		con.close();
		return book;

	}

	public int update(Book book) throws Exception {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection
				.prepareStatement("UPDATE BOOKS SET name=?,author=?,price=?,gener=? WHERE ID=?");

		preparedStatement.setString(1, book.getName());
		preparedStatement.setString(2, book.getAuthor());
		preparedStatement.setInt(3, book.getPrice());
		preparedStatement.setString(4, book.getGener());
		preparedStatement.setInt(5, book.getId());

		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	}

	public int addBook(Book book) throws Exception {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, book.getId());
		preparedStatement.setString(2, book.getName());
		preparedStatement.setString(3, book.getAuthor());
		preparedStatement.setInt(4, book.getPrice());
		preparedStatement.setString(5, book.getGener());

		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;

	}
}
