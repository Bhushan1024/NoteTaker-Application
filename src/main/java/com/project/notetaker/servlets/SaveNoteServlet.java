package com.project.notetaker.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.project.notetaker.entities.Note;
import com.project.notetaker.helper.FactoryProvider;

public class SaveNoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public SaveNoteServlet() {
		super();
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String title = req.getParameter("title");
			String content = req.getParameter("content");

			Note note = new Note(title, content, new Date());
			//System.out.println(note.getId() + " : " + note.getTitle());
			
			//hibernate.save()
			
			Session session= FactoryProvider.getFactory().openSession();
			Transaction transaction=session.beginTransaction();
			session.save(note);
			transaction.commit();
			session.close();
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<h1 style='text-align:center;'>Note is added Successfully.</h1>");
			out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View All Notes</a></h1>");
			} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	



}
