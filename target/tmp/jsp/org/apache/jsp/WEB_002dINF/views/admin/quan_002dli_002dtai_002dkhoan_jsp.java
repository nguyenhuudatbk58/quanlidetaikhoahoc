/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.0.M0
 * Generated at: 2016-12-14 14:58:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class quan_002dli_002dtai_002dkhoan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("file:/C:/Users/aiemdat/.m2/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1466079086537L));
    _jspx_dependants.put("file:/C:/Users/aiemdat/.m2/repository/org/springframework/spring-webmvc/4.3.0.RELEASE/spring-webmvc-4.3.0.RELEASE.jar", Long.valueOf(1478185446258L));
    _jspx_dependants.put("jar:file:/C:/Users/aiemdat/.m2/repository/org/springframework/spring-webmvc/4.3.0.RELEASE/spring-webmvc-4.3.0.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1465522608000L));
    _jspx_dependants.put("jar:file:/C:/Users/aiemdat/.m2/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425953470000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>Tìm kiếm</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("  <link href=\"/assets/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"/assets/css/sb-admin.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"/assets/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    \t<div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("    \t\t<!-- Navigation -->\r\n");
      out.write("             ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layouts/navigation.jsp", out, false);
      out.write("<div id=\"page-wrapper\">\r\n");
      out.write("\r\n");
      out.write("    \t\t\t<div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("    \t\t\t\t<!-- Page Heading -->\r\n");
      out.write("    \t\t\t\t<div class=\"row\">\r\n");
      out.write("    \t\t\t\t\t<div class=\"col-lg-12\">\r\n");
      out.write("    \t\t\t\t\t\t<h1 class=\"page-header\">\r\n");
      out.write("    \t\t\t\t\t\t\tQuản lý tài khoản\r\n");
      out.write("    \t\t\t\t\t\t\t<a href=\"/quan-li/tao-tai-khoan\"><button type=\"button\" class=\"btn btn-lg btn-primary\">Cấp tài khoản mới</button></a>\r\n");
      out.write("    \t\t\t\t\t\t</h1>\r\n");
      out.write("\r\n");
      out.write("    \t\t\t\t\t</div>\r\n");
      out.write("    \t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("    \t\t\t\t<div class=\"col-lg-4\">\r\n");
      out.write("    \t\t\t\t\t<div class=\"form-group input-group\">\r\n");
      out.write("    \t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"dieuKienTimKiem\">\r\n");
      out.write("    \t\t\t\t\t\t<span class=\"input-group-btn\"><button class=\"btn btn-default form-control\" type=\"button\" id=\"searchBtn\"><i class=\"fa fa-search\"></i></button></span>\r\n");
      out.write("\r\n");
      out.write("    \t\t\t\t\t</div>\r\n");
      out.write("    \t\t\t\t</div>\r\n");
      out.write("    \t\t\t\t<div class=\"col-lg-12\">\r\n");
      out.write("\r\n");
      out.write("    \t\t\t\t\t<div class=\"table-responsive\">\r\n");
      out.write("    \t\t\t\t\t\t<table class=\"table table-bordered table-hover table-striped\">\r\n");
      out.write("    \t\t\t\t\t\t\t<thead>\r\n");
      out.write("    \t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<th><p align=\"center\">Mã tài khoản</p></th>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<th><p align=\"center\">Tên tài khoản</p></th>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<th><p align=\"center\">SĐT</p></th>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<th><p align=\"center\">Email</p></th>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<th><p align=\"center\">Tùy chọn</p></th>\r\n");
      out.write("    \t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("    \t\t\t\t\t\t\t</thead>\r\n");
      out.write("    \t\t\t\t\t\t\t<tbody align=\"center\" id=\"dsNguoiDung\">\r\n");
      out.write("    \t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td>1</td>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td>2013001</td>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td>Lê Văn Thắng</td>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t\t<a href=\"admin_read_info_acc.html\"><button type=\"button\" class=\"btn btn-sm btn-info\">Xem</button></a>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-sm btn-default\">Reset Mật khẩu</button>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-sm btn-danger\">Xóa</button>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("    \t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("    \t\t\t\t\t\t\t</tbody>\r\n");
      out.write("    \t\t\t\t\t\t</table>\r\n");
      out.write("    \t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-10\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"text-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul id=\"pagination\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("    \t\t\t</div>\r\n");
      out.write("    \t\t\t<!-- /.row -->\r\n");
      out.write("\r\n");
      out.write("    \t\t</div>\r\n");
      out.write("    \t\t<!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("    \t<!-- /#page-wrapper -->\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /#wrapper -->\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery -->\r\n");
      out.write("    <script src=\"/assets/js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap Core JavaScript -->\r\n");
      out.write("    <script src=\"/assets/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/assets/js/bootstrap-paginator.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script src=\"/assets/js/admin/danh-sach-tai-khoan.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
