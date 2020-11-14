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
        String arg1_2id=  request.getParameter("arg118");
            java.lang.String arg1_2idTemp = null;
        if(!arg1_2id.equals("")){
         arg1_2idTemp  = arg1_2id;
        }
        String arg2_3id=  request.getParameter("arg220");
            java.lang.String arg2_3idTemp = null;
        if(!arg2_3id.equals("")){
         arg2_3idTemp  = arg2_3id;
        }
        String arg3_4id=  request.getParameter("arg322");
            java.lang.String arg3_4idTemp = null;
        if(!arg3_4id.equals("")){
         arg3_4idTemp  = arg3_4id;
        }
        String arg4_5id=  request.getParameter("arg424");
            java.util.Calendar arg4_5idTemp = null;
        if(!arg4_5id.equals("")){
        java.text.DateFormat dateFormatarg424 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg424  = dateFormatarg424.parse(arg4_5id);
         arg4_5idTemp = new java.util.GregorianCalendar();
        arg4_5idTemp.setTime(dateTemparg424);
        }
        String arg5_6id=  request.getParameter("arg526");
            java.lang.String arg5_6idTemp = null;
        if(!arg5_6id.equals("")){
         arg5_6idTemp  = arg5_6id;
        }
        String arg6_7id=  request.getParameter("arg628");
            java.lang.String arg6_7idTemp = null;
        if(!arg6_7id.equals("")){
         arg6_7idTemp  = arg6_7id;
        }
        String arg7_8id=  request.getParameter("arg730");
            java.lang.String arg7_8idTemp = null;
        if(!arg7_8id.equals("")){
         arg7_8idTemp  = arg7_8id;
        }
        sampleControladorUsuarioPublishProxyid.altaUsuario(arg0_1idTemp,arg1_2idTemp,arg2_3idTemp,arg3_4idTemp,arg4_5idTemp,arg5_6idTemp,arg6_7idTemp,arg7_8idTemp);
break;
case 32:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg035");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        sampleControladorUsuarioPublishProxyid.altaCategoria(arg0_9idTemp);
break;
case 37:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg040");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        sampleControladorUsuarioPublishProxyid.altaInstituto(arg0_10idTemp);
break;
case 42:
        gotMethod = true;
        publicadores.DtUsuario[] listarDTUsuarios42mtemp = sampleControladorUsuarioPublishProxyid.listarDTUsuarios();
if(listarDTUsuarios42mtemp == null){
%>
<%=listarDTUsuarios42mtemp %>
<%
}else{
        String tempreturnp43 = null;
        if(listarDTUsuarios42mtemp != null){
        java.util.List listreturnp43= java.util.Arrays.asList(listarDTUsuarios42mtemp);
        tempreturnp43 = listreturnp43.toString();
        }
        %>
        <%=tempreturnp43%>
        <%
}
break;
case 45:
        gotMethod = true;
        String arg0_11id=  request.getParameter("arg062");
            java.lang.String arg0_11idTemp = null;
        if(!arg0_11id.equals("")){
         arg0_11idTemp  = arg0_11id;
        }
        publicadores.DtUsuario verInfoUsuario45mtemp = sampleControladorUsuarioPublishProxyid.verInfoUsuario(arg0_11idTemp);
if(verInfoUsuario45mtemp == null){
%>
<%=verInfoUsuario45mtemp %>
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
if(verInfoUsuario45mtemp != null){
java.lang.String typenick48 = verInfoUsuario45mtemp.getNick();
        String tempResultnick48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick48));
        %>
        <%= tempResultnick48 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">image:</TD>
<TD>
<%
if(verInfoUsuario45mtemp != null){
java.lang.String typeimage50 = verInfoUsuario45mtemp.getImage();
        String tempResultimage50 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimage50));
        %>
        <%= tempResultimage50 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(verInfoUsuario45mtemp != null){
java.util.Calendar typefechaNac52 = verInfoUsuario45mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac52 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac52 = typefechaNac52.getTime();
        String tempResultfechaNac52 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac52.format(datefechaNac52));
        %>
        <%= tempResultfechaNac52 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">correo:</TD>
<TD>
<%
if(verInfoUsuario45mtemp != null){
java.lang.String typecorreo54 = verInfoUsuario45mtemp.getCorreo();
        String tempResultcorreo54 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecorreo54));
        %>
        <%= tempResultcorreo54 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(verInfoUsuario45mtemp != null){
java.lang.String typepassword56 = verInfoUsuario45mtemp.getPassword();
        String tempResultpassword56 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword56));
        %>
        <%= tempResultpassword56 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoUsuario45mtemp != null){
java.lang.String typenombre58 = verInfoUsuario45mtemp.getNombre();
        String tempResultnombre58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre58));
        %>
        <%= tempResultnombre58 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(verInfoUsuario45mtemp != null){
java.lang.String typeapellido60 = verInfoUsuario45mtemp.getApellido();
        String tempResultapellido60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido60));
        %>
        <%= tempResultapellido60 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 64:
        gotMethod = true;
        java.lang.String[] listarUsuarios64mtemp = sampleControladorUsuarioPublishProxyid.listarUsuarios();
if(listarUsuarios64mtemp == null){
%>
<%=listarUsuarios64mtemp %>
<%
}else{
        String tempreturnp65 = null;
        if(listarUsuarios64mtemp != null){
        java.util.List listreturnp65= java.util.Arrays.asList(listarUsuarios64mtemp);
        tempreturnp65 = listreturnp65.toString();
        }
        %>
        <%=tempreturnp65%>
        <%
}
break;
case 67:
        gotMethod = true;
        String arg0_12id=  request.getParameter("arg070");
            java.lang.String arg0_12idTemp = null;
        if(!arg0_12id.equals("")){
         arg0_12idTemp  = arg0_12id;
        }
        String arg1_13id=  request.getParameter("arg172");
            java.lang.String arg1_13idTemp = null;
        if(!arg1_13id.equals("")){
         arg1_13idTemp  = arg1_13id;
        }
        String arg2_14id=  request.getParameter("arg274");
            java.lang.String arg2_14idTemp = null;
        if(!arg2_14id.equals("")){
         arg2_14idTemp  = arg2_14id;
        }
        String arg3_15id=  request.getParameter("arg376");
            java.util.Calendar arg3_15idTemp = null;
        if(!arg3_15id.equals("")){
        java.text.DateFormat dateFormatarg376 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg376  = dateFormatarg376.parse(arg3_15id);
         arg3_15idTemp = new java.util.GregorianCalendar();
        arg3_15idTemp.setTime(dateTemparg376);
        }
        sampleControladorUsuarioPublishProxyid.nuevosDatos(arg0_12idTemp,arg1_13idTemp,arg2_14idTemp,arg3_15idTemp);
break;
case 78:
        gotMethod = true;
        java.lang.String[] listarInstituto78mtemp = sampleControladorUsuarioPublishProxyid.listarInstituto();
if(listarInstituto78mtemp == null){
%>
<%=listarInstituto78mtemp %>
<%
}else{
        String tempreturnp79 = null;
        if(listarInstituto78mtemp != null){
        java.util.List listreturnp79= java.util.Arrays.asList(listarInstituto78mtemp);
        tempreturnp79 = listreturnp79.toString();
        }
        %>
        <%=tempreturnp79%>
        <%
}
break;
case 81:
        gotMethod = true;
        String arg0_16id=  request.getParameter("arg084");
            java.lang.String arg0_16idTemp = null;
        if(!arg0_16id.equals("")){
         arg0_16idTemp  = arg0_16id;
        }
        publicadores.DtInscripcionED[] listarInscripcionesED81mtemp = sampleControladorUsuarioPublishProxyid.listarInscripcionesED(arg0_16idTemp);
if(listarInscripcionesED81mtemp == null){
%>
<%=listarInscripcionesED81mtemp %>
<%
}else{
        String tempreturnp82 = null;
        if(listarInscripcionesED81mtemp != null){
        java.util.List listreturnp82= java.util.Arrays.asList(listarInscripcionesED81mtemp);
        tempreturnp82 = listreturnp82.toString();
        }
        %>
        <%=tempreturnp82%>
        <%
}
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
        java.lang.String[] listarSeguidores89mtemp = sampleControladorUsuarioPublishProxyid.listarSeguidores(arg0_17idTemp);
if(listarSeguidores89mtemp == null){
%>
<%=listarSeguidores89mtemp %>
<%
}else{
        String tempreturnp90 = null;
        if(listarSeguidores89mtemp != null){
        java.util.List listreturnp90= java.util.Arrays.asList(listarSeguidores89mtemp);
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
        String arg1_19id=  request.getParameter("arg199");
            java.lang.String arg1_19idTemp = null;
        if(!arg1_19id.equals("")){
         arg1_19idTemp  = arg1_19id;
        }
        boolean validarSeguidor94mtemp = sampleControladorUsuarioPublishProxyid.validarSeguidor(arg0_18idTemp,arg1_19idTemp);
        String tempResultreturnp95 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarSeguidor94mtemp));
        %>
        <%= tempResultreturnp95 %>
        <%
break;
case 101:
        gotMethod = true;
        String arg0_20id=  request.getParameter("arg0104");
            java.lang.String arg0_20idTemp = null;
        if(!arg0_20id.equals("")){
         arg0_20idTemp  = arg0_20id;
        }
        String arg1_21id=  request.getParameter("arg1106");
            java.lang.String arg1_21idTemp = null;
        if(!arg1_21id.equals("")){
         arg1_21idTemp  = arg1_21id;
        }
        boolean validarSigue101mtemp = sampleControladorUsuarioPublishProxyid.validarSigue(arg0_20idTemp,arg1_21idTemp);
        String tempResultreturnp102 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarSigue101mtemp));
        %>
        <%= tempResultreturnp102 %>
        <%
break;
case 108:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0111");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        java.lang.String[] listarSeguidos108mtemp = sampleControladorUsuarioPublishProxyid.listarSeguidos(arg0_22idTemp);
if(listarSeguidos108mtemp == null){
%>
<%=listarSeguidos108mtemp %>
<%
}else{
        String tempreturnp109 = null;
        if(listarSeguidos108mtemp != null){
        java.util.List listreturnp109= java.util.Arrays.asList(listarSeguidos108mtemp);
        tempreturnp109 = listreturnp109.toString();
        }
        %>
        <%=tempreturnp109%>
        <%
}
break;
case 113:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0116");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        String arg1_24id=  request.getParameter("arg1118");
            java.lang.String arg1_24idTemp = null;
        if(!arg1_24id.equals("")){
         arg1_24idTemp  = arg1_24id;
        }
        String arg2_25id=  request.getParameter("arg2120");
            java.lang.String arg2_25idTemp = null;
        if(!arg2_25id.equals("")){
         arg2_25idTemp  = arg2_25id;
        }
        sampleControladorUsuarioPublishProxyid.cambiarInscripcion(arg0_23idTemp,arg1_24idTemp,arg2_25idTemp);
break;
case 122:
        gotMethod = true;
        String arg0_26id=  request.getParameter("arg0125");
            java.lang.String arg0_26idTemp = null;
        if(!arg0_26id.equals("")){
         arg0_26idTemp  = arg0_26id;
        }
        String arg1_27id=  request.getParameter("arg1127");
            java.lang.String arg1_27idTemp = null;
        if(!arg1_27id.equals("")){
         arg1_27idTemp  = arg1_27id;
        }
        boolean validarUsuario122mtemp = sampleControladorUsuarioPublishProxyid.validarUsuario(arg0_26idTemp,arg1_27idTemp);
        String tempResultreturnp123 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(validarUsuario122mtemp));
        %>
        <%= tempResultreturnp123 %>
        <%
break;
case 129:
        gotMethod = true;
        String arg0_28id=  request.getParameter("arg0132");
            java.lang.String arg0_28idTemp = null;
        if(!arg0_28id.equals("")){
         arg0_28idTemp  = arg0_28id;
        }
        String arg1_29id=  request.getParameter("arg1134");
            java.lang.String arg1_29idTemp = null;
        if(!arg1_29id.equals("")){
         arg1_29idTemp  = arg1_29id;
        }
        sampleControladorUsuarioPublishProxyid.dejarDeSeguir(arg0_28idTemp,arg1_29idTemp);
break;
case 136:
        gotMethod = true;
        String arg0_30id=  request.getParameter("arg0139");
            java.lang.String arg0_30idTemp = null;
        if(!arg0_30id.equals("")){
         arg0_30idTemp  = arg0_30id;
        }
        String arg1_31id=  request.getParameter("arg1141");
            java.lang.String arg1_31idTemp = null;
        if(!arg1_31id.equals("")){
         arg1_31idTemp  = arg1_31id;
        }
        java.lang.String inscriptoED136mtemp = sampleControladorUsuarioPublishProxyid.inscriptoED(arg0_30idTemp,arg1_31idTemp);
if(inscriptoED136mtemp == null){
%>
<%=inscriptoED136mtemp %>
<%
}else{
        String tempResultreturnp137 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(inscriptoED136mtemp));
        %>
        <%= tempResultreturnp137 %>
        <%
}
break;
case 143:
        gotMethod = true;
        String arg0_32id=  request.getParameter("arg0146");
            java.lang.String arg0_32idTemp = null;
        if(!arg0_32id.equals("")){
         arg0_32idTemp  = arg0_32id;
        }
        String arg1_33id=  request.getParameter("arg1148");
            java.lang.String arg1_33idTemp = null;
        if(!arg1_33id.equals("")){
         arg1_33idTemp  = arg1_33id;
        }
        boolean inscriptoPF143mtemp = sampleControladorUsuarioPublishProxyid.inscriptoPF(arg0_32idTemp,arg1_33idTemp);
        String tempResultreturnp144 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(inscriptoPF143mtemp));
        %>
        <%= tempResultreturnp144 %>
        <%
break;
case 150:
        gotMethod = true;
        publicadores.DtEstudiante estudiante150mtemp = sampleControladorUsuarioPublishProxyid.estudiante();
if(estudiante150mtemp == null){
%>
<%=estudiante150mtemp %>
<%
}else{
        if(estudiante150mtemp!= null){
        String tempreturnp151 = estudiante150mtemp.toString();
        %>
        <%=tempreturnp151%>
        <%
        }}
break;
case 153:
        gotMethod = true;
        publicadores.DtDocente docente153mtemp = sampleControladorUsuarioPublishProxyid.docente();
if(docente153mtemp == null){
%>
<%=docente153mtemp %>
<%
}else{
        if(docente153mtemp!= null){
        String tempreturnp154 = docente153mtemp.toString();
        %>
        <%=tempreturnp154%>
        <%
        }}
break;
case 156:
        gotMethod = true;
        String arg0_34id=  request.getParameter("arg0159");
            java.lang.String arg0_34idTemp = null;
        if(!arg0_34id.equals("")){
         arg0_34idTemp  = arg0_34id;
        }
        String arg1_35id=  request.getParameter("arg1161");
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