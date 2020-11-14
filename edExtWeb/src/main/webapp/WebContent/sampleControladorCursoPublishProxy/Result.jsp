<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorCursoPublishProxyid" scope="session" class="publicadores.ControladorCursoPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorCursoPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorCursoPublishProxyid.getEndpoint();
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
        sampleControladorCursoPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorCursoPublish getControladorCursoPublish10mtemp = sampleControladorCursoPublishProxyid.getControladorCursoPublish();
if(getControladorCursoPublish10mtemp == null){
%>
<%=getControladorCursoPublish10mtemp %>
<%
}else{
        if(getControladorCursoPublish10mtemp!= null){
        String tempreturnp11 = getControladorCursoPublish10mtemp.toString();
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
        java.lang.String[] listarDocentesInstituto13mtemp = sampleControladorCursoPublishProxyid.listarDocentesInstituto(arg0_1idTemp);
if(listarDocentesInstituto13mtemp == null){
%>
<%=listarDocentesInstituto13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(listarDocentesInstituto13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(listarDocentesInstituto13mtemp);
        tempreturnp14 = listreturnp14.toString();
        }
        %>
        <%=tempreturnp14%>
        <%
}
break;
case 18:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg021");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        String arg1_3id=  request.getParameter("arg123");
            java.lang.String arg1_3idTemp = null;
        if(!arg1_3id.equals("")){
         arg1_3idTemp  = arg1_3id;
        }
        String arg2_4id=  request.getParameter("arg225");
            java.util.Calendar arg2_4idTemp = null;
        if(!arg2_4id.equals("")){
        java.text.DateFormat dateFormatarg225 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg225  = dateFormatarg225.parse(arg2_4id);
         arg2_4idTemp = new java.util.GregorianCalendar();
        arg2_4idTemp.setTime(dateTemparg225);
        }
        sampleControladorCursoPublishProxyid.inscribirEstudianteEdicion(arg0_2idTemp,arg1_3idTemp,arg2_4idTemp);
break;
case 27:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg030");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        String arg1_6id=  request.getParameter("arg132");
            java.lang.String arg1_6idTemp = null;
        if(!arg1_6id.equals("")){
         arg1_6idTemp  = arg1_6id;
        }
        String arg2_7id=  request.getParameter("arg234");
            java.util.Calendar arg2_7idTemp = null;
        if(!arg2_7id.equals("")){
        java.text.DateFormat dateFormatarg234 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg234  = dateFormatarg234.parse(arg2_7id);
         arg2_7idTemp = new java.util.GregorianCalendar();
        arg2_7idTemp.setTime(dateTemparg234);
        }
        String arg3_8id=  request.getParameter("arg336");
            java.util.Calendar arg3_8idTemp = null;
        if(!arg3_8id.equals("")){
        java.text.DateFormat dateFormatarg336 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg336  = dateFormatarg336.parse(arg3_8id);
         arg3_8idTemp = new java.util.GregorianCalendar();
        arg3_8idTemp.setTime(dateTemparg336);
        }
        String arg4_9id=  request.getParameter("arg438");
            java.util.Calendar arg4_9idTemp = null;
        if(!arg4_9id.equals("")){
        java.text.DateFormat dateFormatarg438 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg438  = dateFormatarg438.parse(arg4_9id);
         arg4_9idTemp = new java.util.GregorianCalendar();
        arg4_9idTemp.setTime(dateTemparg438);
        }
        String arg5_10id=  request.getParameter("arg540");
            java.lang.String arg5_10idTemp = null;
        if(!arg5_10id.equals("")){
         arg5_10idTemp  = arg5_10id;
        }
        sampleControladorCursoPublishProxyid.crearProgramaFormacion(arg0_5idTemp,arg1_6idTemp,arg2_7idTemp,arg3_8idTemp,arg4_9idTemp,arg5_10idTemp);
break;
case 42:
        gotMethod = true;
        String arg0_11id=  request.getParameter("arg059");
            java.lang.String arg0_11idTemp = null;
        if(!arg0_11id.equals("")){
         arg0_11idTemp  = arg0_11id;
        }
        publicadores.DtEdicionCurso mostrarEdicionVigente42mtemp = sampleControladorCursoPublishProxyid.mostrarEdicionVigente(arg0_11idTemp);
if(mostrarEdicionVigente42mtemp == null){
%>
<%=mostrarEdicionVigente42mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagenURL:</TD>
<TD>
<%
if(mostrarEdicionVigente42mtemp != null){
java.lang.String typeimagenURL45 = mostrarEdicionVigente42mtemp.getImagenURL();
        String tempResultimagenURL45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL45));
        %>
        <%= tempResultimagenURL45 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(mostrarEdicionVigente42mtemp != null){
java.util.Calendar typefechaI47 = mostrarEdicionVigente42mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI47 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI47 = typefechaI47.getTime();
        String tempResultfechaI47 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI47.format(datefechaI47));
        %>
        <%= tempResultfechaI47 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(mostrarEdicionVigente42mtemp != null){
java.util.Calendar typefechaF49 = mostrarEdicionVigente42mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF49 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF49 = typefechaF49.getTime();
        String tempResultfechaF49 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF49.format(datefechaF49));
        %>
        <%= tempResultfechaF49 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cupo:</TD>
<TD>
<%
if(mostrarEdicionVigente42mtemp != null){
%>
<%=mostrarEdicionVigente42mtemp.getCupo()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">curso:</TD>
<TD>
<%
if(mostrarEdicionVigente42mtemp != null){
java.lang.String typecurso53 = mostrarEdicionVigente42mtemp.getCurso();
        String tempResultcurso53 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecurso53));
        %>
        <%= tempResultcurso53 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaPub:</TD>
<TD>
<%
if(mostrarEdicionVigente42mtemp != null){
java.util.Calendar typefechaPub55 = mostrarEdicionVigente42mtemp.getFechaPub();
        java.text.DateFormat dateFormatfechaPub55 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaPub55 = typefechaPub55.getTime();
        String tempResultfechaPub55 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaPub55.format(datefechaPub55));
        %>
        <%= tempResultfechaPub55 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(mostrarEdicionVigente42mtemp != null){
java.lang.String typenombre57 = mostrarEdicionVigente42mtemp.getNombre();
        String tempResultnombre57 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre57));
        %>
        <%= tempResultnombre57 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 61:
        gotMethod = true;
        String arg0_12id=  request.getParameter("arg064");
            java.lang.String arg0_12idTemp = null;
        if(!arg0_12id.equals("")){
         arg0_12idTemp  = arg0_12id;
        }
        String arg1_13id=  request.getParameter("arg166");
            java.lang.String arg1_13idTemp = null;
        if(!arg1_13id.equals("")){
         arg1_13idTemp  = arg1_13id;
        }
        sampleControladorCursoPublishProxyid.agregarCursoPrograma(arg0_12idTemp,arg1_13idTemp);
break;
case 68:
        gotMethod = true;
        String arg0_14id=  request.getParameter("arg071");
            java.lang.String arg0_14idTemp = null;
        if(!arg0_14id.equals("")){
         arg0_14idTemp  = arg0_14id;
        }
        java.lang.String[] getCategoriasPrograma68mtemp = sampleControladorCursoPublishProxyid.getCategoriasPrograma(arg0_14idTemp);
if(getCategoriasPrograma68mtemp == null){
%>
<%=getCategoriasPrograma68mtemp %>
<%
}else{
        String tempreturnp69 = null;
        if(getCategoriasPrograma68mtemp != null){
        java.util.List listreturnp69= java.util.Arrays.asList(getCategoriasPrograma68mtemp);
        tempreturnp69 = listreturnp69.toString();
        }
        %>
        <%=tempreturnp69%>
        <%
}
break;
case 73:
        gotMethod = true;
        String arg0_15id=  request.getParameter("arg076");
            java.lang.String arg0_15idTemp = null;
        if(!arg0_15id.equals("")){
         arg0_15idTemp  = arg0_15id;
        }
        java.lang.String[] listarCursosAux73mtemp = sampleControladorCursoPublishProxyid.listarCursosAux(arg0_15idTemp);
if(listarCursosAux73mtemp == null){
%>
<%=listarCursosAux73mtemp %>
<%
}else{
        String tempreturnp74 = null;
        if(listarCursosAux73mtemp != null){
        java.util.List listreturnp74= java.util.Arrays.asList(listarCursosAux73mtemp);
        tempreturnp74 = listreturnp74.toString();
        }
        %>
        <%=tempreturnp74%>
        <%
}
break;
case 78:
        gotMethod = true;
        String arg0_16id=  request.getParameter("arg081");
            java.lang.String arg0_16idTemp = null;
        if(!arg0_16id.equals("")){
         arg0_16idTemp  = arg0_16id;
        }
        java.lang.String[] listarCursosInst78mtemp = sampleControladorCursoPublishProxyid.listarCursosInst(arg0_16idTemp);
if(listarCursosInst78mtemp == null){
%>
<%=listarCursosInst78mtemp %>
<%
}else{
        String tempreturnp79 = null;
        if(listarCursosInst78mtemp != null){
        java.util.List listreturnp79= java.util.Arrays.asList(listarCursosInst78mtemp);
        tempreturnp79 = listreturnp79.toString();
        }
        %>
        <%=tempreturnp79%>
        <%
}
break;
case 83:
        gotMethod = true;
        java.lang.String[] listarCursos83mtemp = sampleControladorCursoPublishProxyid.listarCursos();
if(listarCursos83mtemp == null){
%>
<%=listarCursos83mtemp %>
<%
}else{
        String tempreturnp84 = null;
        if(listarCursos83mtemp != null){
        java.util.List listreturnp84= java.util.Arrays.asList(listarCursos83mtemp);
        tempreturnp84 = listreturnp84.toString();
        }
        %>
        <%=tempreturnp84%>
        <%
}
break;
case 86:
        gotMethod = true;
        java.lang.String[] listarCategorias86mtemp = sampleControladorCursoPublishProxyid.listarCategorias();
if(listarCategorias86mtemp == null){
%>
<%=listarCategorias86mtemp %>
<%
}else{
        String tempreturnp87 = null;
        if(listarCategorias86mtemp != null){
        java.util.List listreturnp87= java.util.Arrays.asList(listarCategorias86mtemp);
        tempreturnp87 = listreturnp87.toString();
        }
        %>
        <%=tempreturnp87%>
        <%
}
break;
case 89:
        gotMethod = true;
        java.lang.String[] listarInstitutos89mtemp = sampleControladorCursoPublishProxyid.listarInstitutos();
if(listarInstitutos89mtemp == null){
%>
<%=listarInstitutos89mtemp %>
<%
}else{
        String tempreturnp90 = null;
        if(listarInstitutos89mtemp != null){
        java.util.List listreturnp90= java.util.Arrays.asList(listarInstitutos89mtemp);
        tempreturnp90 = listreturnp90.toString();
        }
        %>
        <%=tempreturnp90%>
        <%
}
break;
case 92:
        gotMethod = true;
        String arg0_17id=  request.getParameter("arg095");
            java.lang.String arg0_17idTemp = null;
        if(!arg0_17id.equals("")){
         arg0_17idTemp  = arg0_17id;
        }
        sampleControladorCursoPublishProxyid.verInfo(arg0_17idTemp);
break;
case 97:
        gotMethod = true;
        String arg0_18id=  request.getParameter("arg0100");
            java.lang.String arg0_18idTemp = null;
        if(!arg0_18id.equals("")){
         arg0_18idTemp  = arg0_18id;
        }
        java.lang.String[] listarDocentesAux97mtemp = sampleControladorCursoPublishProxyid.listarDocentesAux(arg0_18idTemp);
if(listarDocentesAux97mtemp == null){
%>
<%=listarDocentesAux97mtemp %>
<%
}else{
        String tempreturnp98 = null;
        if(listarDocentesAux97mtemp != null){
        java.util.List listreturnp98= java.util.Arrays.asList(listarDocentesAux97mtemp);
        tempreturnp98 = listreturnp98.toString();
        }
        %>
        <%=tempreturnp98%>
        <%
}
break;
case 102:
        gotMethod = true;
        java.lang.String[] listarEstudiantes102mtemp = sampleControladorCursoPublishProxyid.listarEstudiantes();
if(listarEstudiantes102mtemp == null){
%>
<%=listarEstudiantes102mtemp %>
<%
}else{
        String tempreturnp103 = null;
        if(listarEstudiantes102mtemp != null){
        java.util.List listreturnp103= java.util.Arrays.asList(listarEstudiantes102mtemp);
        tempreturnp103 = listreturnp103.toString();
        }
        %>
        <%=tempreturnp103%>
        <%
}
break;
case 105:
        gotMethod = true;
        String arg0_19id=  request.getParameter("arg0122");
            java.lang.String arg0_19idTemp = null;
        if(!arg0_19id.equals("")){
         arg0_19idTemp  = arg0_19id;
        }
        publicadores.DtEdicionCurso verInfoEdicion105mtemp = sampleControladorCursoPublishProxyid.verInfoEdicion(arg0_19idTemp);
if(verInfoEdicion105mtemp == null){
%>
<%=verInfoEdicion105mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagenURL:</TD>
<TD>
<%
if(verInfoEdicion105mtemp != null){
java.lang.String typeimagenURL108 = verInfoEdicion105mtemp.getImagenURL();
        String tempResultimagenURL108 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL108));
        %>
        <%= tempResultimagenURL108 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(verInfoEdicion105mtemp != null){
java.util.Calendar typefechaI110 = verInfoEdicion105mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI110 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI110 = typefechaI110.getTime();
        String tempResultfechaI110 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI110.format(datefechaI110));
        %>
        <%= tempResultfechaI110 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(verInfoEdicion105mtemp != null){
java.util.Calendar typefechaF112 = verInfoEdicion105mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF112 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF112 = typefechaF112.getTime();
        String tempResultfechaF112 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF112.format(datefechaF112));
        %>
        <%= tempResultfechaF112 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cupo:</TD>
<TD>
<%
if(verInfoEdicion105mtemp != null){
%>
<%=verInfoEdicion105mtemp.getCupo()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">curso:</TD>
<TD>
<%
if(verInfoEdicion105mtemp != null){
java.lang.String typecurso116 = verInfoEdicion105mtemp.getCurso();
        String tempResultcurso116 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecurso116));
        %>
        <%= tempResultcurso116 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaPub:</TD>
<TD>
<%
if(verInfoEdicion105mtemp != null){
java.util.Calendar typefechaPub118 = verInfoEdicion105mtemp.getFechaPub();
        java.text.DateFormat dateFormatfechaPub118 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaPub118 = typefechaPub118.getTime();
        String tempResultfechaPub118 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaPub118.format(datefechaPub118));
        %>
        <%= tempResultfechaPub118 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoEdicion105mtemp != null){
java.lang.String typenombre120 = verInfoEdicion105mtemp.getNombre();
        String tempResultnombre120 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre120));
        %>
        <%= tempResultnombre120 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 124:
        gotMethod = true;
        java.lang.String[] listarProgramas124mtemp = sampleControladorCursoPublishProxyid.listarProgramas();
if(listarProgramas124mtemp == null){
%>
<%=listarProgramas124mtemp %>
<%
}else{
        String tempreturnp125 = null;
        if(listarProgramas124mtemp != null){
        java.util.List listreturnp125= java.util.Arrays.asList(listarProgramas124mtemp);
        tempreturnp125 = listreturnp125.toString();
        }
        %>
        <%=tempreturnp125%>
        <%
}
break;
case 127:
        gotMethod = true;
        String arg0_20id=  request.getParameter("arg0142");
            java.lang.String arg0_20idTemp = null;
        if(!arg0_20id.equals("")){
         arg0_20idTemp  = arg0_20id;
        }
        publicadores.DtProgramaFormacion verInfoPrograma127mtemp = sampleControladorCursoPublishProxyid.verInfoPrograma(arg0_20idTemp);
if(verInfoPrograma127mtemp == null){
%>
<%=verInfoPrograma127mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagenURL:</TD>
<TD>
<%
if(verInfoPrograma127mtemp != null){
java.lang.String typeimagenURL130 = verInfoPrograma127mtemp.getImagenURL();
        String tempResultimagenURL130 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL130));
        %>
        <%= tempResultimagenURL130 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(verInfoPrograma127mtemp != null){
java.lang.String typedescripcion132 = verInfoPrograma127mtemp.getDescripcion();
        String tempResultdescripcion132 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion132));
        %>
        <%= tempResultdescripcion132 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(verInfoPrograma127mtemp != null){
java.util.Calendar typefechaI134 = verInfoPrograma127mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI134 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI134 = typefechaI134.getTime();
        String tempResultfechaI134 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI134.format(datefechaI134));
        %>
        <%= tempResultfechaI134 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(verInfoPrograma127mtemp != null){
java.util.Calendar typefechaF136 = verInfoPrograma127mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF136 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF136 = typefechaF136.getTime();
        String tempResultfechaF136 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF136.format(datefechaF136));
        %>
        <%= tempResultfechaF136 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaA:</TD>
<TD>
<%
if(verInfoPrograma127mtemp != null){
java.util.Calendar typefechaA138 = verInfoPrograma127mtemp.getFechaA();
        java.text.DateFormat dateFormatfechaA138 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaA138 = typefechaA138.getTime();
        String tempResultfechaA138 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaA138.format(datefechaA138));
        %>
        <%= tempResultfechaA138 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoPrograma127mtemp != null){
java.lang.String typenombre140 = verInfoPrograma127mtemp.getNombre();
        String tempResultnombre140 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre140));
        %>
        <%= tempResultnombre140 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 144:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0147");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        String arg1_22id=  request.getParameter("arg1149");
            java.lang.String arg1_22idTemp = null;
        if(!arg1_22id.equals("")){
         arg1_22idTemp  = arg1_22id;
        }
        String arg2_23id=  request.getParameter("arg2151");
            java.util.Calendar arg2_23idTemp = null;
        if(!arg2_23id.equals("")){
        java.text.DateFormat dateFormatarg2151 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2151  = dateFormatarg2151.parse(arg2_23id);
         arg2_23idTemp = new java.util.GregorianCalendar();
        arg2_23idTemp.setTime(dateTemparg2151);
        }
        sampleControladorCursoPublishProxyid.inscribirEstudiantePrograma(arg0_21idTemp,arg1_22idTemp,arg2_23idTemp);
break;
case 153:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0156");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        java.lang.String[] listarEdiciones153mtemp = sampleControladorCursoPublishProxyid.listarEdiciones(arg0_24idTemp);
if(listarEdiciones153mtemp == null){
%>
<%=listarEdiciones153mtemp %>
<%
}else{
        String tempreturnp154 = null;
        if(listarEdiciones153mtemp != null){
        java.util.List listreturnp154= java.util.Arrays.asList(listarEdiciones153mtemp);
        tempreturnp154 = listreturnp154.toString();
        }
        %>
        <%=tempreturnp154%>
        <%
}
break;
case 158:
        gotMethod = true;
        publicadores.DtCurso[] listaDTCurso158mtemp = sampleControladorCursoPublishProxyid.listaDTCurso();
if(listaDTCurso158mtemp == null){
%>
<%=listaDTCurso158mtemp %>
<%
}else{
        String tempreturnp159 = null;
        if(listaDTCurso158mtemp != null){
        java.util.List listreturnp159= java.util.Arrays.asList(listaDTCurso158mtemp);
        tempreturnp159 = listreturnp159.toString();
        }
        %>
        <%=tempreturnp159%>
        <%
}
break;
case 161:
        gotMethod = true;
        publicadores.DtProgramaFormacion[] listaDTPrograma161mtemp = sampleControladorCursoPublishProxyid.listaDTPrograma();
if(listaDTPrograma161mtemp == null){
%>
<%=listaDTPrograma161mtemp %>
<%
}else{
        String tempreturnp162 = null;
        if(listaDTPrograma161mtemp != null){
        java.util.List listreturnp162= java.util.Arrays.asList(listaDTPrograma161mtemp);
        tempreturnp162 = listreturnp162.toString();
        }
        %>
        <%=tempreturnp162%>
        <%
}
break;
case 164:
        gotMethod = true;
        String arg0_25id=  request.getParameter("arg0167");
            java.lang.String arg0_25idTemp = null;
        if(!arg0_25id.equals("")){
         arg0_25idTemp  = arg0_25id;
        }
        java.lang.String[] listarCursosCat164mtemp = sampleControladorCursoPublishProxyid.listarCursosCat(arg0_25idTemp);
if(listarCursosCat164mtemp == null){
%>
<%=listarCursosCat164mtemp %>
<%
}else{
        String tempreturnp165 = null;
        if(listarCursosCat164mtemp != null){
        java.util.List listreturnp165= java.util.Arrays.asList(listarCursosCat164mtemp);
        tempreturnp165 = listreturnp165.toString();
        }
        %>
        <%=tempreturnp165%>
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