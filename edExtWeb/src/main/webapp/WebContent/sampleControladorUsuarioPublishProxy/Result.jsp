<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorUsuarioPublishProxyid" scope="session" class="publicadores.ControladorUsuarioPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorUsuarioPublishProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleControladorUsuarioPublishProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleControladorUsuarioPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorUsuarioPublish getControladorUsuarioPublish10mtemp = sampleControladorUsuarioPublishProxyid.getControladorUsuarioPublish();
if(getControladorUsuarioPublish10mtemp == null){
%>
<%=getControladorUsuarioPublish10mtemp %>
<%
}else{
        if(getControladorUsuarioPublish10mtemp!= null){
        String tempreturnp11 = getControladorUsuarioPublish10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        java.lang.String[] listarInstituto13mtemp = sampleControladorUsuarioPublishProxyid.listarInstituto();
if(listarInstituto13mtemp == null){
%>
<%=listarInstituto13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(listarInstituto13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(listarInstituto13mtemp);
        tempreturnp14 = listreturnp14.toString();
        }
        %>
        <%=tempreturnp14%>
        <%
}
break;
case 16:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg019");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        String arg1_2id=  request.getParameter("arg121");
            java.lang.String arg1_2idTemp = null;
        if(!arg1_2id.equals("")){
         arg1_2idTemp  = arg1_2id;
        }
        String arg2_3id=  request.getParameter("arg223");
            java.lang.String arg2_3idTemp = null;
        if(!arg2_3id.equals("")){
         arg2_3idTemp  = arg2_3id;
        }
        String arg3_4id=  request.getParameter("arg325");
            java.lang.String arg3_4idTemp = null;
        if(!arg3_4id.equals("")){
         arg3_4idTemp  = arg3_4id;
        }
        String arg4_5id=  request.getParameter("arg427");
            java.util.Calendar arg4_5idTemp = null;
        if(!arg4_5id.equals("")){
        java.text.DateFormat dateFormatarg427 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg427  = dateFormatarg427.parse(arg4_5id);
         arg4_5idTemp = new java.util.GregorianCalendar();
        arg4_5idTemp.setTime(dateTemparg427);
        }
        String arg5_6id=  request.getParameter("arg529");
            java.lang.String arg5_6idTemp = null;
        if(!arg5_6id.equals("")){
         arg5_6idTemp  = arg5_6id;
        }
        String arg6_7id=  request.getParameter("arg631");
            java.lang.String arg6_7idTemp = null;
        if(!arg6_7id.equals("")){
         arg6_7idTemp  = arg6_7id;
        }
        String arg7_8id=  request.getParameter("arg733");
            java.lang.String arg7_8idTemp = null;
        if(!arg7_8id.equals("")){
         arg7_8idTemp  = arg7_8id;
        }
        sampleControladorUsuarioPublishProxyid.altaUsuario(arg0_1idTemp,arg1_2idTemp,arg2_3idTemp,arg3_4idTemp,arg4_5idTemp,arg5_6idTemp,arg6_7idTemp,arg7_8idTemp);
break;
case 35:
        gotMethod = true;
        publicadores.DtUsuario[] listarDTUsuarios35mtemp = sampleControladorUsuarioPublishProxyid.listarDTUsuarios();
if(listarDTUsuarios35mtemp == null){
%>
<%=listarDTUsuarios35mtemp %>
<%
}else{
        String tempreturnp36 = null;
        if(listarDTUsuarios35mtemp != null){
        java.util.List listreturnp36= java.util.Arrays.asList(listarDTUsuarios35mtemp);
        tempreturnp36 = listreturnp36.toString();
        }
        %>
        <%=tempreturnp36%>
        <%
}
break;
case 38:
        gotMethod = true;
        java.lang.String[] listarUsuarios38mtemp = sampleControladorUsuarioPublishProxyid.listarUsuarios();
if(listarUsuarios38mtemp == null){
%>
<%=listarUsuarios38mtemp %>
<%
}else{
        String tempreturnp39 = null;
        if(listarUsuarios38mtemp != null){
        java.util.List listreturnp39= java.util.Arrays.asList(listarUsuarios38mtemp);
        tempreturnp39 = listreturnp39.toString();
        }
        %>
        <%=tempreturnp39%>
        <%
}
break;
case 41:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg056");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        publicadores.DtUsuario verInfoUsuario41mtemp = sampleControladorUsuarioPublishProxyid.verInfoUsuario(arg0_9idTemp);
if(verInfoUsuario41mtemp == null){
%>
<%=verInfoUsuario41mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(verInfoUsuario41mtemp != null){
java.lang.String typenick44 = verInfoUsuario41mtemp.getNick();
        String tempResultnick44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick44));
        %>
        <%= tempResultnick44 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(verInfoUsuario41mtemp != null){
java.util.Calendar typefechaNac46 = verInfoUsuario41mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac46 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac46 = typefechaNac46.getTime();
        String tempResultfechaNac46 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac46.format(datefechaNac46));
        %>
        <%= tempResultfechaNac46 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">correo:</TD>
<TD>
<%
if(verInfoUsuario41mtemp != null){
java.lang.String typecorreo48 = verInfoUsuario41mtemp.getCorreo();
        String tempResultcorreo48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecorreo48));
        %>
        <%= tempResultcorreo48 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(verInfoUsuario41mtemp != null){
java.lang.String typeimage50 = verInfoUsuario41mtemp.getImage();
        String tempResultimage50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimage50));
        %>
        <%= tempResultimage50 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario41mtemp != null){
java.lang.String typeapellido52 = verInfoUsuario41mtemp.getApellido();
        String tempResultapellido52 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido52));
        %>
        <%= tempResultapellido52 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario41mtemp != null){
java.lang.String typenombre54 = verInfoUsuario41mtemp.getNombre();
        String tempResultnombre54 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre54));
        %>
        <%= tempResultnombre54 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 58:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg061");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        String arg1_11id=  request.getParameter("arg163");
            java.lang.String arg1_11idTemp = null;
        if(!arg1_11id.equals("")){
         arg1_11idTemp  = arg1_11id;
        }
        String arg2_12id=  request.getParameter("arg265");
            java.lang.String arg2_12idTemp = null;
        if(!arg2_12id.equals("")){
         arg2_12idTemp  = arg2_12id;
        }
        String arg3_13id=  request.getParameter("arg367");
            java.util.Calendar arg3_13idTemp = null;
        if(!arg3_13id.equals("")){
        java.text.DateFormat dateFormatarg367 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg367  = dateFormatarg367.parse(arg3_13id);
         arg3_13idTemp = new java.util.GregorianCalendar();
        arg3_13idTemp.setTime(dateTemparg367);
        }
        sampleControladorUsuarioPublishProxyid.nuevosDatos(arg0_10idTemp,arg1_11idTemp,arg2_12idTemp,arg3_13idTemp);
break;
case 69:
        gotMethod = true;
        String arg0_14id=  request.getParameter("arg072");
            java.lang.String arg0_14idTemp = null;
        if(!arg0_14id.equals("")){
         arg0_14idTemp  = arg0_14id;
        }
        sampleControladorUsuarioPublishProxyid.altaCategoria(arg0_14idTemp);
break;
case 74:
        gotMethod = true;
        String arg0_15id=  request.getParameter("arg077");
            java.lang.String arg0_15idTemp = null;
        if(!arg0_15id.equals("")){
         arg0_15idTemp  = arg0_15id;
        }
        sampleControladorUsuarioPublishProxyid.altaInstituto(arg0_15idTemp);
break;
case 79:
        gotMethod = true;
        String arg0_16id=  request.getParameter("arg082");
            java.lang.String arg0_16idTemp = null;
        if(!arg0_16id.equals("")){
         arg0_16idTemp  = arg0_16id;
        }
        publicadores.DtInscripcionED[] listarInscripcionesED79mtemp = sampleControladorUsuarioPublishProxyid.listarInscripcionesED(arg0_16idTemp);
if(listarInscripcionesED79mtemp == null){
%>
<%=listarInscripcionesED79mtemp %>
<%
}else{
        String tempreturnp80 = null;
        if(listarInscripcionesED79mtemp != null){
        java.util.List listreturnp80= java.util.Arrays.asList(listarInscripcionesED79mtemp);
        tempreturnp80 = listreturnp80.toString();
        }
        %>
        <%=tempreturnp80%>
        <%
}
break;
case 84:
        gotMethod = true;
        java.lang.String[] listarEstudiantesAux84mtemp = sampleControladorUsuarioPublishProxyid.listarEstudiantesAux();
if(listarEstudiantesAux84mtemp == null){
%>
<%=listarEstudiantesAux84mtemp %>
<%
}else{
        String tempreturnp85 = null;
        if(listarEstudiantesAux84mtemp != null){
        java.util.List listreturnp85= java.util.Arrays.asList(listarEstudiantesAux84mtemp);
        tempreturnp85 = listreturnp85.toString();
        }
        %>
        <%=tempreturnp85%>
        <%
}
break;
case 87:
        gotMethod = true;
        String arg0_17id=  request.getParameter("arg090");
            java.lang.String arg0_17idTemp = null;
        if(!arg0_17id.equals("")){
         arg0_17idTemp  = arg0_17id;
        }
        String arg1_18id=  request.getParameter("arg192");
            java.lang.String arg1_18idTemp = null;
        if(!arg1_18id.equals("")){
         arg1_18idTemp  = arg1_18id;
        }
        boolean validarUsuario87mtemp = sampleControladorUsuarioPublishProxyid.validarUsuario(arg0_17idTemp,arg1_18idTemp);
        String tempResultreturnp88 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarUsuario87mtemp));
        %>
        <%= tempResultreturnp88 %>
        <%
break;
case 94:
        gotMethod = true;
        String arg0_19id=  request.getParameter("arg097");
            java.lang.String arg0_19idTemp = null;
        if(!arg0_19id.equals("")){
         arg0_19idTemp  = arg0_19id;
        }
        String arg1_20id=  request.getParameter("arg199");
            java.lang.String arg1_20idTemp = null;
        if(!arg1_20id.equals("")){
         arg1_20idTemp  = arg1_20id;
        }
        boolean validarSeguidor94mtemp = sampleControladorUsuarioPublishProxyid.validarSeguidor(arg0_19idTemp,arg1_20idTemp);
        String tempResultreturnp95 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarSeguidor94mtemp));
        %>
        <%= tempResultreturnp95 %>
        <%
break;
case 101:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0104");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        String arg1_22id=  request.getParameter("arg1106");
            java.lang.String arg1_22idTemp = null;
        if(!arg1_22id.equals("")){
         arg1_22idTemp  = arg1_22id;
        }
        java.lang.String inscriptoED101mtemp = sampleControladorUsuarioPublishProxyid.inscriptoED(arg0_21idTemp,arg1_22idTemp);
if(inscriptoED101mtemp == null){
%>
<%=inscriptoED101mtemp %>
<%
}else{
        String tempResultreturnp102 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(inscriptoED101mtemp));
        %>
        <%= tempResultreturnp102 %>
        <%
}
break;
case 108:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0111");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        String arg1_24id=  request.getParameter("arg1113");
            java.lang.String arg1_24idTemp = null;
        if(!arg1_24id.equals("")){
         arg1_24idTemp  = arg1_24id;
        }
        boolean validarSigue108mtemp = sampleControladorUsuarioPublishProxyid.validarSigue(arg0_23idTemp,arg1_24idTemp);
        String tempResultreturnp109 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarSigue108mtemp));
        %>
        <%= tempResultreturnp109 %>
        <%
break;
case 115:
        gotMethod = true;
        String arg0_25id=  request.getParameter("arg0118");
            java.lang.String arg0_25idTemp = null;
        if(!arg0_25id.equals("")){
         arg0_25idTemp  = arg0_25id;
        }
        java.lang.String[] listarSeguidos115mtemp = sampleControladorUsuarioPublishProxyid.listarSeguidos(arg0_25idTemp);
if(listarSeguidos115mtemp == null){
%>
<%=listarSeguidos115mtemp %>
<%
}else{
        String tempreturnp116 = null;
        if(listarSeguidos115mtemp != null){
        java.util.List listreturnp116= java.util.Arrays.asList(listarSeguidos115mtemp);
        tempreturnp116 = listreturnp116.toString();
        }
        %>
        <%=tempreturnp116%>
        <%
}
break;
case 120:
        gotMethod = true;
        String arg0_26id=  request.getParameter("arg0123");
            java.lang.String arg0_26idTemp = null;
        if(!arg0_26id.equals("")){
         arg0_26idTemp  = arg0_26id;
        }
        String arg1_27id=  request.getParameter("arg1125");
            java.lang.String arg1_27idTemp = null;
        if(!arg1_27id.equals("")){
         arg1_27idTemp  = arg1_27id;
        }
        String arg2_28id=  request.getParameter("arg2127");
            java.lang.String arg2_28idTemp = null;
        if(!arg2_28id.equals("")){
         arg2_28idTemp  = arg2_28id;
        }
        sampleControladorUsuarioPublishProxyid.cambiarInscripcion(arg0_26idTemp,arg1_27idTemp,arg2_28idTemp);
break;
case 129:
        gotMethod = true;
        String arg0_29id=  request.getParameter("arg0132");
            java.lang.String arg0_29idTemp = null;
        if(!arg0_29id.equals("")){
         arg0_29idTemp  = arg0_29id;
        }
        String arg1_30id=  request.getParameter("arg1134");
            java.lang.String arg1_30idTemp = null;
        if(!arg1_30id.equals("")){
         arg1_30idTemp  = arg1_30id;
        }
        boolean inscriptoPF129mtemp = sampleControladorUsuarioPublishProxyid.inscriptoPF(arg0_29idTemp,arg1_30idTemp);
        String tempResultreturnp130 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(inscriptoPF129mtemp));
        %>
        <%= tempResultreturnp130 %>
        <%
break;
case 136:
        gotMethod = true;
        String arg0_31id=  request.getParameter("arg0139");
            java.lang.String arg0_31idTemp = null;
        if(!arg0_31id.equals("")){
         arg0_31idTemp  = arg0_31id;
        }
        java.lang.String[] listarSeguidores136mtemp = sampleControladorUsuarioPublishProxyid.listarSeguidores(arg0_31idTemp);
if(listarSeguidores136mtemp == null){
%>
<%=listarSeguidores136mtemp %>
<%
}else{
        String tempreturnp137 = null;
        if(listarSeguidores136mtemp != null){
        java.util.List listreturnp137= java.util.Arrays.asList(listarSeguidores136mtemp);
        tempreturnp137 = listreturnp137.toString();
        }
        %>
        <%=tempreturnp137%>
        <%
}
break;
case 141:
        gotMethod = true;
        String arg0_32id=  request.getParameter("arg0144");
            java.lang.String arg0_32idTemp = null;
        if(!arg0_32id.equals("")){
         arg0_32idTemp  = arg0_32id;
        }
        String arg1_33id=  request.getParameter("arg1146");
            java.lang.String arg1_33idTemp = null;
        if(!arg1_33id.equals("")){
         arg1_33idTemp  = arg1_33id;
        }
        sampleControladorUsuarioPublishProxyid.dejarDeSeguir(arg0_32idTemp,arg1_33idTemp);
break;
case 148:
        gotMethod = true;
        String arg0_34id=  request.getParameter("arg0151");
            java.lang.String arg0_34idTemp = null;
        if(!arg0_34id.equals("")){
         arg0_34idTemp  = arg0_34id;
        }
        String arg1_35id=  request.getParameter("arg1153");
            java.lang.String arg1_35idTemp = null;
        if(!arg1_35id.equals("")){
         arg1_35idTemp  = arg1_35id;
        }
        sampleControladorUsuarioPublishProxyid.comenazarSeguir(arg0_34idTemp,arg1_35idTemp);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>