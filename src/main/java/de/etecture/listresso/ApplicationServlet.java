package de.etecture.listresso;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import de.etecture.listresso.ui.ListressoUI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/*", name = "ApplicationServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = ListressoUI.class, productionMode = false)
public class ApplicationServlet extends VaadinServlet{

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();

        this.getService().addSessionInitListener(new ApplicationSessioninitializer());
    }
}
