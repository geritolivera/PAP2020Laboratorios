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
        java.lang.String[] listarProgramas13mtemp = sampleControladorCursoPublishProxyid.listarProgramas();
if(listarProgramas13mtemp == null){
%>
<%=listarProgramas13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(listarProgramas13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(listarProgramas13mtemp);
        tempreturnp14 = listreturnp14.toString();
        }
        %>
        <%=tempreturnp14%>
        <%
}
break;
case 16:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg033");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        publicadores.DtEdicionCurso verInfoEdicion16mtemp = sampleControladorCursoPublishProxyid.verInfoEdicion(arg0_1idTemp);
if(verInfoEdicion16mtemp == null){
%>
<%=verInfoEdicion16mtemp %>
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
if(verInfoEdicion16mtemp != null){
java.lang.String typeimagenURL19 = verInfoEdicion16mtemp.getImagenURL();
        String tempResultimagenURL19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL19));
        %>
        <%= tempResultimagenURL19 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(verInfoEdicion16mtemp != null){
java.util.Calendar typefechaI21 = verInfoEdicion16mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI21 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI21 = typefechaI21.getTime();
        String tempResultfechaI21 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI21.format(datefechaI21));
        %>
        <%= tempResultfechaI21 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(verInfoEdicion16mtemp != null){
java.util.Calendar typefechaF23 = verInfoEdicion16mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF23 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF23 = typefechaF23.getTime();
        String tempResultfechaF23 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF23.format(datefechaF23));
        %>
        <%= tempResultfechaF23 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cupo:</TD>
<TD>
<%
if(verInfoEdicion16mtemp != null){
%>
<%=verInfoEdicion16mtemp.getCupo()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">curso:</TD>
<TD>
<%
if(verInfoEdicion16mtemp != null){
java.lang.String typecurso27 = verInfoEdicion16mtemp.getCurso();
        String tempResultcurso27 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecurso27));
        %>
        <%= tempResultcurso27 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaPub:</TD>
<TD>
<%
if(verInfoEdicion16mtemp != null){
java.util.Calendar typefechaPub29 = verInfoEdicion16mtemp.getFechaPub();
        java.text.DateFormat dateFormatfechaPub29 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaPub29 = typefechaPub29.getTime();
        String tempResultfechaPub29 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaPub29.format(datefechaPub29));
        %>
        <%= tempResultfechaPub29 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoEdicion16mtemp != null){
java.lang.String typenombre31 = verInfoEdicion16mtemp.getNombre();
        String tempResultnombre31 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre31));
        %>
        <%= tempResultnombre31 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 35:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg050");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        publicadores.DtProgramaFormacion verInfoPrograma35mtemp = sampleControladorCursoPublishProxyid.verInfoPrograma(arg0_2idTemp);
if(verInfoPrograma35mtemp == null){
%>
<%=verInfoPrograma35mtemp %>
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
if(verInfoPrograma35mtemp != null){
java.lang.String typeimagenURL38 = verInfoPrograma35mtemp.getImagenURL();
        String tempResultimagenURL38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL38));
        %>
        <%= tempResultimagenURL38 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(verInfoPrograma35mtemp != null){
java.lang.String typedescripcion40 = verInfoPrograma35mtemp.getDescripcion();
        String tempResultdescripcion40 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion40));
        %>
        <%= tempResultdescripcion40 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(verInfoPrograma35mtemp != null){
java.util.Calendar typefechaI42 = verInfoPrograma35mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI42 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI42 = typefechaI42.getTime();
        String tempResultfechaI42 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI42.format(datefechaI42));
        %>
        <%= tempResultfechaI42 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(verInfoPrograma35mtemp != null){
java.util.Calendar typefechaF44 = verInfoPrograma35mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF44 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF44 = typefechaF44.getTime();
        String tempResultfechaF44 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF44.format(datefechaF44));
        %>
        <%= tempResultfechaF44 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaA:</TD>
<TD>
<%
if(verInfoPrograma35mtemp != null){
java.util.Calendar typefechaA46 = verInfoPrograma35mtemp.getFechaA();
        java.text.DateFormat dateFormatfechaA46 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaA46 = typefechaA46.getTime();
        String tempResultfechaA46 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaA46.format(datefechaA46));
        %>
        <%= tempResultfechaA46 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoPrograma35mtemp != null){
java.lang.String typenombre48 = verInfoPrograma35mtemp.getNombre();
        String tempResultnombre48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre48));
        %>
        <%= tempResultnombre48 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 52:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg055");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        java.lang.String[] listarCursosInst52mtemp = sampleControladorCursoPublishProxyid.listarCursosInst(arg0_3idTemp);
if(listarCursosInst52mtemp == null){
%>
<%=listarCursosInst52mtemp %>
<%
}else{
        String tempreturnp53 = null;
        if(listarCursosInst52mtemp != null){
        java.util.List listreturnp53= java.util.Arrays.asList(listarCursosInst52mtemp);
        tempreturnp53 = listreturnp53.toString();
        }
        %>
        <%=tempreturnp53%>
        <%
}
break;
case 57:
        gotMethod = true;
        java.lang.String[] listarInstitutos57mtemp = sampleControladorCursoPublishProxyid.listarInstitutos();
if(listarInstitutos57mtemp == null){
%>
<%=listarInstitutos57mtemp %>
<%
}else{
        String tempreturnp58 = null;
        if(listarInstitutos57mtemp != null){
        java.util.List listreturnp58= java.util.Arrays.asList(listarInstitutos57mtemp);
        tempreturnp58 = listreturnp58.toString();
        }
        %>
        <%=tempreturnp58%>
        <%
}
break;
case 60:
        gotMethod = true;
        java.lang.String[] listarCursos60mtemp = sampleControladorCursoPublishProxyid.listarCursos();
if(listarCursos60mtemp == null){
%>
<%=listarCursos60mtemp %>
<%
}else{
        String tempreturnp61 = null;
        if(listarCursos60mtemp != null){
        java.util.List listreturnp61= java.util.Arrays.asList(listarCursos60mtemp);
        tempreturnp61 = listreturnp61.toString();
        }
        %>
        <%=tempreturnp61%>
        <%
}
break;
case 63:
        gotMethod = true;
        java.lang.String[] listarCategorias63mtemp = sampleControladorCursoPublishProxyid.listarCategorias();
if(listarCategorias63mtemp == null){
%>
<%=listarCategorias63mtemp %>
<%
}else{
        String tempreturnp64 = null;
        if(listarCategorias63mtemp != null){
        java.util.List listreturnp64= java.util.Arrays.asList(listarCategorias63mtemp);
        tempreturnp64 = listreturnp64.toString();
        }
        %>
        <%=tempreturnp64%>
        <%
}
break;
case 66:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg069");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        java.lang.String[] listarCursosAux66mtemp = sampleControladorCursoPublishProxyid.listarCursosAux(arg0_4idTemp);
if(listarCursosAux66mtemp == null){
%>
<%=listarCursosAux66mtemp %>
<%
}else{
        String tempreturnp67 = null;
        if(listarCursosAux66mtemp != null){
        java.util.List listreturnp67= java.util.Arrays.asList(listarCursosAux66mtemp);
        tempreturnp67 = listreturnp67.toString();
        }
        %>
        <%=tempreturnp67%>
        <%
}
break;
case 71:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg092");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        publicadores.DtCurso verInfo71mtemp = sampleControladorCursoPublishProxyid.verInfo(arg0_5idTemp);
if(verInfo71mtemp == null){
%>
<%=verInfo71mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(verInfo71mtemp != null){
java.lang.String typeurl74 = verInfo71mtemp.getUrl();
        String tempResulturl74 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl74));
        %>
        <%= tempResulturl74 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagenURL:</TD>
<TD>
<%
if(verInfo71mtemp != null){
java.lang.String typeimagenURL76 = verInfo71mtemp.getImagenURL();
        String tempResultimagenURL76 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL76));
        %>
        <%= tempResultimagenURL76 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(verInfo71mtemp != null){
java.lang.String typedescripcion78 = verInfo71mtemp.getDescripcion();
        String tempResultdescripcion78 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion78));
        %>
        <%= tempResultdescripcion78 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">creditos:</TD>
<TD>
<%
if(verInfo71mtemp != null){
%>
<%=verInfo71mtemp.getCreditos()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantHoras:</TD>
<TD>
<%
if(verInfo71mtemp != null){
%>
<%=verInfo71mtemp.getCantHoras()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">instituto:</TD>
<TD>
<%
if(verInfo71mtemp != null){
java.lang.String typeinstituto84 = verInfo71mtemp.getInstituto();
        String tempResultinstituto84 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeinstituto84));
        %>
        <%= tempResultinstituto84 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(verInfo71mtemp != null){
java.lang.String typeduracion86 = verInfo71mtemp.getDuracion();
        String tempResultduracion86 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeduracion86));
        %>
        <%= tempResultduracion86 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfo71mtemp != null){
java.lang.String typenombre88 = verInfo71mtemp.getNombre();
        String tempResultnombre88 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre88));
        %>
        <%= tempResultnombre88 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaR:</TD>
<TD>
<%
if(verInfo71mtemp != null){
java.util.Calendar typefechaR90 = verInfo71mtemp.getFechaR();
        java.text.DateFormat dateFormatfechaR90 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaR90 = typefechaR90.getTime();
        String tempResultfechaR90 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaR90.format(datefechaR90));
        %>
        <%= tempResultfechaR90 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 94:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg097");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        java.lang.String[] listarDocentesAux94mtemp = sampleControladorCursoPublishProxyid.listarDocentesAux(arg0_6idTemp);
if(listarDocentesAux94mtemp == null){
%>
<%=listarDocentesAux94mtemp %>
<%
}else{
        String tempreturnp95 = null;
        if(listarDocentesAux94mtemp != null){
        java.util.List listreturnp95= java.util.Arrays.asList(listarDocentesAux94mtemp);
        tempreturnp95 = listreturnp95.toString();
        }
        %>
        <%=tempreturnp95%>
        <%
}
break;
case 99:
        gotMethod = true;
        java.lang.String[] listarEstudiantes99mtemp = sampleControladorCursoPublishProxyid.listarEstudiantes();
if(listarEstudiantes99mtemp == null){
%>
<%=listarEstudiantes99mtemp %>
<%
}else{
        String tempreturnp100 = null;
        if(listarEstudiantes99mtemp != null){
        java.util.List listreturnp100= java.util.Arrays.asList(listarEstudiantes99mtemp);
        tempreturnp100 = listreturnp100.toString();
        }
        %>
        <%=tempreturnp100%>
        <%
}
break;
case 102:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg0105");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        java.lang.String[] listarDocentesInstituto102mtemp = sampleControladorCursoPublishProxyid.listarDocentesInstituto(arg0_7idTemp);
if(listarDocentesInstituto102mtemp == null){
%>
<%=listarDocentesInstituto102mtemp %>
<%
}else{
        String tempreturnp103 = null;
        if(listarDocentesInstituto102mtemp != null){
        java.util.List listreturnp103= java.util.Arrays.asList(listarDocentesInstituto102mtemp);
        tempreturnp103 = listreturnp103.toString();
        }
        %>
        <%=tempreturnp103%>
        <%
}
break;
case 107:
        gotMethod = true;
        String arg0_8id=  request.getParameter("arg0124");
            java.lang.String arg0_8idTemp = null;
        if(!arg0_8id.equals("")){
         arg0_8idTemp  = arg0_8id;
        }
        publicadores.DtEdicionCurso mostrarEdicionVigente107mtemp = sampleControladorCursoPublishProxyid.mostrarEdicionVigente(arg0_8idTemp);
if(mostrarEdicionVigente107mtemp == null){
%>
<%=mostrarEdicionVigente107mtemp %>
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
if(mostrarEdicionVigente107mtemp != null){
java.lang.String typeimagenURL110 = mostrarEdicionVigente107mtemp.getImagenURL();
        String tempResultimagenURL110 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL110));
        %>
        <%= tempResultimagenURL110 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(mostrarEdicionVigente107mtemp != null){
java.util.Calendar typefechaI112 = mostrarEdicionVigente107mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI112 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI112 = typefechaI112.getTime();
        String tempResultfechaI112 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI112.format(datefechaI112));
        %>
        <%= tempResultfechaI112 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(mostrarEdicionVigente107mtemp != null){
java.util.Calendar typefechaF114 = mostrarEdicionVigente107mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF114 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF114 = typefechaF114.getTime();
        String tempResultfechaF114 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF114.format(datefechaF114));
        %>
        <%= tempResultfechaF114 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cupo:</TD>
<TD>
<%
if(mostrarEdicionVigente107mtemp != null){
%>
<%=mostrarEdicionVigente107mtemp.getCupo()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">curso:</TD>
<TD>
<%
if(mostrarEdicionVigente107mtemp != null){
java.lang.String typecurso118 = mostrarEdicionVigente107mtemp.getCurso();
        String tempResultcurso118 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecurso118));
        %>
        <%= tempResultcurso118 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaPub:</TD>
<TD>
<%
if(mostrarEdicionVigente107mtemp != null){
java.util.Calendar typefechaPub120 = mostrarEdicionVigente107mtemp.getFechaPub();
        java.text.DateFormat dateFormatfechaPub120 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaPub120 = typefechaPub120.getTime();
        String tempResultfechaPub120 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaPub120.format(datefechaPub120));
        %>
        <%= tempResultfechaPub120 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(mostrarEdicionVigente107mtemp != null){
java.lang.String typenombre122 = mostrarEdicionVigente107mtemp.getNombre();
        String tempResultnombre122 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre122));
        %>
        <%= tempResultnombre122 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 126:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg0129");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        String arg1_10id=  request.getParameter("arg1131");
            java.lang.String arg1_10idTemp = null;
        if(!arg1_10id.equals("")){
         arg1_10idTemp  = arg1_10id;
        }
        String arg2_11id=  request.getParameter("arg2133");
            java.util.Calendar arg2_11idTemp = null;
        if(!arg2_11id.equals("")){
        java.text.DateFormat dateFormatarg2133 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2133  = dateFormatarg2133.parse(arg2_11id);
         arg2_11idTemp = new java.util.GregorianCalendar();
        arg2_11idTemp.setTime(dateTemparg2133);
        }
        sampleControladorCursoPublishProxyid.inscribirEstudianteEdicion(arg0_9idTemp,arg1_10idTemp,arg2_11idTemp);
break;
case 135:
        gotMethod = true;
        String arg0_12id=  request.getParameter("arg0138");
            java.lang.String arg0_12idTemp = null;
        if(!arg0_12id.equals("")){
         arg0_12idTemp  = arg0_12id;
        }
        String arg1_13id=  request.getParameter("arg1140");
            java.lang.String arg1_13idTemp = null;
        if(!arg1_13id.equals("")){
         arg1_13idTemp  = arg1_13id;
        }
        sampleControladorCursoPublishProxyid.agregarCursoPrograma(arg0_12idTemp,arg1_13idTemp);
break;
case 142:
        gotMethod = true;
        String arg0_14id=  request.getParameter("arg0145");
            java.lang.String arg0_14idTemp = null;
        if(!arg0_14id.equals("")){
         arg0_14idTemp  = arg0_14id;
        }
        String arg1_15id=  request.getParameter("arg1147");
            java.lang.String arg1_15idTemp = null;
        if(!arg1_15id.equals("")){
         arg1_15idTemp  = arg1_15id;
        }
        String arg2_16id=  request.getParameter("arg2149");
            java.util.Calendar arg2_16idTemp = null;
        if(!arg2_16id.equals("")){
        java.text.DateFormat dateFormatarg2149 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2149  = dateFormatarg2149.parse(arg2_16id);
         arg2_16idTemp = new java.util.GregorianCalendar();
        arg2_16idTemp.setTime(dateTemparg2149);
        }
        String arg3_17id=  request.getParameter("arg3151");
            java.util.Calendar arg3_17idTemp = null;
        if(!arg3_17id.equals("")){
        java.text.DateFormat dateFormatarg3151 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3151  = dateFormatarg3151.parse(arg3_17id);
         arg3_17idTemp = new java.util.GregorianCalendar();
        arg3_17idTemp.setTime(dateTemparg3151);
        }
        String arg4_18id=  request.getParameter("arg4153");
            java.util.Calendar arg4_18idTemp = null;
        if(!arg4_18id.equals("")){
        java.text.DateFormat dateFormatarg4153 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4153  = dateFormatarg4153.parse(arg4_18id);
         arg4_18idTemp = new java.util.GregorianCalendar();
        arg4_18idTemp.setTime(dateTemparg4153);
        }
        String arg5_19id=  request.getParameter("arg5155");
            java.lang.String arg5_19idTemp = null;
        if(!arg5_19id.equals("")){
         arg5_19idTemp  = arg5_19id;
        }
        sampleControladorCursoPublishProxyid.crearProgramaFormacion(arg0_14idTemp,arg1_15idTemp,arg2_16idTemp,arg3_17idTemp,arg4_18idTemp,arg5_19idTemp);
break;
case 157:
        gotMethod = true;
        String arg0_20id=  request.getParameter("arg0160");
            java.lang.String arg0_20idTemp = null;
        if(!arg0_20id.equals("")){
         arg0_20idTemp  = arg0_20id;
        }
        java.lang.String[] getCategoriasPrograma157mtemp = sampleControladorCursoPublishProxyid.getCategoriasPrograma(arg0_20idTemp);
if(getCategoriasPrograma157mtemp == null){
%>
<%=getCategoriasPrograma157mtemp %>
<%
}else{
        String tempreturnp158 = null;
        if(getCategoriasPrograma157mtemp != null){
        java.util.List listreturnp158= java.util.Arrays.asList(getCategoriasPrograma157mtemp);
        tempreturnp158 = listreturnp158.toString();
        }
        %>
        <%=tempreturnp158%>
        <%
}
break;
case 162:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0165");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        String arg1_22id=  request.getParameter("arg1167");
            java.lang.String arg1_22idTemp = null;
        if(!arg1_22id.equals("")){
         arg1_22idTemp  = arg1_22id;
        }
        String arg2_23id=  request.getParameter("arg2169");
            java.util.Calendar arg2_23idTemp = null;
        if(!arg2_23id.equals("")){
        java.text.DateFormat dateFormatarg2169 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2169  = dateFormatarg2169.parse(arg2_23id);
         arg2_23idTemp = new java.util.GregorianCalendar();
        arg2_23idTemp.setTime(dateTemparg2169);
        }
        sampleControladorCursoPublishProxyid.inscribirEstudiantePrograma(arg0_21idTemp,arg1_22idTemp,arg2_23idTemp);
break;
case 171:
        gotMethod = true;
        publicadores.DtCurso[] listaDTCurso171mtemp = sampleControladorCursoPublishProxyid.listaDTCurso();
if(listaDTCurso171mtemp == null){
%>
<%=listaDTCurso171mtemp %>
<%
}else{
        String tempreturnp172 = null;
        if(listaDTCurso171mtemp != null){
        java.util.List listreturnp172= java.util.Arrays.asList(listaDTCurso171mtemp);
        tempreturnp172 = listreturnp172.toString();
        }
        %>
        <%=tempreturnp172%>
        <%
}
break;
case 174:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0177");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        java.lang.String[] listarCursosCat174mtemp = sampleControladorCursoPublishProxyid.listarCursosCat(arg0_24idTemp);
if(listarCursosCat174mtemp == null){
%>
<%=listarCursosCat174mtemp %>
<%
}else{
        String tempreturnp175 = null;
        if(listarCursosCat174mtemp != null){
        java.util.List listreturnp175= java.util.Arrays.asList(listarCursosCat174mtemp);
        tempreturnp175 = listreturnp175.toString();
        }
        %>
        <%=tempreturnp175%>
        <%
}
break;
case 179:
        gotMethod = true;
        String arg0_25id=  request.getParameter("arg0182");
            java.lang.String arg0_25idTemp = null;
        if(!arg0_25id.equals("")){
         arg0_25idTemp  = arg0_25id;
        }
        java.lang.String[] listarEdiciones179mtemp = sampleControladorCursoPublishProxyid.listarEdiciones(arg0_25idTemp);
if(listarEdiciones179mtemp == null){
%>
<%=listarEdiciones179mtemp %>
<%
}else{
        String tempreturnp180 = null;
        if(listarEdiciones179mtemp != null){
        java.util.List listreturnp180= java.util.Arrays.asList(listarEdiciones179mtemp);
        tempreturnp180 = listreturnp180.toString();
        }
        %>
        <%=tempreturnp180%>
        <%
}
break;
case 184:
        gotMethod = true;
        publicadores.DtProgramaFormacion[] listaDTPrograma184mtemp = sampleControladorCursoPublishProxyid.listaDTPrograma();
if(listaDTPrograma184mtemp == null){
%>
<%=listaDTPrograma184mtemp %>
<%
}else{
        String tempreturnp185 = null;
        if(listaDTPrograma184mtemp != null){
        java.util.List listreturnp185= java.util.Arrays.asList(listaDTPrograma184mtemp);
        tempreturnp185 = listreturnp185.toString();
        }
        %>
        <%=tempreturnp185%>
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