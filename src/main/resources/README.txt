1.配置全局session有效期<session-config />
2.配置全局错误页面<error-page />
3.配置servlet <servlet /> <servlet-mapping /> 代码参见 org.ysh.servlet.bussiness
4.配置filter <filter /> 代码参见 org.ysh.filter.AccessFilter和CharacterEncodingFilter
5.filter中配置param <init-param />
6.上传组件smartupload 参见代码 org.ysh.servlet.business.UploadServlet
7.上传组件commonUpload 参见代码org.ysh.servlet.business.CommonUploadServlet
8.显示图片及url附带参数乱码解决 org.ysh.servlet.business.ShowPicServlet
9.listener 之 ServletContextListener 见代码 org.ysh.listener.MLDNServletContextListener
10.listener 之 ServletContextAttributeListener 见代码 org.ysh.listener.MLDNContextAttributeListener
11.listener 之 HttpSessionListener,HttpSessionAttributeListener 见代码org.ysh.listener.MLDNSessionListener
12.listener 之 HttpSessionBindingListener 见代码org.ysh.domain.LoginUser
13.listener 之 ServletRequestListener,ServletRequestAttributeListener 见代码 org.ysh.listener.MLDNRequestAttributeListener,MLDNRequestListener
13.EL表达式调用内置对象pageScope,requestScope,sessionScope,applicationScope
14.EL表达式调用内置对象pageContext,param,paramValues,header,headerValues,cookie,initParam
15.EL表达式中集合的取值
16.EL表达式运算符 + - * /(div) %(mod) ==(eq) <(lt) <=(le) >(gt) >=(ge) !=(ne) &&(and) ||(or) !(not) empty ?: ()
17.Tomcat数据源
18.自定义标签的使用 
19.带有body的自定义标签的使用
20.迭代标签的定义及使用doAfterBody()
21.TagExtraInfo类和VariableInfo类的使用
22.SimpleTagSupport的使用 注意body-content中设置为JSP时，对使用SimpleTagSupport的标签类是无效的，需使用scriptless替代
23.DynamicAtrributes接口的使用
24.jstl标签库 <c:out> <c:set> <c:remove> <c:choose><c:when><c:otherwise> <c:forEach> <c:forTokens>
25.jstl国际化标签库 <fmt:setLocale> <fmt:requestEncoding> <fmt:bundle>  <fmt:message> <fmt:setBundle>
26.jstl数字格式化标签 <fmt:formatNumber> <fmt:parseNumber> <fmt:formatDate> <fmt:parseDate>
27.jstlSQL标签库 <sql:setDataSource> <sql:query> <sql:update> <sql:transaction>
28.jstlXML解析标签库 <x:parse> <x:out> <x:if> <x:choose><x:when><x:otherwise> <x:forEach>
29.jstl函数标签库 fn
30.Ajax技术
31.JavaMail 邮件发送