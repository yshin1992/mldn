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