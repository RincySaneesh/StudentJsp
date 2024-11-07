package com.example;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;

@WebServlet("/edit")
public class Update extends HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    public void init() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve data from the form
        int id = Integer.parseInt(request.getParameter("id"));
        int serialno = Integer.parseInt(request.getParameter("SerialNo"));
        String name = request.getParameter("name");
        int rollNo = Integer.parseInt(request.getParameter("rollno"));
        String department = request.getParameter("department");

        // Open a session and start a transaction to update the student
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            // Retrieve the existing student record
            Register register = session.get(Register.class, id);
            if (register != null) {
                register.setSerialno(serialno);
                register.setName(name);
                register.setRoll(rollNo);
                register.setDepartment(department);

                // Update the student in the database
                session.update(register);
                tx.commit();

                response.sendRedirect("welcome.jsp"); // Redirect to confirmation page
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

    @Override
    public void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
