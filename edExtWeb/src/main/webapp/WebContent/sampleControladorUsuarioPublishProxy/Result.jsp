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
        String arg0_1id=  request.getParameter("arg030");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        publicadores.DtUsuario verInfoUsuario13mtemp = sampleControladorUsuarioPublishProxyid.verInfoUsuario(arg0_1idTemp);
if(verInfoUsuario13mtemp == null){
%>
<%=verInfoUsuario13mtemp %>
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
if(verInfoUsuario13mtemp != null){
java.lang.String typenick16 = verInfoUsuario13mtemp.getNick();
        String tempResultnick16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick16));
        %>
        <%= tempResultnick16 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(verInfoUsuario13mtemp != null){
java.lang.String typeimage18 = verInfoUsuario13mtemp.getImage();
        String tempResultimage18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimage18));
        %>
        <%= tempResultimage18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(verInfoUsuario13mtemp != null){
java.util.Calendar typefechaNac20 = verInfoUsuario13mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac20 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac20 = typefechaNac20.getTime();
        String tempResultfechaNac20 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac20.format(datefechaNac20));
        %>
        <%= tempResultfechaNac20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">correo:</TD>
<TD>
<%
if(verInfoUsuario13mtemp != null){
java.lang.String typecorreo22 = verInfoUsuario13mtemp.getCorreo();
        String tempResultcorreo22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecorreo22));
        %>
        <%= tempResultcorreo22 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario13mtemp != null){
java.lang.String typepassword24 = verInfoUsuario13mtemp.getPassword();
        String tempResultpassword24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword24));
        %>
        <%= tempResultpassword24 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario13mtemp != null){
java.lang.String typenombre26 = verInfoUsuario13mtemp.getNombre();
        String tempResultnombre26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre26));
        %>
        <%= tempResultnombre26 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario13mtemp != null){
java.lang.String typeapellido28 = verInfoUsuario13mtemp.getApellido();
        String tempResultapellido28 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido28));
        %>
        <%= tempResultapellido28 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 32:
        gotMethod = true;
        java.lang.String[] listarUsuarios32mtemp = sampleControladorUsuarioPublishProxyid.listarUsuarios();
if(listarUsuarios32mtemp == null){
%>
<%=listarUsuarios32mtemp %>
<%
}else{
        String tempreturnp33 = null;
        if(listarUsuarios32mtemp != null){
        java.util.List listreturnp33= java.util.Arrays.asList(listarUsuarios32mtemp);
        tempreturnp33 = listreturnp33.toString();
        }
        %>
        <%=tempreturnp33%>
        <%
}
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
        String arg0_2id=  request.getParameter("arg041");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        String arg1_3id=  request.getParameter("arg143");
            java.lang.String arg1_3idTemp = null;
        if(!arg1_3id.equals("")){
         arg1_3idTemp  = arg1_3id;
        }
        String arg2_4id=  request.getParameter("arg245");
            java.lang.String arg2_4idTemp = null;
        if(!arg2_4id.equals("")){
         arg2_4idTemp  = arg2_4id;
        }
        String arg3_5id=  request.getParameter("arg347");
            java.util.Calendar arg3_5idTemp = null;
        if(!arg3_5id.equals("")){
        java.text.DateFormat dateFormatarg347 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg347  = dateFormatarg347.parse(arg3_5id);
         arg3_5idTemp = new java.util.GregorianCalendar();
        arg3_5idTemp.setTime(dateTemparg347);
        }
        sampleControladorUsuarioPublishProxyid.nuevosDatos(arg0_2idTemp,arg1_3idTemp,arg2_4idTemp,arg3_5idTemp);
break;
case 49:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg052");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        boolean validarCorreo49mtemp = sampleControladorUsuarioPublishProxyid.validarCorreo(arg0_6idTemp);
        String tempResultreturnp50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarCorreo49mtemp));
        %>
        <%= tempResultreturnp50 %>
        <%
break;
case 54:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg057");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        String arg1_8id=  request.getParameter("arg159");
            java.lang.String arg1_8idTemp = null;
        if(!arg1_8id.equals("")){
         arg1_8idTemp  = arg1_8id;
        }
        String arg2_9id=  request.getParameter("arg261");
            java.lang.String arg2_9idTemp = null;
        if(!arg2_9id.equals("")){
         arg2_9idTemp  = arg2_9id;
        }
        String arg3_10id=  request.getParameter("arg363");
            java.lang.String arg3_10idTemp = null;
        if(!arg3_10id.equals("")){
         arg3_10idTemp  = arg3_10id;
        }
        String arg4_11id=  request.getParameter("arg465");
            java.util.Calendar arg4_11idTemp = null;
        if(!arg4_11id.equals("")){
        java.text.DateFormat dateFormatarg465 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg465  = dateFormatarg465.parse(arg4_11id);
         arg4_11idTemp = new java.util.GregorianCalendar();
        arg4_11idTemp.setTime(dateTemparg465);
        }
        String arg5_12id=  request.getParameter("arg567");
            java.lang.String arg5_12idTemp = null;
        if(!arg5_12id.equals("")){
         arg5_12idTemp  = arg5_12id;
        }
        String arg6_13id=  request.getParameter("arg669");
            java.lang.String arg6_13idTemp = null;
        if(!arg6_13id.equals("")){
         arg6_13idTemp  = arg6_13id;
        }
        String arg7_14id=  request.getParameter("arg771");
            java.lang.String arg7_14idTemp = null;
        if(!arg7_14id.equals("")){
         arg7_14idTemp  = arg7_14id;
        }
        sampleControladorUsuarioPublishProxyid.altaUsuario(arg0_7idTemp,arg1_8idTemp,arg2_9idTemp,arg3_10idTemp,arg4_11idTemp,arg5_12idTemp,arg6_13idTemp,arg7_14idTemp);
break;
case 73:
        gotMethod = true;
        java.lang.String[] listarInstituto73mtemp = sampleControladorUsuarioPublishProxyid.listarInstituto();
if(listarInstituto73mtemp == null){
%>
<%=listarInstituto73mtemp %>
<%
}else{
        String tempreturnp74 = null;
        if(listarInstituto73mtemp != null){
        java.util.List listreturnp74= java.util.Arrays.asList(listarInstituto73mtemp);
        tempreturnp74 = listreturnp74.toString();
        }
        %>
        <%=tempreturnp74%>
        <%
}
break;
case 76:
        gotMethod = true;
        String arg0_15id=  request.getParameter("arg079");
            java.lang.String arg0_15idTemp = null;
        if(!arg0_15id.equals("")){
         arg0_15idTemp  = arg0_15id;
        }
        sampleControladorUsuarioPublishProxyid.altaInstituto(arg0_15idTemp);
break;
case 81:
        gotMethod = true;
        String arg0_16id=  request.getParameter("arg084");
            java.lang.String arg0_16idTemp = null;
        if(!arg0_16id.equals("")){
         arg0_16idTemp  = arg0_16id;
        }
        sampleControladorUsuarioPublishProxyid.altaCategoria(arg0_16idTemp);
break;
case 86:
        gotMethod = true;
        String arg0_17id=  request.getParameter("arg089");
            java.lang.String arg0_17idTemp = null;
        if(!arg0_17id.equals("")){
         arg0_17idTemp  = arg0_17id;
        }
        java.lang.String[] listarSeguidores86mtemp = sampleControladorUsuarioPublishProxyid.listarSeguidores(arg0_17idTemp);
if(listarSeguidores86mtemp == null){
%>
<%=listarSeguidores86mtemp %>
<%
}else{
        String tempreturnp87 = null;
        if(listarSeguidores86mtemp != null){
        java.util.List listreturnp87= java.util.Arrays.asList(listarSeguidores86mtemp);
        tempreturnp87 = listreturnp87.toString();
        }
        %>
        <%=tempreturnp87%>
        <%
}
break;
case 91:
        gotMethod = true;
        String arg0_18id=  request.getParameter("arg094");
            java.lang.String arg0_18idTemp = null;
        if(!arg0_18id.equals("")){
         arg0_18idTemp  = arg0_18id;
        }
        String arg1_19id=  request.getParameter("arg196");
            java.lang.String arg1_19idTemp = null;
        if(!arg1_19id.equals("")){
         arg1_19idTemp  = arg1_19id;
        }
        java.lang.String inscriptoED91mtemp = sampleControladorUsuarioPublishProxyid.inscriptoED(arg0_18idTemp,arg1_19idTemp);
if(inscriptoED91mtemp == null){
%>
<%=inscriptoED91mtemp %>
<%
}else{
        String tempResultreturnp92 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(inscriptoED91mtemp));
        %>
        <%= tempResultreturnp92 %>
        <%
}
break;
case 98:
        gotMethod = true;
        String arg0_20id=  request.getParameter("arg0101");
            java.lang.String arg0_20idTemp = null;
        if(!arg0_20id.equals("")){
         arg0_20idTemp  = arg0_20id;
        }
        String arg1_21id=  request.getParameter("arg1103");
            java.lang.String arg1_21idTemp = null;
        if(!arg1_21id.equals("")){
         arg1_21idTemp  = arg1_21id;
        }
        boolean inscriptoPF98mtemp = sampleControladorUsuarioPublishProxyid.inscriptoPF(arg0_20idTemp,arg1_21idTemp);
        String tempResultreturnp99 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(inscriptoPF98mtemp));
        %>
        <%= tempResultreturnp99 %>
        <%
break;
case 105:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0108");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        String arg1_23id=  request.getParameter("arg1110");
            java.lang.String arg1_23idTemp = null;
        if(!arg1_23id.equals("")){
         arg1_23idTemp  = arg1_23id;
        }
        boolean validarUsuario105mtemp = sampleControladorUsuarioPublishProxyid.validarUsuario(arg0_22idTemp,arg1_23idTemp);
        String tempResultreturnp106 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarUsuario105mtemp));
        %>
        <%= tempResultreturnp106 %>
        <%
break;
case 112:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0115");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        String arg1_25id=  request.getParameter("arg1117");
            java.lang.String arg1_25idTemp = null;
        if(!arg1_25id.equals("")){
         arg1_25idTemp  = arg1_25id;
        }
        sampleControladorUsuarioPublishProxyid.dejarDeSeguir(arg0_24idTemp,arg1_25idTemp);
break;
case 119:
        gotMethod = true;
        String arg0_26id=  request.getParameter("arg0122");
            java.lang.String arg0_26idTemp = null;
        if(!arg0_26id.equals("")){
         arg0_26idTemp  = arg0_26id;
        }
        java.lang.String[] listarSeguidos119mtemp = sampleControladorUsuarioPublishProxyid.listarSeguidos(arg0_26idTemp);
if(listarSeguidos119mtemp == null){
%>
<%=listarSeguidos119mtemp %>
<%
}else{
        String tempreturnp120 = null;
        if(listarSeguidos119mtemp != null){
        java.util.List listreturnp120= java.util.Arrays.asList(listarSeguidos119mtemp);
        tempreturnp120 = listreturnp120.toString();
        }
        %>
        <%=tempreturnp120%>
        <%
}
break;
case 124:
        gotMethod = true;
        String arg0_27id=  request.getParameter("arg0127");
            java.lang.String arg0_27idTemp = null;
        if(!arg0_27id.equals("")){
         arg0_27idTemp  = arg0_27id;
        }
        String arg1_28id=  request.getParameter("arg1129");
            java.lang.String arg1_28idTemp = null;
        if(!arg1_28id.equals("")){
         arg1_28idTemp  = arg1_28id;
        }
        boolean validarSeguidor124mtemp = sampleControladorUsuarioPublishProxyid.validarSeguidor(arg0_27idTemp,arg1_28idTemp);
        String tempResultreturnp125 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarSeguidor124mtemp));
        %>
        <%= tempResultreturnp125 %>
        <%
break;
case 131:
        gotMethod = true;
        String arg0_29id=  request.getParameter("arg0134");
            java.lang.String arg0_29idTemp = null;
        if(!arg0_29id.equals("")){
         arg0_29idTemp  = arg0_29id;
        }
        String arg1_30id=  request.getParameter("arg1136");
            java.lang.String arg1_30idTemp = null;
        if(!arg1_30id.equals("")){
         arg1_30idTemp  = arg1_30id;
        }
        boolean validarSigue131mtemp = sampleControladorUsuarioPublishProxyid.validarSigue(arg0_29idTemp,arg1_30idTemp);
        String tempResultreturnp132 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarSigue131mtemp));
        %>
        <%= tempResultreturnp132 %>
        <%
break;
case 138:
        gotMethod = true;
        String arg0_31id=  request.getParameter("arg0141");
            java.lang.String arg0_31idTemp = null;
        if(!arg0_31id.equals("")){
         arg0_31idTemp  = arg0_31id;
        }
        String arg1_32id=  request.getParameter("arg1143");
            java.lang.String arg1_32idTemp = null;
        if(!arg1_32id.equals("")){
         arg1_32idTemp  = arg1_32id;
        }
        String arg2_33id=  request.getParameter("arg2145");
            java.lang.String arg2_33idTemp = null;
        if(!arg2_33id.equals("")){
         arg2_33idTemp  = arg2_33id;
        }
        sampleControladorUsuarioPublishProxyid.cambiarInscripcion(arg0_31idTemp,arg1_32idTemp,arg2_33idTemp);
break;
case 147:
        gotMethod = true;
        publicadores.DtDocente docente147mtemp = sampleControladorUsuarioPublishProxyid.docente();
if(docente147mtemp == null){
%>
<%=docente147mtemp %>
<%
}else{
        if(docente147mtemp!= null){
        String tempreturnp148 = docente147mtemp.toString();
        %>
        <%=tempreturnp148%>
        <%
        }}
break;
case 150:
        gotMethod = true;
        String arg0_34id=  request.getParameter("arg0153");
            java.lang.String arg0_34idTemp = null;
        if(!arg0_34id.equals("")){
         arg0_34idTemp  = arg0_34id;
        }
        String arg1_35id=  request.getParameter("arg1155");
            java.lang.String arg1_35idTemp = null;
        if(!arg1_35id.equals("")){
         arg1_35idTemp  = arg1_35id;
        }
        sampleControladorUsuarioPublishProxyid.comenazarSeguir(arg0_34idTemp,arg1_35idTemp);
break;
case 157:
        gotMethod = true;
        String arg0_36id=  request.getParameter("arg0160");
            java.lang.String arg0_36idTemp = null;
        if(!arg0_36id.equals("")){
         arg0_36idTemp  = arg0_36id;
        }
        boolean validarNick157mtemp = sampleControladorUsuarioPublishProxyid.validarNick(arg0_36idTemp);
        String tempResultreturnp158 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarNick157mtemp));
        %>
        <%= tempResultreturnp158 %>
        <%
break;
case 162:
        gotMethod = true;
        publicadores.DtEstudiante estudiante162mtemp = sampleControladorUsuarioPublishProxyid.estudiante();
if(estudiante162mtemp == null){
%>
<%=estudiante162mtemp %>
<%
}else{
        if(estudiante162mtemp!= null){
        String tempreturnp163 = estudiante162mtemp.toString();
        %>
        <%=tempreturnp163%>
        <%
        }}
break;
case 165:
        gotMethod = true;
        java.lang.String[] listarEstudiantesAux165mtemp = sampleControladorUsuarioPublishProxyid.listarEstudiantesAux();
if(listarEstudiantesAux165mtemp == null){
%>
<%=listarEstudiantesAux165mtemp %>
<%
}else{
        String tempreturnp166 = null;
        if(listarEstudiantesAux165mtemp != null){
        java.util.List listreturnp166= java.util.Arrays.asList(listarEstudiantesAux165mtemp);
        tempreturnp166 = listreturnp166.toString();
        }
        %>
        <%=tempreturnp166%>
        <%
}
break;
case 168:
        gotMethod = true;
        String arg0_37id=  request.getParameter("arg0171");
            java.lang.String arg0_37idTemp = null;
        if(!arg0_37id.equals("")){
         arg0_37idTemp  = arg0_37id;
        }
        publicadores.DtInscripcionED[] listarInscripcionesED168mtemp = sampleControladorUsuarioPublishProxyid.listarInscripcionesED(arg0_37idTemp);
if(listarInscripcionesED168mtemp == null){
%>
<%=listarInscripcionesED168mtemp %>
<%
}else{
        String tempreturnp169 = null;
        if(listarInscripcionesED168mtemp != null){
        java.util.List listreturnp169= java.util.Arrays.asList(listarInscripcionesED168mtemp);
        tempreturnp169 = listreturnp169.toString();
        }
        %>
        <%=tempreturnp169%>
        <%
}
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