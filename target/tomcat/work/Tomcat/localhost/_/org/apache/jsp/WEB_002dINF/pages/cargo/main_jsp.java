/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-01-14 06:19:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.cargo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/pages/cargo/../base.jsp", Long.valueOf(1483926610192L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/skin/default/css/default.css\" media=\"all\"/>\r\n");
      out.write("<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/skin/default/css/button.css\" media=\"all\"/>\r\n");
      out.write("<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/skin/default/css/table.css\" media=\"all\"/>\r\n");
      out.write("<script language=\"javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/js/common.js\"></script>");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>模块介绍</title>\r\n");
      out.write("  \t<link rel=\"stylesheet\" rev=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/staticfile/skin/default/css/main.css\" media=\"all\"/>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<form>\r\n");
      out.write("<div class=\"textbox\"></div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"modelDiv\">\r\n");
      out.write("\r\n");
      out.write("        <table class=\"modelTable\" cellspacing=\"1\">\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t\t<td colspan=\"2\" class=\"modelTitle\">货运模块介绍</td>\r\n");
      out.write("        \t</tr>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t\t<td class=\"subModelTitle\">购销合同</td>\r\n");
      out.write("        \t\t<td class=\"model_intro_right\">客户签单后，公司向厂家下达购销合同，包括货物的具体要求和交期。合同按不同厂家打印购销合同单，附件单独打印，由公司驻当地销售人员分发到各工厂。<br>\r\n");
      out.write("\t\t\t\t归档：标识彻底完成的项目，方便统计。在报运时也不能在选这些合同。<br>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("        \t</tr>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t\t<td class=\"subModelTitle\">出货表</td>\r\n");
      out.write("        \t\t<td class=\"model_intro_right\">根据合同和指定的船期月份，统计当月的出货情况。<br></td>\r\n");
      out.write("        \t</tr>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t\t<td class=\"subModelTitle\">出口报运单</td>\r\n");
      out.write("        \t\t<td class=\"model_intro_right\">根据购销合同制定出口商品报运单。报运时可以将多个购销合同形成一单报运；也可以只走部分货物。<br>\r\n");
      out.write("        \t\t分批走货：合同可以多个一起报运; 而一个合同可以分多次走货; 根据合同和合同货物的走货状态可以查看合同的走货情况。\r\n");
      out.write("        \t\t<!-- 修改走货状态：1)合同新增货物、修改货物 2)报运货物修改、删除货物、增补货物、删除报运 -->\r\n");
      out.write("        \t\t</td>\r\n");
      out.write("        \t</tr>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t\t<td class=\"subModelTitle\">HOME装箱单</td>\r\n");
      out.write("        \t\t<td class=\"model_intro_right\">根据出口报运单制定HOME装箱单，先制作HOME装箱单给客户看，客人同意，则直接制定相应装箱单；如有调整，则重新复制修改出口报运单，可能拆成多个报运。<br></td>\r\n");
      out.write("        \t</tr>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t\t<td class=\"subModelTitle\">装箱单</td>\r\n");
      out.write("        \t\t<td class=\"model_intro_right\">根据出口报运单制定装箱单，填写发票号、发票时间，以及客人等相关信息。<br></td>\r\n");
      out.write("        \t</tr>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t\t<td class=\"subModelTitle\">委托书</td>\r\n");
      out.write("        \t\t<td class=\"model_intro_right\">根据装箱制定海运或空运委托书。<br></td>\r\n");
      out.write("        \t</tr>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t\t<td class=\"subModelTitle\">发票</td>\r\n");
      out.write("        \t\t<td class=\"model_intro_right\">根据装箱制定发票。<br></td>\r\n");
      out.write("        \t</tr>\r\n");
      out.write("        \t<tr>\r\n");
      out.write("        \t\t<td class=\"subModelTitle\" nowrap>财务出口报运单</td>\r\n");
      out.write("        \t\t<td class=\"model_intro_right\">根据报运制定财务出口报运单。<br></td>\r\n");
      out.write("        \t</tr> \t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tfoot>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" class=\"tableFooter\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tfoot>\r\n");
      out.write("        </table>\r\n");
      out.write(" \r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/pages/cargo/../base.jsp(3,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/pages/cargo/../base.jsp(3,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/pages/cargo/../base.jsp(3,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
