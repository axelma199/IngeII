package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class prueba_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write(" \n");
      out.write(" \n");
      out.write(" \n");
      out.write(" \n");
      out.write(" \n");
      out.write(" \n");
      out.write(" \n");
      out.write("<form action=\"EnviarMailConfirmacion\" method=\"post\">\n");
      out.write("<table align=\"center\" border=\"0\"><tbody>\n");
      out.write("<tr><td align=\"left\" width=\"100\">Nombres:</td>  <td align=\"center\" width=\"150\"><input gtbfieldid=\"103\" maxlength=\"25\" name=\"nombre\" type=\"TEXT\"></td>  </tr>\n");
      out.write("<tr>  <td align=\"left\" width=\"100\">Usuario:</td>  <td align=\"center\" width=\"150\"><input gtbfieldid=\"104\" maxlength=\"25\" name=\"usuario\" type=\"TEXT\"></td>  </tr>\n");
      out.write("<tr>  <td align=\"left\" width=\"100\">Contraseña:</td>  <td align=\"center\" width=\"150\"><input maxlength=\"25\" name=\"contra\" type=\"password\"></td>  </tr>\n");
      out.write("<tr>  <td align=\"left\" width=\"100\">Email:</td>  <td align=\"center\" width=\"150\"><input gtbfieldid=\"105\" maxlength=\"25\" name=\"mail\" type=\"TEXT\"></td>  </tr>\n");
      out.write("<tr>  <td widht=\"100\"></td>  <td align=\"right\" width=\"150\"><input maxlength=\"25\" name=\"boton\" type=\"button\" value=\"Enviar\"></td>   </tr>\n");
      out.write("</tbody></table>\n");
      out.write("</form>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
