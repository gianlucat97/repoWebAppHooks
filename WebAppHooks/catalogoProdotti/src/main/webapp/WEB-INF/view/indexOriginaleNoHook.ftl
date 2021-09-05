<!DOCTYPE html>
<html>
	<head>
		<title>Catalogo prodotti</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	</head>
	<body>
		<h1>Catalogo prodotti</h1>
		
		
		<#if prodottoDaModificare??>
		<h2>Modifica del prodotto - ${prodottoDaModificare.nome}</h2>
			<div style="margin 20px;">
				<form method="POST" action="update" id="datiProdotto">
					<input type="hidden" name="id" value="${prodottoDaModificare.id}" />
					<div>
						<label for="nome">Nome</label>
						<input type="text" name="nome" id="nome" value="${prodottoDaModificare.nome}" />
					</div>
					<div>
						<label for="descrizione">Descrizione</label>
						<input type="text" name="descrizione" id="descrizione" value="${prodottoDaModificare.descrizione}" />
					</div>
					<div>
						<label for="prezzo">Prezzo</label>
						<input type="number" name="prezzo" id="prezzo" value="${prodottoDaModificare.prezzo}" />
					</div>
					<div>
						<input type="submit" name="invia" value="Salva modifiche" />
					</div>
				
				
				</form>
			</div>
		<#else>
		<h2>Nuovo prodotto</h2>
			<div style="margin 20px;">
				<form method="POST" action="add" id="datiProdotto">
					<div>
						<label for="nome">Nome</label>
						<input type="text" name="nome" id="nome" value="" />
					</div>
					<div>
						<label for="descrizione">Descrizione</label>
						<input type="text" name="descrizione" id="descrizione" value="" />
					</div>
					<div>
						<label for="prezzo">Prezzo</label>
						<input type="number" name="prezzo" id="prezzo" value="" />
					</div>
					<div>
						<input type="submit" name="invia" value="Aggiungi" />
					</div>
				
				
				</form>
			</div>

		</#if>
		
		
		<hr>
		
		<h2>Lista prodotti</h2>
		<div>
			<table>
				<thead>
					<tr>
						<th>Nome</th>
						<th>Descrizione</th>
						<th>Prezzo</th>
						<th>Azioni</th>
					</tr>
				</thead>
				<tbody>
					<#list listaProdotti as prodotto>
					<tr>
						<td>${prodotto.nome}</td>
						<td>${prodotto.descrizione}</td>
						<td>${prodotto.prezzo}</td>
						<td>
							<a href="delete?id=${prodotto.id}">Elimina</a>
							<a href="prodotti?id=${prodotto.id}">Modifica</a>
						</td>
					</tr>
					</#list>
				</tbody>
			</table>
		</div>
	</body>
</html>
		
