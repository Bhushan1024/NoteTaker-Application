package com.project.notetaker.servlets;

import java.io.IOException;
import java.util.Date;

import org.apache.catalina.connector.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.notetaker.entities.Note;
import com.project.notetaker.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	public  UpdateServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			Session session=FactoryProvider.getFactory().openSession();
			Transaction transaction=session.beginTransaction();
			int noteId=Integer.parseInt(req.getParameter("noteId").trim());
			
			Note note=session.get(Note.class, noteId);
			
			note.setTitle(title);
			note.setContent(content);
			note.setAddedDate(new Date());
			
			transaction.commit();
			session.close();
			
			resp.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
