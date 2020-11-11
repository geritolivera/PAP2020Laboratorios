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
        java.lang.String[] listarCursosInst13mtemp = sampleControladorCursoPublishProxyid.listarCursosInst(arg0_1idTemp);
if(listarCursosInst13mtemp == null){
%>
<%=listarCursosInst13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(listarCursosInst13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(listarCursosInst13mtemp);
        tempreturnp14 = listreturnp14.toString();
        }
        %>
        <%=tempreturnp14%>
        <%
}
break;
case 18:
        gotMethod = true;
        java.lang.String[] listarCursos18mtemp = sampleControladorCursoPublishProxyid.listarCursos();
if(listarCursos18mtemp == null){
%>
<%=listarCursos18mtemp %>
<%
}else{
        String tempreturnp19 = null;
        if(listarCursos18mtemp != null){
        java.util.List listreturnp19= java.util.Arrays.asList(listarCursos18mtemp);
        tempreturnp19 = listreturnp19.toString();
        }
        %>
        <%=tempreturnp19%>
        <%
}
break;
case 21:
        gotMethod = true;
        java.lang.String[] listarCategorias21mtemp = sampleControladorCursoPublishProxyid.listarCategorias();
if(listarCategorias21mtemp == null){
%>
<%=listarCategorias21mtemp %>
<%
}else{
        String tempreturnp22 = null;
        if(listarCategorias21mtemp != null){
        java.util.List listreturnp22= java.util.Arrays.asList(listarCategorias21mtemp);
        tempreturnp22 = listreturnp22.toString();
        }
        %>
        <%=tempreturnp22%>
        <%
}
break;
case 24:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg027");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        java.lang.String[] listarCursosAux24mtemp = sampleControladorCursoPublishProxyid.listarCursosAux(arg0_2idTemp);
if(listarCursosAux24mtemp == null){
%>
<%=listarCursosAux24mtemp %>
<%
}else{
        String tempreturnp25 = null;
        if(listarCursosAux24mtemp != null){
        java.util.List listreturnp25= java.util.Arrays.asList(listarCursosAux24mtemp);
        tempreturnp25 = listreturnp25.toString();
        }
        %>
        <%=tempreturnp25%>
        <%
}
break;
case 29:
        gotMethod = true;
        java.lang.String[] listarInstitutos29mtemp = sampleControladorCursoPublishProxyid.listarInstitutos();
if(listarInstitutos29mtemp == null){
%>
<%=listarInstitutos29mtemp %>
<%
}else{
        String tempreturnp30 = null;
        if(listarInstitutos29mtemp != null){
        java.util.List listreturnp30= java.util.Arrays.asList(listarInstitutos29mtemp);
        tempreturnp30 = listreturnp30.toString();
        }
        %>
        <%=tempreturnp30%>
        <%
}
break;
case 32:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg035");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        sampleControladorCursoPublishProxyid.verInfo(arg0_3idTemp);
break;
case 37:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg040");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        java.lang.String[] listarDocentesAux37mtemp = sampleControladorCursoPublishProxyid.listarDocentesAux(arg0_4idTemp);
if(listarDocentesAux37mtemp == null){
%>
<%=listarDocentesAux37mtemp %>
<%
}else{
        String tempreturnp38 = null;
        if(listarDocentesAux37mtemp != null){
        java.util.List listreturnp38= java.util.Arrays.asList(listarDocentesAux37mtemp);
        tempreturnp38 = listreturnp38.toString();
        }
        %>
        <%=tempreturnp38%>
        <%
}
break;
case 42:
        gotMethod = true;
        java.lang.String[] listarEstudiantes42mtemp = sampleControladorCursoPublishProxyid.listarEstudiantes();
if(listarEstudiantes42mtemp == null){
%>
<%=listarEstudiantes42mtemp %>
<%
}else{
        String tempreturnp43 = null;
        if(listarEstudiantes42mtemp != null){
        java.util.List listreturnp43= java.util.Arrays.asList(listarEstudiantes42mtemp);
        tempreturnp43 = listreturnp43.toString();
        }
        %>
        <%=tempreturnp43%>
        <%
}
break;
case 45:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg048");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        java.lang.String[] getCategoriasPrograma45mtemp = sampleControladorCursoPublishProxyid.getCategoriasPrograma(arg0_5idTemp);
if(getCategoriasPrograma45mtemp == null){
%>
<%=getCategoriasPrograma45mtemp %>
<%
}else{
        String tempreturnp46 = null;
        if(getCategoriasPrograma45mtemp != null){
        java.util.List listreturnp46= java.util.Arrays.asList(getCategoriasPrograma45mtemp);
        tempreturnp46 = listreturnp46.toString();
        }
        %>
        <%=tempreturnp46%>
        <%
}
break;
case 50:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg065");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        publicadores.DtEdicionCurso verInfoEdicion50mtemp = sampleControladorCursoPublishProxyid.verInfoEdicion(arg0_6idTemp);
if(verInfoEdicion50mtemp == null){
%>
<%=verInfoEdicion50mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaPub:</TD>
<TD>
<%
if(verInfoEdicion50mtemp != null){
java.util.Calendar typefechaPub53 = verInfoEdicion50mtemp.getFechaPub();
        java.text.DateFormat dateFormatfechaPub53 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaPub53 = typefechaPub53.getTime();
        String tempResultfechaPub53 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaPub53.format(datefechaPub53));
        %>
        <%= tempResultfechaPub53 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(verInfoEdicion50mtemp != null){
java.util.Calendar typefechaI55 = verInfoEdicion50mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI55 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI55 = typefechaI55.getTime();
        String tempResultfechaI55 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI55.format(datefechaI55));
        %>
        <%= tempResultfechaI55 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(verInfoEdicion50mtemp != null){
java.util.Calendar typefechaF57 = verInfoEdicion50mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF57 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF57 = typefechaF57.getTime();
        String tempResultfechaF57 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF57.format(datefechaF57));
        %>
        <%= tempResultfechaF57 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagenURL:</TD>
<TD>
<%
if(verInfoEdicion50mtemp != null){
java.lang.String typeimagenURL59 = verInfoEdicion50mtemp.getImagenURL();
        String tempResultimagenURL59 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL59));
        %>
        <%= tempResultimagenURL59 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cupo:</TD>
<TD>
<%
if(verInfoEdicion50mtemp != null){
%>
<%=verInfoEdicion50mtemp.getCupo()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoEdicion50mtemp != null){
java.lang.String typenombre63 = verInfoEdicion50mtemp.getNombre();
        String tempResultnombre63 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre63));
        %>
        <%= tempResultnombre63 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 67:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg082");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        publicadores.DtProgramaFormacion verInfoPrograma67mtemp = sampleControladorCursoPublishProxyid.verInfoPrograma(arg0_7idTemp);
if(verInfoPrograma67mtemp == null){
%>
<%=verInfoPrograma67mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(verInfoPrograma67mtemp != null){
java.util.Calendar typefechaI70 = verInfoPrograma67mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI70 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI70 = typefechaI70.getTime();
        String tempResultfechaI70 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI70.format(datefechaI70));
        %>
        <%= tempResultfechaI70 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(verInfoPrograma67mtemp != null){
java.lang.String typedescripcion72 = verInfoPrograma67mtemp.getDescripcion();
        String tempResultdescripcion72 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion72));
        %>
        <%= tempResultdescripcion72 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(verInfoPrograma67mtemp != null){
java.util.Calendar typefechaF74 = verInfoPrograma67mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF74 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF74 = typefechaF74.getTime();
        String tempResultfechaF74 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF74.format(datefechaF74));
        %>
        <%= tempResultfechaF74 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagenURL:</TD>
<TD>
<%
if(verInfoPrograma67mtemp != null){
java.lang.String typeimagenURL76 = verInfoPrograma67mtemp.getImagenURL();
        String tempResultimagenURL76 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL76));
        %>
        <%= tempResultimagenURL76 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoPrograma67mtemp != null){
java.lang.String typenombre78 = verInfoPrograma67mtemp.getNombre();
        String tempResultnombre78 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre78));
        %>
        <%= tempResultnombre78 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaA:</TD>
<TD>
<%
if(verInfoPrograma67mtemp != null){
java.util.Calendar typefechaA80 = verInfoPrograma67mtemp.getFechaA();
        java.text.DateFormat dateFormatfechaA80 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaA80 = typefechaA80.getTime();
        String tempResultfechaA80 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaA80.format(datefechaA80));
        %>
        <%= tempResultfechaA80 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 84:
        gotMethod = true;
        java.lang.String[] listarProgramas84mtemp = sampleControladorCursoPublishProxyid.listarProgramas();
if(listarProgramas84mtemp == null){
%>
<%=listarProgramas84mtemp %>
<%
}else{
        String tempreturnp85 = null;
        if(listarProgramas84mtemp != null){
        java.util.List listreturnp85= java.util.Arrays.asList(listarProgramas84mtemp);
        tempreturnp85 = listreturnp85.toString();
        }
        %>
        <%=tempreturnp85%>
        <%
}
break;
case 87:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg090");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        java.lang.String[] listarDocentesInstituto87mtemp = sampleControladorCursoPublishProxyid.listarDocentesInstituto(arg0_8idTemp);
if(listarDocentesInstituto87mtemp == null){
%>
<%=listarDocentesInstituto87mtemp %>
<%
}else{
        String tempreturnp88 = null;
        if(listarDocentesInstituto87mtemp != null){
        java.util.List listreturnp88= java.util.Arrays.asList(listarDocentesInstituto87mtemp);
        tempreturnp88 = listreturnp88.toString();
        }
        %>
        <%=tempreturnp88%>
        <%
}
break;
case 92:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg0107");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        publicadores.DtEdicionCurso mostrarEdicionVigente92mtemp = sampleControladorCursoPublishProxyid.mostrarEdicionVigente(arg0_9idTemp);
if(mostrarEdicionVigente92mtemp == null){
%>
<%=mostrarEdicionVigente92mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaPub:</TD>
<TD>
<%
if(mostrarEdicionVigente92mtemp != null){
java.util.Calendar typefechaPub95 = mostrarEdicionVigente92mtemp.getFechaPub();
        java.text.DateFormat dateFormatfechaPub95 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaPub95 = typefechaPub95.getTime();
        String tempResultfechaPub95 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaPub95.format(datefechaPub95));
        %>
        <%= tempResultfechaPub95 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(mostrarEdicionVigente92mtemp != null){
java.util.Calendar typefechaI97 = mostrarEdicionVigente92mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI97 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI97 = typefechaI97.getTime();
        String tempResultfechaI97 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI97.format(datefechaI97));
        %>
        <%= tempResultfechaI97 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(mostrarEdicionVigente92mtemp != null){
java.util.Calendar typefechaF99 = mostrarEdicionVigente92mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF99 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF99 = typefechaF99.getTime();
        String tempResultfechaF99 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF99.format(datefechaF99));
        %>
        <%= tempResultfechaF99 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagenURL:</TD>
<TD>
<%
if(mostrarEdicionVigente92mtemp != null){
java.lang.String typeimagenURL101 = mostrarEdicionVigente92mtemp.getImagenURL();
        String tempResultimagenURL101 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL101));
        %>
        <%= tempResultimagenURL101 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cupo:</TD>
<TD>
<%
if(mostrarEdicionVigente92mtemp != null){
%>
<%=mostrarEdicionVigente92mtemp.getCupo()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(mostrarEdicionVigente92mtemp != null){
java.lang.String typenombre105 = mostrarEdicionVigente92mtemp.getNombre();
        String tempResultnombre105 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre105));
        %>
        <%= tempResultnombre105 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 109:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg0112");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        String arg1_11id=  request.getParameter("arg1114");
            java.lang.String arg1_11idTemp = null;
        if(!arg1_11id.equals("")){
         arg1_11idTemp  = arg1_11id;
        }
        String arg2_12id=  request.getParameter("arg2116");
            java.util.Calendar arg2_12idTemp = null;
        if(!arg2_12id.equals("")){
        java.text.DateFormat dateFormatarg2116 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2116  = dateFormatarg2116.parse(arg2_12id);
         arg2_12idTemp = new java.util.GregorianCalendar();
        arg2_12idTemp.setTime(dateTemparg2116);
        }
        String arg3_13id=  request.getParameter("arg3118");
            java.util.Calendar arg3_13idTemp = null;
        if(!arg3_13id.equals("")){
        java.text.DateFormat dateFormatarg3118 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3118  = dateFormatarg3118.parse(arg3_13id);
         arg3_13idTemp = new java.util.GregorianCalendar();
        arg3_13idTemp.setTime(dateTemparg3118);
        }
        String arg4_14id=  request.getParameter("arg4120");
            java.util.Calendar arg4_14idTemp = null;
        if(!arg4_14id.equals("")){
        java.text.DateFormat dateFormatarg4120 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4120  = dateFormatarg4120.parse(arg4_14id);
         arg4_14idTemp = new java.util.GregorianCalendar();
        arg4_14idTemp.setTime(dateTemparg4120);
        }
        String arg5_15id=  request.getParameter("arg5122");
            java.lang.String arg5_15idTemp = null;
        if(!arg5_15id.equals("")){
         arg5_15idTemp  = arg5_15id;
        }
        sampleControladorCursoPublishProxyid.crearProgramaFormacion(arg0_10idTemp,arg1_11idTemp,arg2_12idTemp,arg3_13idTemp,arg4_14idTemp,arg5_15idTemp);
break;
case 124:
        gotMethod = true;
        String arg0_16id=  request.getParameter("arg0127");
            java.lang.String arg0_16idTemp = null;
        if(!arg0_16id.equals("")){
         arg0_16idTemp  = arg0_16id;
        }
        String arg1_17id=  request.getParameter("arg1129");
            java.lang.String arg1_17idTemp = null;
        if(!arg1_17id.equals("")){
         arg1_17idTemp  = arg1_17id;
        }
        sampleControladorCursoPublishProxyid.agregarCursoPrograma(arg0_16idTemp,arg1_17idTemp);
break;
case 131:
        gotMethod = true;
        String arg0_18id=  request.getParameter("arg0134");
            java.lang.String arg0_18idTemp = null;
        if(!arg0_18id.equals("")){
         arg0_18idTemp  = arg0_18id;
        }
        String arg1_19id=  request.getParameter("arg1136");
            java.lang.String arg1_19idTemp = null;
        if(!arg1_19id.equals("")){
         arg1_19idTemp  = arg1_19id;
        }
        String arg2_20id=  request.getParameter("arg2138");
            java.util.Calendar arg2_20idTemp = null;
        if(!arg2_20id.equals("")){
        java.text.DateFormat dateFormatarg2138 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2138  = dateFormatarg2138.parse(arg2_20id);
         arg2_20idTemp = new java.util.GregorianCalendar();
        arg2_20idTemp.setTime(dateTemparg2138);
        }
        sampleControladorCursoPublishProxyid.inscribirEstudianteEdicion(arg0_18idTemp,arg1_19idTemp,arg2_20idTemp);
break;
case 140:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0143");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        String arg1_22id=  request.getParameter("arg1145");
            java.lang.String arg1_22idTemp = null;
        if(!arg1_22id.equals("")){
         arg1_22idTemp  = arg1_22id;
        }
        String arg2_23id=  request.getParameter("arg2147");
            java.util.Calendar arg2_23idTemp = null;
        if(!arg2_23id.equals("")){
        java.text.DateFormat dateFormatarg2147 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2147  = dateFormatarg2147.parse(arg2_23id);
         arg2_23idTemp = new java.util.GregorianCalendar();
        arg2_23idTemp.setTime(dateTemparg2147);
        }
        sampleControladorCursoPublishProxyid.inscribirEstudiantePrograma(arg0_21idTemp,arg1_22idTemp,arg2_23idTemp);
break;
case 149:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0152");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        java.lang.String[] listarEdiciones149mtemp = sampleControladorCursoPublishProxyid.listarEdiciones(arg0_24idTemp);
if(listarEdiciones149mtemp == null){
%>
<%=listarEdiciones149mtemp %>
<%
}else{
        String tempreturnp150 = null;
        if(listarEdiciones149mtemp != null){
        java.util.List listreturnp150= java.util.Arrays.asList(listarEdiciones149mtemp);
        tempreturnp150 = listreturnp150.toString();
        }
        %>
        <%=tempreturnp150%>
        <%
}
break;
case 154:
        gotMethod = true;
        publicadores.DtCurso[] listaDTCurso154mtemp = sampleControladorCursoPublishProxyid.listaDTCurso();
if(listaDTCurso154mtemp == null){
%>
<%=listaDTCurso154mtemp %>
<%
}else{
        String tempreturnp155 = null;
        if(listaDTCurso154mtemp != null){
        java.util.List listreturnp155= java.util.Arrays.asList(listaDTCurso154mtemp);
        tempreturnp155 = listreturnp155.toString();
        }
        %>
        <%=tempreturnp155%>
        <%
}
break;
case 157:
        gotMethod = true;
        String arg0_25id=  request.getParameter("arg0160");
            java.lang.String arg0_25idTemp = null;
        if(!arg0_25id.equals("")){
         arg0_25idTemp  = arg0_25id;
        }
        java.lang.String[] listarCursosCat157mtemp = sampleControladorCursoPublishProxyid.listarCursosCat(arg0_25idTemp);
if(listarCursosCat157mtemp == null){
%>
<%=listarCursosCat157mtemp %>
<%
}else{
        String tempreturnp158 = null;
        if(listarCursosCat157mtemp != null){
        java.util.List listreturnp158= java.util.Arrays.asList(listarCursosCat157mtemp);
        tempreturnp158 = listreturnp158.toString();
        }
        %>
        <%=tempreturnp158%>
        <%
}
break;
case 162:
        gotMethod = true;
        publicadores.DtProgramaFormacion[] listaDTPrograma162mtemp = sampleControladorCursoPublishProxyid.listaDTPrograma();
if(listaDTPrograma162mtemp == null){
%>
<%=listaDTPrograma162mtemp %>
<%
}else{
        String tempreturnp163 = null;
        if(listaDTPrograma162mtemp != null){
        java.util.List listreturnp163= java.util.Arrays.asList(listaDTPrograma162mtemp);
        tempreturnp163 = listreturnp163.toString();
        }
        %>
        <%=tempreturnp163%>
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