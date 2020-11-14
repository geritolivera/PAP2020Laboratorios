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
        java.lang.String[] listarCursos13mtemp = sampleControladorCursoPublishProxyid.listarCursos();
if(listarCursos13mtemp == null){
%>
<%=listarCursos13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(listarCursos13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(listarCursos13mtemp);
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
        java.lang.String[] listarCursosAux16mtemp = sampleControladorCursoPublishProxyid.listarCursosAux(arg0_1idTemp);
if(listarCursosAux16mtemp == null){
%>
<%=listarCursosAux16mtemp %>
<%
}else{
        String tempreturnp17 = null;
        if(listarCursosAux16mtemp != null){
        java.util.List listreturnp17= java.util.Arrays.asList(listarCursosAux16mtemp);
        tempreturnp17 = listreturnp17.toString();
        }
        %>
        <%=tempreturnp17%>
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
        java.lang.String[] listarInstitutos24mtemp = sampleControladorCursoPublishProxyid.listarInstitutos();
if(listarInstitutos24mtemp == null){
%>
<%=listarInstitutos24mtemp %>
<%
}else{
        String tempreturnp25 = null;
        if(listarInstitutos24mtemp != null){
        java.util.List listreturnp25= java.util.Arrays.asList(listarInstitutos24mtemp);
        tempreturnp25 = listreturnp25.toString();
        }
        %>
        <%=tempreturnp25%>
        <%
}
break;
case 27:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg030");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        java.lang.String[] listarCursosInst27mtemp = sampleControladorCursoPublishProxyid.listarCursosInst(arg0_2idTemp);
if(listarCursosInst27mtemp == null){
%>
<%=listarCursosInst27mtemp %>
<%
}else{
        String tempreturnp28 = null;
        if(listarCursosInst27mtemp != null){
        java.util.List listreturnp28= java.util.Arrays.asList(listarCursosInst27mtemp);
        tempreturnp28 = listreturnp28.toString();
        }
        %>
        <%=tempreturnp28%>
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
        String arg0_5id=  request.getParameter("arg060");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        publicadores.DtEdicionCurso verInfoEdicion45mtemp = sampleControladorCursoPublishProxyid.verInfoEdicion(arg0_5idTemp);
if(verInfoEdicion45mtemp == null){
%>
<%=verInfoEdicion45mtemp %>
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
if(verInfoEdicion45mtemp != null){
java.util.Calendar typefechaPub48 = verInfoEdicion45mtemp.getFechaPub();
        java.text.DateFormat dateFormatfechaPub48 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaPub48 = typefechaPub48.getTime();
        String tempResultfechaPub48 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaPub48.format(datefechaPub48));
        %>
        <%= tempResultfechaPub48 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(verInfoEdicion45mtemp != null){
java.util.Calendar typefechaI50 = verInfoEdicion45mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI50 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI50 = typefechaI50.getTime();
        String tempResultfechaI50 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI50.format(datefechaI50));
        %>
        <%= tempResultfechaI50 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(verInfoEdicion45mtemp != null){
java.util.Calendar typefechaF52 = verInfoEdicion45mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF52 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF52 = typefechaF52.getTime();
        String tempResultfechaF52 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF52.format(datefechaF52));
        %>
        <%= tempResultfechaF52 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagenURL:</TD>
<TD>
<%
if(verInfoEdicion45mtemp != null){
java.lang.String typeimagenURL54 = verInfoEdicion45mtemp.getImagenURL();
        String tempResultimagenURL54 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL54));
        %>
        <%= tempResultimagenURL54 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cupo:</TD>
<TD>
<%
if(verInfoEdicion45mtemp != null){
%>
<%=verInfoEdicion45mtemp.getCupo()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoEdicion45mtemp != null){
java.lang.String typenombre58 = verInfoEdicion45mtemp.getNombre();
        String tempResultnombre58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre58));
        %>
        <%= tempResultnombre58 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 62:
        gotMethod = true;
        java.lang.String[] listarProgramas62mtemp = sampleControladorCursoPublishProxyid.listarProgramas();
if(listarProgramas62mtemp == null){
%>
<%=listarProgramas62mtemp %>
<%
}else{
        String tempreturnp63 = null;
        if(listarProgramas62mtemp != null){
        java.util.List listreturnp63= java.util.Arrays.asList(listarProgramas62mtemp);
        tempreturnp63 = listreturnp63.toString();
        }
        %>
        <%=tempreturnp63%>
        <%
}
break;
case 65:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg080");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        publicadores.DtProgramaFormacion verInfoPrograma65mtemp = sampleControladorCursoPublishProxyid.verInfoPrograma(arg0_6idTemp);
if(verInfoPrograma65mtemp == null){
%>
<%=verInfoPrograma65mtemp %>
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
if(verInfoPrograma65mtemp != null){
java.util.Calendar typefechaI68 = verInfoPrograma65mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI68 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI68 = typefechaI68.getTime();
        String tempResultfechaI68 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI68.format(datefechaI68));
        %>
        <%= tempResultfechaI68 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(verInfoPrograma65mtemp != null){
java.lang.String typedescripcion70 = verInfoPrograma65mtemp.getDescripcion();
        String tempResultdescripcion70 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion70));
        %>
        <%= tempResultdescripcion70 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(verInfoPrograma65mtemp != null){
java.util.Calendar typefechaF72 = verInfoPrograma65mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF72 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF72 = typefechaF72.getTime();
        String tempResultfechaF72 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF72.format(datefechaF72));
        %>
        <%= tempResultfechaF72 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagenURL:</TD>
<TD>
<%
if(verInfoPrograma65mtemp != null){
java.lang.String typeimagenURL74 = verInfoPrograma65mtemp.getImagenURL();
        String tempResultimagenURL74 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL74));
        %>
        <%= tempResultimagenURL74 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(verInfoPrograma65mtemp != null){
java.lang.String typenombre76 = verInfoPrograma65mtemp.getNombre();
        String tempResultnombre76 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre76));
        %>
        <%= tempResultnombre76 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaA:</TD>
<TD>
<%
if(verInfoPrograma65mtemp != null){
java.util.Calendar typefechaA78 = verInfoPrograma65mtemp.getFechaA();
        java.text.DateFormat dateFormatfechaA78 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaA78 = typefechaA78.getTime();
        String tempResultfechaA78 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaA78.format(datefechaA78));
        %>
        <%= tempResultfechaA78 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 82:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg085");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        String arg1_8id=  request.getParameter("arg187");
            java.lang.String arg1_8idTemp = null;
        if(!arg1_8id.equals("")){
         arg1_8idTemp  = arg1_8id;
        }
        sampleControladorCursoPublishProxyid.agregarCursoPrograma(arg0_7idTemp,arg1_8idTemp);
break;
case 89:
        gotMethod = true;
        String arg0_9id=  request.getParameter("arg092");
            java.lang.String arg0_9idTemp = null;
        if(!arg0_9id.equals("")){
         arg0_9idTemp  = arg0_9id;
        }
        java.lang.String[] getCategoriasPrograma89mtemp = sampleControladorCursoPublishProxyid.getCategoriasPrograma(arg0_9idTemp);
if(getCategoriasPrograma89mtemp == null){
%>
<%=getCategoriasPrograma89mtemp %>
<%
}else{
        String tempreturnp90 = null;
        if(getCategoriasPrograma89mtemp != null){
        java.util.List listreturnp90= java.util.Arrays.asList(getCategoriasPrograma89mtemp);
        tempreturnp90 = listreturnp90.toString();
        }
        %>
        <%=tempreturnp90%>
        <%
}
break;
case 94:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg097");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        java.lang.String[] listarDocentesInstituto94mtemp = sampleControladorCursoPublishProxyid.listarDocentesInstituto(arg0_10idTemp);
if(listarDocentesInstituto94mtemp == null){
%>
<%=listarDocentesInstituto94mtemp %>
<%
}else{
        String tempreturnp95 = null;
        if(listarDocentesInstituto94mtemp != null){
        java.util.List listreturnp95= java.util.Arrays.asList(listarDocentesInstituto94mtemp);
        tempreturnp95 = listreturnp95.toString();
        }
        %>
        <%=tempreturnp95%>
        <%
}
break;
case 99:
        gotMethod = true;
        String arg0_11id=  request.getParameter("arg0114");
            java.lang.String arg0_11idTemp = null;
        if(!arg0_11id.equals("")){
         arg0_11idTemp  = arg0_11id;
        }
        publicadores.DtEdicionCurso mostrarEdicionVigente99mtemp = sampleControladorCursoPublishProxyid.mostrarEdicionVigente(arg0_11idTemp);
if(mostrarEdicionVigente99mtemp == null){
%>
<%=mostrarEdicionVigente99mtemp %>
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
if(mostrarEdicionVigente99mtemp != null){
java.util.Calendar typefechaPub102 = mostrarEdicionVigente99mtemp.getFechaPub();
        java.text.DateFormat dateFormatfechaPub102 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaPub102 = typefechaPub102.getTime();
        String tempResultfechaPub102 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaPub102.format(datefechaPub102));
        %>
        <%= tempResultfechaPub102 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaI:</TD>
<TD>
<%
if(mostrarEdicionVigente99mtemp != null){
java.util.Calendar typefechaI104 = mostrarEdicionVigente99mtemp.getFechaI();
        java.text.DateFormat dateFormatfechaI104 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaI104 = typefechaI104.getTime();
        String tempResultfechaI104 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaI104.format(datefechaI104));
        %>
        <%= tempResultfechaI104 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaF:</TD>
<TD>
<%
if(mostrarEdicionVigente99mtemp != null){
java.util.Calendar typefechaF106 = mostrarEdicionVigente99mtemp.getFechaF();
        java.text.DateFormat dateFormatfechaF106 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaF106 = typefechaF106.getTime();
        String tempResultfechaF106 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaF106.format(datefechaF106));
        %>
        <%= tempResultfechaF106 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">imagenURL:</TD>
<TD>
<%
if(mostrarEdicionVigente99mtemp != null){
java.lang.String typeimagenURL108 = mostrarEdicionVigente99mtemp.getImagenURL();
        String tempResultimagenURL108 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeimagenURL108));
        %>
        <%= tempResultimagenURL108 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cupo:</TD>
<TD>
<%
if(mostrarEdicionVigente99mtemp != null){
%>
<%=mostrarEdicionVigente99mtemp.getCupo()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(mostrarEdicionVigente99mtemp != null){
java.lang.String typenombre112 = mostrarEdicionVigente99mtemp.getNombre();
        String tempResultnombre112 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre112));
        %>
        <%= tempResultnombre112 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 116:
        gotMethod = true;
        String arg0_12id=  request.getParameter("arg0119");
            java.lang.String arg0_12idTemp = null;
        if(!arg0_12id.equals("")){
         arg0_12idTemp  = arg0_12id;
        }
        String arg1_13id=  request.getParameter("arg1121");
            java.lang.String arg1_13idTemp = null;
        if(!arg1_13id.equals("")){
         arg1_13idTemp  = arg1_13id;
        }
        String arg2_14id=  request.getParameter("arg2123");
            java.util.Calendar arg2_14idTemp = null;
        if(!arg2_14id.equals("")){
        java.text.DateFormat dateFormatarg2123 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2123  = dateFormatarg2123.parse(arg2_14id);
         arg2_14idTemp = new java.util.GregorianCalendar();
        arg2_14idTemp.setTime(dateTemparg2123);
        }
        sampleControladorCursoPublishProxyid.inscribirEstudianteEdicion(arg0_12idTemp,arg1_13idTemp,arg2_14idTemp);
break;
case 125:
        gotMethod = true;
        String arg0_15id=  request.getParameter("arg0128");
            java.lang.String arg0_15idTemp = null;
        if(!arg0_15id.equals("")){
         arg0_15idTemp  = arg0_15id;
        }
        String arg1_16id=  request.getParameter("arg1130");
            java.lang.String arg1_16idTemp = null;
        if(!arg1_16id.equals("")){
         arg1_16idTemp  = arg1_16id;
        }
        String arg2_17id=  request.getParameter("arg2132");
            java.util.Calendar arg2_17idTemp = null;
        if(!arg2_17id.equals("")){
        java.text.DateFormat dateFormatarg2132 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2132  = dateFormatarg2132.parse(arg2_17id);
         arg2_17idTemp = new java.util.GregorianCalendar();
        arg2_17idTemp.setTime(dateTemparg2132);
        }
        String arg3_18id=  request.getParameter("arg3134");
            java.util.Calendar arg3_18idTemp = null;
        if(!arg3_18id.equals("")){
        java.text.DateFormat dateFormatarg3134 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg3134  = dateFormatarg3134.parse(arg3_18id);
         arg3_18idTemp = new java.util.GregorianCalendar();
        arg3_18idTemp.setTime(dateTemparg3134);
        }
        String arg4_19id=  request.getParameter("arg4136");
            java.util.Calendar arg4_19idTemp = null;
        if(!arg4_19id.equals("")){
        java.text.DateFormat dateFormatarg4136 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg4136  = dateFormatarg4136.parse(arg4_19id);
         arg4_19idTemp = new java.util.GregorianCalendar();
        arg4_19idTemp.setTime(dateTemparg4136);
        }
        String arg5_20id=  request.getParameter("arg5138");
            java.lang.String arg5_20idTemp = null;
        if(!arg5_20id.equals("")){
         arg5_20idTemp  = arg5_20id;
        }
        sampleControladorCursoPublishProxyid.crearProgramaFormacion(arg0_15idTemp,arg1_16idTemp,arg2_17idTemp,arg3_18idTemp,arg4_19idTemp,arg5_20idTemp);
break;
case 140:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0143");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        java.lang.String[] listarEdiciones140mtemp = sampleControladorCursoPublishProxyid.listarEdiciones(arg0_21idTemp);
if(listarEdiciones140mtemp == null){
%>
<%=listarEdiciones140mtemp %>
<%
}else{
        String tempreturnp141 = null;
        if(listarEdiciones140mtemp != null){
        java.util.List listreturnp141= java.util.Arrays.asList(listarEdiciones140mtemp);
        tempreturnp141 = listreturnp141.toString();
        }
        %>
        <%=tempreturnp141%>
        <%
}
break;
case 145:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0148");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        java.lang.String[] listarCursosCat145mtemp = sampleControladorCursoPublishProxyid.listarCursosCat(arg0_22idTemp);
if(listarCursosCat145mtemp == null){
%>
<%=listarCursosCat145mtemp %>
<%
}else{
        String tempreturnp146 = null;
        if(listarCursosCat145mtemp != null){
        java.util.List listreturnp146= java.util.Arrays.asList(listarCursosCat145mtemp);
        tempreturnp146 = listreturnp146.toString();
        }
        %>
        <%=tempreturnp146%>
        <%
}
break;
case 150:
        gotMethod = true;
        publicadores.DtCurso[] listaDTCurso150mtemp = sampleControladorCursoPublishProxyid.listaDTCurso();
if(listaDTCurso150mtemp == null){
%>
<%=listaDTCurso150mtemp %>
<%
}else{
        String tempreturnp151 = null;
        if(listaDTCurso150mtemp != null){
        java.util.List listreturnp151= java.util.Arrays.asList(listaDTCurso150mtemp);
        tempreturnp151 = listreturnp151.toString();
        }
        %>
        <%=tempreturnp151%>
        <%
}
break;
case 153:
        gotMethod = true;
        publicadores.DtProgramaFormacion[] listaDTPrograma153mtemp = sampleControladorCursoPublishProxyid.listaDTPrograma();
if(listaDTPrograma153mtemp == null){
%>
<%=listaDTPrograma153mtemp %>
<%
}else{
        String tempreturnp154 = null;
        if(listaDTPrograma153mtemp != null){
        java.util.List listreturnp154= java.util.Arrays.asList(listaDTPrograma153mtemp);
        tempreturnp154 = listreturnp154.toString();
        }
        %>
        <%=tempreturnp154%>
        <%
}
break;
case 156:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0159");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        String arg1_24id=  request.getParameter("arg1161");
            java.lang.String arg1_24idTemp = null;
        if(!arg1_24id.equals("")){
         arg1_24idTemp  = arg1_24id;
        }
        String arg2_25id=  request.getParameter("arg2163");
            java.util.Calendar arg2_25idTemp = null;
        if(!arg2_25id.equals("")){
        java.text.DateFormat dateFormatarg2163 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg2163  = dateFormatarg2163.parse(arg2_25id);
         arg2_25idTemp = new java.util.GregorianCalendar();
        arg2_25idTemp.setTime(dateTemparg2163);
        }
        sampleControladorCursoPublishProxyid.inscribirEstudiantePrograma(arg0_23idTemp,arg1_24idTemp,arg2_25idTemp);
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