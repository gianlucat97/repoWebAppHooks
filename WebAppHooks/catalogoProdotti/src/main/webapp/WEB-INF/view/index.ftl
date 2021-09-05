<!DOCTYPE html>
<html>
	<head>
		<title x-test-tpl-1>Catalogo prodotti</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" x-test-tpl-2>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	</head>
	<body>
		<h1 x-test-tpl-3>Catalogo prodotti</h1>
		
		
		<#if prodottoDaModificare??>
		<h2 x-test-tpl-4>Modifica del prodotto - ${prodottoDaModificare.nome}</h2>
			<div style="margin 20px;" x-test-tpl-5>
				<form method="POST" action="update" id="datiProdotto" x-test-hook-6>
					<input type="hidden" name="id" value="${prodottoDaModificare.id}" x-test-hook-7 />
					<div x-test-hook-8>
						<label for="nome" x-test-hook-9>Nome</label>
						<input type="text" name="nome" id="nome" value="${prodottoDaModificare.nome}" x-test-hook-10 />
					</div>
					<div x-test-hook-11>
						<label for="descrizione" x-test-hook-12>Descrizione</label>
						<input type="text" name="descrizione" id="descrizione" value="${prodottoDaModificare.descrizione}" x-test-hook-13 />
					</div>
					<div x-test-hook-14>
						<label for="prezzo" x-test-hook-15>Prezzo</label>
						<input type="number" name="prezzo" id="prezzo" value="${prodottoDaModificare.prezzo}" x-test-hook-16 />
					</div>
					<div x-test-hook-17>
						<input type="submit" name="invia" value="Salva modifiche" x-test-hook-18 />
					</div>
				
				
				</form>
			</div>
		<#else>
		<h2 x-test-tpl-19>Nuovo prodotto</h2>
			<div style="margin 20px;" x-test-tpl-20>
				<form method="POST" action="add" id="datiProdotto" x-test-hook-21>
					<div x-test-hook-22>
						<label for="nome" x-test-hook-23>Nome</label>
						<input type="text" name="nome" id="nome" value="" x-test-hook-24 />
					</div>
					<div x-test-hook-25>
						<label for="descrizione" x-test-hook-26>Descrizione</label>
						<input type="text" name="descrizione" id="descrizione" value="" x-test-hook-27 />
					</div>
					<div x-test-hook-28>
						<label for="prezzo" x-test-hook-29>Prezzo</label>
						<input type="number" name="prezzo" id="prezzo" value="" x-test-hook-30 />
					</div>
					<div x-test-hook-31>
						<input type="submit" name="invia" value="Aggiungi" x-test-hook-32 />
					</div>
				
				
				</form>
			</div>

		</#if>
		
		
		<hr x-test-tpl-33>
		
		<h2 x-test-tpl-34>Lista prodotti</h2>
		<div x-test-tpl-35>
			<table x-test-hook-36>
				<thead x-test-hook-37>
					<tr x-test-hook-38>
						<th x-test-hook-39>Nome</th>
						<th x-test-hook-40>Descrizione</th>
						<th x-test-hook-41>Prezzo</th>
						<th x-test-hook-42>Azioni</th>
					</tr>
				</thead>
				<tbody x-test-hook-43>
					<#list listaProdotti as prodotto>
					<tr x-test-hook-44>
						<td x-test-hook-45>${prodotto.nome}</td>
						<td x-test-hook-46>${prodotto.descrizione}</td>
						<td x-test-hook-47>${prodotto.prezzo}</td>
						<td x-test-hook-48>
							<a href="delete?id=${prodotto.id}" x-test-hook-49>Elimina</a>
							<a href="prodotti?id=${prodotto.id}" x-test-hook-50>Modifica</a>
						</td>
					</tr>
					</#list>
				</tbody>
			</table>
		</div>
	</body>
</html>
		
