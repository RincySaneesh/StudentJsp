package com.example;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.IOException;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
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
            String sql = "FROM login WHERE username = :username AND password = :password";
            Query<Login> query = session.createQuery(sql,Login.class);
            query.setParameter("username", uname);
            query.setParameter("password", pass);

            Login user = query.uniqueResult();
            tx.commit();

            if (user != null) {
                HttpSession httpsession = request.getSession();
                httpsession.setAttribute("username", uname);
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