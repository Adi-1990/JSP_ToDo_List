package ro.sda.service;

import ro.sda.model.Task;
import ro.sda.model.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.Optional;

public class ToDoService extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String action = request.getParameter("actionName");
        Optional<Task> toDoItem = TaskRepository.getInstance().findToDoItem(action);
        toDoItem.ifPresent(item -> item.setChecked(!item.isChecked()));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String action = request.getParameter("actionName");
        TaskRepository.getInstance().addTask(Task.newtask().checked(false).taskName(action).build());
        resp.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}