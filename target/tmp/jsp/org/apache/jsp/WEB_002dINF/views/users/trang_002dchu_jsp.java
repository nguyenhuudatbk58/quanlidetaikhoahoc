/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.0.M0
 * Generated at: 2016-12-18 15:27:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class trang_002dchu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Trang chủ</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"favicon.ico\" rel=\"shortcut icon\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/assets/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/assets/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/assets/css/animate.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/assets/css/font-awesome.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/assets/css/nexus.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/assets/css/responsive.css\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/assets/css/custom.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"http://fonts.googleapis.com/css?family=Roboto+Condensed:400,300\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"http://fonts.googleapis.com/css?family=PT+Sans\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"http://fonts.googleapis.com/css?family=Roboto:400,300\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("        <div id=\"body-bg\">\r\n");
      out.write("            <div id=\"header\">\r\n");
      out.write("                <a href=\"#\" title=\"\">\r\n");
      out.write("                    <img src=\"/assets/img/slideshow/slide3.jpg\" style=\"width: 100%; height:160px;\" />\r\n");
      out.write("                </a>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div id=\"post_header\" class=\"container\" style=\"height: 40px\">\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layouts/menu.jsp", out, false);
      out.write("<div id=\"content-top-border\" class=\"container\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- === END HEADER === -->\r\n");
      out.write("            <!-- === BEGIN CONTENT === -->\r\n");
      out.write("            <div id=\"content\">\r\n");
      out.write("                <div class=\"container background-white\">\r\n");
      out.write("                    <div class=\"row margin-vert-40\">\r\n");
      out.write("                        <!-- Begin Sidebar Menu -->\r\n");
      out.write("                        <!-- End Sidebar Menu -->\r\n");
      out.write("                         <div class=\"col-md-10 col-md-offset-1\">\r\n");
      out.write("                            <!-- Paragraph Examples -->\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-md-12\">\r\n");
      out.write("                                    <div class=\"headline\">\r\n");
      out.write("                                        <h2>Tin tức</h2>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <a href=\"detail_news.html\">\r\n");
      out.write("                                        <p class=\"lead\">Seminar: Một số phương pháp khai thác mẫu trên cơ sở dữ liệu định lượng</p>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                    <p><em>12/06/2016</em></p>\r\n");
      out.write("                                    <p><em>Khai thác luật kết hợp truyền thống chỉ quan tâm đến sự xuất hiện hay không xuất hiện của các item trong các giao dịch. Trong các cơ sở dữ liệu thực thường chứa các giá trị định lượng như số lượng mua, giá bán, v.v… Muốn áp dụng các phương pháp khai thác mẫu truyền thống, chúng ta phải chuyển dữ liệu về dạng nhị phân. <em> <u><a href=\"detail_news.html\" style=\"color: #0000FF \">Xem tiếp</a> </u></p>\r\n");
      out.write("                                    <hr>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix margin-bottom-10\"></div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-md-12\">\r\n");
      out.write("                                    <a href=\"#\">\r\n");
      out.write("                                        <p class=\"lead\">TS. Cao Tuấn Dũng được công nhận tiêu chuẩn chức danh Phó Giáo sư</p>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                    <p><em>12/10/2016</em></p>\r\n");
      out.write("                                    <p><em>Ngày 10/10/2016, Chủ tịch Hội đồng Chức danh Giáo sư Nhà nước đã ký Quyết định số 55/QĐ-HĐCDGSNN về việc công nhận đạt tiêu chuẩn chức danh GS, PGS năm 2016. TS. Cao Tuấn Dũng, Phó Viện trưởng, Giảng viên Bộ môn Công nghệ phần mềm, vinh dự được công nhận đủ tiêu chuẩn Phó Giáo sư đợt này. <em> <u><a href=\"#\" style=\"color: #0000FF \">Xem tiếp</a> </u></p>\r\n");
      out.write("                                    <hr>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix margin-bottom-10\"></div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-md-12\">\r\n");
      out.write("                                    <a href=\"#\">\r\n");
      out.write("                                        <p class=\"lead\">TS. Cao Tuấn Dũng được công nhận tiêu chuẩn chức danh Phó Giáo sư</p>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                    <p><em>12/10/2016</em></p>\r\n");
      out.write("                                    <p><em>Ngày 10/10/2016, Chủ tịch Hội đồng Chức danh Giáo sư Nhà nước đã ký Quyết định số 55/QĐ-HĐCDGSNN về việc công nhận đạt tiêu chuẩn chức danh GS, PGS năm 2016. TS. Cao Tuấn Dũng, Phó Viện trưởng, Giảng viên Bộ môn Công nghệ phần mềm, vinh dự được công nhận đủ tiêu chuẩn Phó Giáo sư đợt này. <em> <u><a href=\"#\" style=\"color: #0000FF \">Xem tiếp</a> </u></p>\r\n");
      out.write("\r\n");
      out.write("                                    <hr>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix margin-bottom-10\"></div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-md-12\">\r\n");
      out.write("                                    <a href=\"#\">\r\n");
      out.write("                                        <p class=\"lead\">TS. Cao Tuấn Dũng được công nhận tiêu chuẩn chức danh Phó Giáo sư</p>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                    <p><em>12/10/2016</em></p>\r\n");
      out.write("                                    <p><em>Ngày 10/10/2016, Chủ tịch Hội đồng Chức danh Giáo sư Nhà nước đã ký Quyết định số 55/QĐ-HĐCDGSNN về việc công nhận đạt tiêu chuẩn chức danh GS, PGS năm 2016. TS. Cao Tuấn Dũng, Phó Viện trưởng, Giảng viên Bộ môn Công nghệ phần mềm, vinh dự được công nhận đủ tiêu chuẩn Phó Giáo sư đợt này. <em> <u><a href=\"#\" style=\"color: #0000FF \">Xem tiếp</a> </u></p>\r\n");
      out.write("                                    <hr>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"clearfix margin-bottom-10\"></div>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"row\">\r\n");
      out.write("                                <div class=\"col-md-12\">\r\n");
      out.write("                                    <a href=\"#\">\r\n");
      out.write("                                        <p class=\"lead\">TS. Cao Tuấn Dũng được công nhận tiêu chuẩn chức danh Phó Giáo sư</p>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                    <p><em>12/10/2016</em></p>\r\n");
      out.write("                                    <p><em>Ngày 10/10/2016, Chủ tịch Hội đồng Chức danh Giáo sư Nhà nước đã ký Quyết định số 55/QĐ-HĐCDGSNN về việc công nhận đạt tiêu chuẩn chức danh GS, PGS năm 2016. TS. Cao Tuấn Dũng, Phó Viện trưởng, Giảng viên Bộ môn Công nghệ phần mềm, vinh dự được công nhận đủ tiêu chuẩn Phó Giáo sư đợt này. <em> <u><a href=\"#\" style=\"color: #0000FF \">Xem tiếp</a> </u></p>\r\n");
      out.write("                                    <hr>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- End Paragraph Examples -->\r\n");
      out.write("                            <div class=\"clearfix margin-bottom-10\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!-- Đánh số trang -->\r\n");
      out.write("                        <div class=\"text-right\">\r\n");
      out.write("                           <ul class=\"pagination\">\r\n");
      out.write("                               <li><a href=\"#\">&laquo;</a></li>\r\n");
      out.write("                               <li><a href=\"#\">1</a></li>\r\n");
      out.write("                               <li class=\"active\"><a href=\"#\">2</a></li>\r\n");
      out.write("                               <li><a href=\"#\">3</a></li>\r\n");
      out.write("                               <li><a href=\"#\">4</a></li>\r\n");
      out.write("                               <li><a href=\"#\">&raquo;</a></li>\r\n");
      out.write("                           </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <!-- Kết thúc đánh số trang -->\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layouts/footer.jsp", out, false);
      out.write("</div>\r\n");
      out.write("            <!-- JS -->\r\n");
      out.write("            <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js\"></script>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"/assets/js/jquery.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"/assets/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"/assets/js/scripts.js\"></script>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"/assets/js/jquery.isotope.js\" type=\"text/javascript\"></script>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"/assets/js/jquery.slicknav.js\" type=\"text/javascript\"></script>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"/assets/js/jquery.visible.js\" charset=\"utf-8\"></script>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"/assets/js/jquery.sticky.js\" charset=\"utf-8\"></script>\r\n");
      out.write("            <script type=\"text/javascript\" src=\"/assets/js/slimbox2.js\" charset=\"utf-8\"></script>\r\n");
      out.write("            <script src=\"/assets/js/modernizr.custom.js\" type=\"text/javascript\"></script>\r\n");
      out.write("            <script src=\"/assets/js/admin/app.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    </body>\r\n");
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
