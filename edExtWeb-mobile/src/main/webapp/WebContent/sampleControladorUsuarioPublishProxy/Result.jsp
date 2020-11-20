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
        String arg0_1id=  request.getParameter("arg016");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        boolean validarCorreo13mtemp = sampleControladorUsuarioPublishProxyid.validarCorreo(arg0_1idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarCorreo13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 18:
        gotMethod = true;
        publicadores.DtUsuario[] listarDTUsuarios18mtemp = sampleControladorUsuarioPublishProxyid.listarDTUsuarios();
if(listarDTUsuarios18mtemp == null){
%>
<%=listarDTUsuarios18mtemp %>
<%
}else{
        String tempreturnp19 = null;
        if(listarDTUsuarios18mtemp != null){
        java.util.List listreturnp19= java.util.Arrays.asList(listarDTUsuarios18mtemp);
        tempreturnp19 = listreturnp19.toString();
        }
        %>
        <%=tempreturnp19%>
        <%
}
break;
case 21:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg038");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        publicadores.DtUsuario verInfoUsuario21mtemp = sampleControladorUsuarioPublishProxyid.verInfoUsuario(arg0_2idTemp);
if(verInfoUsuario21mtemp == null){
%>
<%=verInfoUsuario21mtemp %>
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
if(verInfoUsuario21mtemp != null){
java.lang.String typenick24 = verInfoUsuario21mtemp.getNick();
        String tempResultnick24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick24));
        %>
        <%= tempResultnick24 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(verInfoUsuario21mtemp != null){
java.lang.String typeimage26 = verInfoUsuario21mtemp.getImage();
        String tempResultimage26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimage26));
        %>
        <%= tempResultimage26 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(verInfoUsuario21mtemp != null){
java.util.Calendar typefechaNac28 = verInfoUsuario21mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac28 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac28 = typefechaNac28.getTime();
        String tempResultfechaNac28 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac28.format(datefechaNac28));
        %>
        <%= tempResultfechaNac28 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">correo:</TD>
<TD>
<%
if(verInfoUsuario21mtemp != null){
java.lang.String typecorreo30 = verInfoUsuario21mtemp.getCorreo();
        String tempResultcorreo30 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecorreo30));
        %>
        <%= tempResultcorreo30 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario21mtemp != null){
java.lang.String typepassword32 = verInfoUsuario21mtemp.getPassword();
        String tempResultpassword32 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword32));
        %>
        <%= tempResultpassword32 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario21mtemp != null){
java.lang.String typenombre34 = verInfoUsuario21mtemp.getNombre();
        String tempResultnombre34 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre34));
        %>
        <%= tempResultnombre34 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario21mtemp != null){
java.lang.String typeapellido36 = verInfoUsuario21mtemp.getApellido();
        String tempResultapellido36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido36));
        %>
        <%= tempResultapellido36 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 40:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg043");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        String arg1_4id=  request.getParameter("arg145");
            java.lang.String arg1_4idTemp = null;
        if(!arg1_4id.equals("")){
         arg1_4idTemp  = arg1_4id;
        }
        String arg2_5id=  request.getParameter("arg247");
            java.lang.String arg2_5idTemp = null;
        if(!arg2_5id.equals("")){
         arg2_5idTemp  = arg2_5id;
        }
        String arg3_6id=  request.getParameter("arg349");
            java.util.Calendar arg3_6idTemp = null;
        if(!arg3_6id.equals("")){
        java.text.DateFormat dateFormatarg349 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg349  = dateFormatarg349.parse(arg3_6id);
         arg3_6idTemp = new java.util.GregorianCalendar();
        arg3_6idTemp.setTime(dateTemparg349);
        }
        sampleControladorUsuarioPublishProxyid.nuevosDatos(arg0_3idTemp,arg1_4idTemp,arg2_5idTemp,arg3_6idTemp);
break;
case 51:
        gotMethod = true;
        java.lang.String[] listarUsuarios51mtemp = sampleControladorUsuarioPublishProxyid.listarUsuarios();
if(listarUsuarios51mtemp == null){
%>
<%=listarUsuarios51mtemp %>
<%
}else{
        String tempreturnp52 = null;
        if(listarUsuarios51mtemp != null){
        java.util.List listreturnp52= java.util.Arrays.asList(listarUsuarios51mtemp);
        tempreturnp52 = listreturnp52.toString();
        }
        %>
        <%=tempreturnp52%>
        <%
}
break;
case 54:
        gotMethod = true;
        java.lang.String[] listarInstituto54mtemp = sampleControladorUsuarioPublishProxyid.listarInstituto();
if(listarInstituto54mtemp == null){
%>
<%=listarInstituto54mtemp %>
<%
}else{
        String tempreturnp55 = null;
        if(listarInstituto54mtemp != null){
        java.util.List listreturnp55= java.util.Arrays.asList(listarInstituto54mtemp);
        tempreturnp55 = listreturnp55.toString();
        }
        %>
        <%=tempreturnp55%>
        <%
}
break;
case 57:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg060");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        String arg1_8id=  request.getParameter("arg162");
            java.lang.String arg1_8idTemp = null;
        if(!arg1_8id.equals("")){
         arg1_8idTemp  = arg1_8id;
        }
        String arg2_9id=  request.getParameter("arg264");
            java.lang.String arg2_9idTemp = null;
        if(!arg2_9id.equals("")){
         arg2_9idTemp  = arg2_9id;
        }
        String arg3_10id=  request.getParameter("arg366");
            java.lang.String arg3_10idTemp = null;
        if(!arg3_10id.equals("")){
         arg3_10idTemp  = arg3_10id;
        }
        String arg4_11id=  request.getParameter("arg468");
            java.util.Calendar arg4_11idTemp = null;
        if(!arg4_11id.equals("")){
        java.text.DateFormat dateFormatarg468 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg468  = dateFormatarg468.parse(arg4_11id);
         arg4_11idTemp = new java.util.GregorianCalendar();
        arg4_11idTemp.setTime(dateTemparg468);
        }
        String arg5_12id=  request.getParameter("arg570");
            java.lang.String arg5_12idTemp = null;
        if(!arg5_12id.equals("")){
         arg5_12idTemp  = arg5_12id;
        }
        String arg6_13id=  request.getParameter("arg672");
            java.lang.String arg6_13idTemp = null;
        if(!arg6_13id.equals("")){
         arg6_13idTemp  = arg6_13id;
        }
        String arg7_14id=  request.getParameter("arg774");
            java.lang.String arg7_14idTemp = null;
        if(!arg7_14id.equals("")){
         arg7_14idTemp  = arg7_14id;
        }
        sampleControladorUsuarioPublishProxyid.altaUsuario(arg0_7idTemp,arg1_8idTemp,arg2_9idTemp,arg3_10idTemp,arg4_11idTemp,arg5_12idTemp,arg6_13idTemp,arg7_14idTemp);
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
        java.lang.String[] listarEstudiantesAux86mtemp = sampleControladorUsuarioPublishProxyid.listarEstudiantesAux();
if(listarEstudiantesAux86mtemp == null){
%>
<%=listarEstudiantesAux86mtemp %>
<%
}else{
        String tempreturnp87 = null;
        if(listarEstudiantesAux86mtemp != null){
        java.util.List listreturnp87= java.util.Arrays.asList(listarEstudiantesAux86mtemp);
        tempreturnp87 = listreturnp87.toString();
        }
        %>
        <%=tempreturnp87%>
        <%
}
break;
case 89:
        gotMethod = true;
        String arg0_17id=  request.getParameter("arg092");
            java.lang.String arg0_17idTemp = null;
        if(!arg0_17id.equals("")){
         arg0_17idTemp  = arg0_17id;
        }
        publicadores.DtInscripcionED[] listarInscripcionesED89mtemp = sampleControladorUsuarioPublishProxyid.listarInscripcionesED(arg0_17idTemp);
if(listarInscripcionesED89mtemp == null){
%>
<%=listarInscripcionesED89mtemp %>
<%
}else{
        String tempreturnp90 = null;
        if(listarInscripcionesED89mtemp != null){
        java.util.List listreturnp90= java.util.Arrays.asList(listarInscripcionesED89mtemp);
        tempreturnp90 = listreturnp90.toString();
        }
        %>
        <%=tempreturnp90%>
        <%
}
break;
case 94:
        gotMethod = true;
        String arg0_18id=  request.getParameter("arg097");
            java.lang.String arg0_18idTemp = null;
        if(!arg0_18id.equals("")){
         arg0_18idTemp  = arg0_18id;
        }
        java.lang.String[] listarSeguidos94mtemp = sampleControladorUsuarioPublishProxyid.listarSeguidos(arg0_18idTemp);
if(listarSeguidos94mtemp == null){
%>
<%=listarSeguidos94mtemp %>
<%
}else{
        String tempreturnp95 = null;
        if(listarSeguidos94mtemp != null){
        java.util.List listreturnp95= java.util.Arrays.asList(listarSeguidos94mtemp);
        tempreturnp95 = listreturnp95.toString();
        }
        %>
        <%=tempreturnp95%>
        <%
}
break;
case 99:
        gotMethod = true;
        String arg0_19id=  request.getParameter("arg0102");
            java.lang.String arg0_19idTemp = null;
        if(!arg0_19id.equals("")){
         arg0_19idTemp  = arg0_19id;
        }
        String arg1_20id=  request.getParameter("arg1104");
            java.lang.String arg1_20idTemp = null;
        if(!arg1_20id.equals("")){
         arg1_20idTemp  = arg1_20id;
        }
        java.lang.String inscriptoED99mtemp = sampleControladorUsuarioPublishProxyid.inscriptoED(arg0_19idTemp,arg1_20idTemp);
if(inscriptoED99mtemp == null){
%>
<%=inscriptoED99mtemp %>
<%
}else{
        String tempResultreturnp100 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(inscriptoED99mtemp));
        %>
        <%= tempResultreturnp100 %>
        <%
}
break;
case 106:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0109");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        String arg1_22id=  request.getParameter("arg1111");
            java.lang.String arg1_22idTemp = null;
        if(!arg1_22id.equals("")){
         arg1_22idTemp  = arg1_22id;
        }
        sampleControladorUsuarioPublishProxyid.dejarDeSeguir(arg0_21idTemp,arg1_22idTemp);
break;
case 113:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0116");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        java.lang.String[] listarSeguidores113mtemp = sampleControladorUsuarioPublishProxyid.listarSeguidores(arg0_23idTemp);
if(listarSeguidores113mtemp == null){
%>
<%=listarSeguidores113mtemp %>
<%
}else{
        String tempreturnp114 = null;
        if(listarSeguidores113mtemp != null){
        java.util.List listreturnp114= java.util.Arrays.asList(listarSeguidores113mtemp);
        tempreturnp114 = listreturnp114.toString();
        }
        %>
        <%=tempreturnp114%>
        <%
}
break;
case 118:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0121");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        String arg1_25id=  request.getParameter("arg1123");
            java.lang.String arg1_25idTemp = null;
        if(!arg1_25id.equals("")){
         arg1_25idTemp  = arg1_25id;
        }
        boolean validarUsuario118mtemp = sampleControladorUsuarioPublishProxyid.validarUsuario(arg0_24idTemp,arg1_25idTemp);
        String tempResultreturnp119 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarUsuario118mtemp));
        %>
        <%= tempResultreturnp119 %>
        <%
break;
case 125:
        gotMethod = true;
        String arg0_26id=  request.getParameter("arg0128");
            java.lang.String arg0_26idTemp = null;
        if(!arg0_26id.equals("")){
         arg0_26idTemp  = arg0_26id;
        }
        String arg1_27id=  request.getParameter("arg1130");
            java.lang.String arg1_27idTemp = null;
        if(!arg1_27id.equals("")){
         arg1_27idTemp  = arg1_27id;
        }
        boolean validarSigue125mtemp = sampleControladorUsuarioPublishProxyid.validarSigue(arg0_26idTemp,arg1_27idTemp);
        String tempResultreturnp126 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarSigue125mtemp));
        %>
        <%= tempResultreturnp126 %>
        <%
break;
case 132:
        gotMethod = true;
        String arg0_28id=  request.getParameter("arg0135");
            java.lang.String arg0_28idTemp = null;
        if(!arg0_28id.equals("")){
         arg0_28idTemp  = arg0_28id;
        }
        String arg1_29id=  request.getParameter("arg1137");
            java.lang.String arg1_29idTemp = null;
        if(!arg1_29id.equals("")){
         arg1_29idTemp  = arg1_29id;
        }
        boolean validarSeguidor132mtemp = sampleControladorUsuarioPublishProxyid.validarSeguidor(arg0_28idTemp,arg1_29idTemp);
        String tempResultreturnp133 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarSeguidor132mtemp));
        %>
        <%= tempResultreturnp133 %>
        <%
break;
case 139:
        gotMethod = true;
        String arg0_30id=  request.getParameter("arg0142");
            java.lang.String arg0_30idTemp = null;
        if(!arg0_30id.equals("")){
         arg0_30idTemp  = arg0_30id;
        }
        String arg1_31id=  request.getParameter("arg1144");
            java.lang.String arg1_31idTemp = null;
        if(!arg1_31id.equals("")){
         arg1_31idTemp  = arg1_31id;
        }
        boolean inscriptoPF139mtemp = sampleControladorUsuarioPublishProxyid.inscriptoPF(arg0_30idTemp,arg1_31idTemp);
        String tempResultreturnp140 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(inscriptoPF139mtemp));
        %>
        <%= tempResultreturnp140 %>
        <%
break;
case 146:
        gotMethod = true;
        String arg0_32id=  request.getParameter("arg0149");
            java.lang.String arg0_32idTemp = null;
        if(!arg0_32id.equals("")){
         arg0_32idTemp  = arg0_32id;
        }
        String arg1_33id=  request.getParameter("arg1151");
            java.lang.String arg1_33idTemp = null;
        if(!arg1_33id.equals("")){
         arg1_33idTemp  = arg1_33id;
        }
        String arg2_34id=  request.getParameter("arg2153");
            java.lang.String arg2_34idTemp = null;
        if(!arg2_34id.equals("")){
         arg2_34idTemp  = arg2_34id;
        }
        sampleControladorUsuarioPublishProxyid.cambiarInscripcion(arg0_32idTemp,arg1_33idTemp,arg2_34idTemp);
break;
case 155:
        gotMethod = true;
        publicadores.DtEstudiante estudiante155mtemp = sampleControladorUsuarioPublishProxyid.estudiante();
if(estudiante155mtemp == null){
%>
<%=estudiante155mtemp %>
<%
}else{
        if(estudiante155mtemp!= null){
        String tempreturnp156 = estudiante155mtemp.toString();
        %>
        <%=tempreturnp156%>
        <%
        }}
break;
case 158:
        gotMethod = true;
        String arg0_35id=  request.getParameter("arg0161");
            java.lang.String arg0_35idTemp = null;
        if(!arg0_35id.equals("")){
         arg0_35idTemp  = arg0_35id;
        }
        boolean validarNick158mtemp = sampleControladorUsuarioPublishProxyid.validarNick(arg0_35idTemp);
        String tempResultreturnp159 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarNick158mtemp));
        %>
        <%= tempResultreturnp159 %>
        <%
break;
case 163:
        gotMethod = true;
        String arg0_36id=  request.getParameter("arg0166");
            java.lang.String arg0_36idTemp = null;
        if(!arg0_36id.equals("")){
         arg0_36idTemp  = arg0_36id;
        }
        String arg1_37id=  request.getParameter("arg1168");
            java.lang.String arg1_37idTemp = null;
        if(!arg1_37id.equals("")){
         arg1_37idTemp  = arg1_37id;
        }
        sampleControladorUsuarioPublishProxyid.comenazarSeguir(arg0_36idTemp,arg1_37idTemp);
break;
case 170:
        gotMethod = true;
        publicadores.DtDocente docente170mtemp = sampleControladorUsuarioPublishProxyid.docente();
if(docente170mtemp == null){
%>
<%=docente170mtemp %>
<%
}else{
        if(docente170mtemp!= null){
        String tempreturnp171 = docente170mtemp.toString();
        %>
        <%=tempreturnp171%>
        <%
        }}
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