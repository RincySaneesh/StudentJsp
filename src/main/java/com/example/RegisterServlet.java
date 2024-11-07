package com.example;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.IOException;

@WebServlet("/addStudent")
public class RegisterServlet extends  HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    public void init() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int serialno = Integer.parseInt(request.getParameter("serialno"));
        String name = request.getParameter("name");
        int rollno = Integer.parseInt(request.getParameter("rollno"));
        String department = request.getParameter("department");

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Register register = new Register(serialno, name, rollno, department);
            session.save(register);
            tx.commit();
            response.sendRedirect("welcome.jsp");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            response.sendRedirect("addStudent.jsp");
        } finally {
            session.close();
        }
    }
}