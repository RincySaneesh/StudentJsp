package com.example;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.io.IOException;
import java.util.List;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    public void init() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            // Validate login credentials
            String sql = "FROM Login WHERE username = :username AND password = :password";
            Query<Login> query = session.createQuery(sql, Login.class);
            query.setParameter("username", uname);
            query.setParameter("password", pass);

            Login user = query.uniqueResult();
            tx.commit();

            if (user != null) {
                // Retrieve student data
                Query<StudentTable> studentQuery = session.createQuery("FROM Student", StudentTable.class);
                List<StudentTable> student = studentQuery.getResultList();

                HttpSession httpsession = request.getSession();
                httpsession.setAttribute("username", uname);
                httpsession.setAttribute("student", student);  // Pass student list to the session
                response.sendRedirect("welcome.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}