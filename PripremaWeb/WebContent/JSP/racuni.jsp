<%@page import="beans.Racun"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<jsp:useBean id="racuni" class="beans.Racuni" scope="session"></jsp:useBean>
<jsp:useBean id="error" class="java.lang.String" scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function validacija(forma){
		
		/*
		preko ovoga gledam da li su polja prazna
		*/
		var brojRacuna= document.getElementById("brojRacuna").value;
		var raspolozivoStanje = document.getElementById("raspolozivoStanje").value;
		var rezervisanoStanje = document.getElementById("rezervisanoStanje").value;
		
		var validation = true;
		
		if(brojRacuna == ""){
			alert("Broj racuna je prazno polje, popunite ga!");
			validation= false;
		}
		
		if(raspolozivoStanje == ""){
			alert("Raspolozivo stanje ne sme biti prazno covek!");
			validation= false;
		}
		
		if(rezervisanoStanje==""){
			alert("Rezervisano stanje ne sem biti prazno covek!");
			validation= false;
		}
		
		if(raspolozivoStanje < 0){
			alert("Raspolozivo stanje mora biti CELOBROJNI POZITIVNI BROJ");
			validation=false;
		}
		
		if(rezervisanoStanje <0){
			alert("Rezervisano stanje mora biti CELOBROJNI POZITIVNI BROJ");
			validation=false;
		}
		
		return validation;
		
	}
	
	
	function validacija_Uplata(form){
		var uplata = document.getElementById("uplata").value;
		
		if(uplata<0){
			alert("Uplata mora biti POZITIVAN DECIMALAN CEO BROJ");
			return false;
		}
		
		if(uplata == ""){
			alert("Moras unesti uplatu!");
			return false;
		}
		return true;
		
	}
</script>
</head>
<body>

<h2>Racuni</h2>
	<form action="NapraviRacun" method="get" onsubmit="return validacija(this)" >
		<table>
			<tr>
				<td>Broj racuna</td>
				<td><input type="text" name="txt_broj" id="brojRacuna"></td>
			</tr>
			<tr>
				<td>Tip racuna</td>
				<td>
					<select name="tip_racuna">
						<option>Dinarski</option>
						<option>Devizni</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Raspolozivo stanje</td>
				<td><input type="text" name="txt_raspolozivo" id="raspolozivoStanje"></td>
			</tr>
			<tr>
				<td>Rezervisano stanje</td>
				<td><input type="text" name="txt_rezervisano" id="rezervisanoStanje"></td>
			</tr>
			<tr>
				<td>Online</td>
				<td><input type="checkbox" name="cb_online"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="btn_napravi_racun" value="Napravi racun"></td>
			</tr>
		</table>
	</form>
	<% if(!error.equals("")) %>
		<p style="Color : red"> <%= error %> </p>
	
	<br><br>
	<table border="1">
		<thead>
			<tr><th>Broj racuna</th><th>Tip racuna</th><th>Rezervisano</th><th>Raspolozivo</th><th>Ukupno</th><th>Online</th><th>Aktivan</th></tr>
			<% for(Racun item : racuni.getRacuni()) {%>
				<tr>
					<th> <%= item.getBrojRacuna() %></th> 
					<th> <%= item.getTipRacuna() %> </th>
					<th> <%= item.getRezervisano() %> </th>
					<th> <%= item.getRaspolozivo() %> </th>
					<th> <%= item.getUkupno() %> </th>
					<th> <%= item.getOnline() %> </th>
					<th> <%= item.getAktivan() %> </th>
					<th> <a href=<%= "ObrisiServlet?id=" + item.getBrojRacuna() %> > Obrisi</a>
					<% if(item.getAktivan()=="DA") {%>
						<th> <a href= <%= "DeaktivirajServlet?id=" + item.getBrojRacuna() %> > Deaktiviraj</a>
					<% }else{ %>
						<th> <a href= <%= "AktivirajServlet?id=" + item.getBrojRacuna() %> > Aktiviraj</a>
					<% } %>	
				</tr>
			<% } %>
		</thead>
	</table>
	<h2>Uplata</h2>
	<form action="UplatiServlet" method="get" onsubmit="return validacija_Uplata(this)" >
		<table>
			<tr>
				<td>Racun</td>
				<td>
					<select name="id">
					<% for(Racun item : racuni.getRacuni()) {%>
						<% if(item.getAktivan().equals("DA")) { %>
								<option><%= item.getBrojRacuna() %> </option>
						<%} } %>
						
					</select>
				</td>
			</tr>
			<tr>
				<td>Iznos</td>
				<td><input type="text" name="txt_iznos" id="uplata"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="btn_uplati" value="Uplati"></td>
			</tr>
		</table>
	</form>
	<hr>
	<a href="LogOutServlet">Odjava</a>






</body>
</html>