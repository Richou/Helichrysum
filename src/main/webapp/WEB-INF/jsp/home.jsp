<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script src="${contextPath}/js/heanoria/controller/ArtistesController.js"></script>
	<title>Helichrysum</title>
</head>
<body>
	<section data-ng-controller="ArtistesController">
		<h3 class="page-header s-t">Les Artistes</h3>
		<p>Un tableau représentant une liste des Artistes enregistrés.</p>
		<table class="table">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Genre</th>
					<th>Albums</th>
				</tr>
			</thead>
			<tbody>
				<tr data-ng-repeat="artiste in artistes">
					<td>{{artiste.nom}}</td>
					<td>{{artiste.genre}}</td>
					<td>
						<ul>
							<li data-ng-repeat="album in artiste.albums">{{album.nom}} [{{album.songs.length}} tracks]</li>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
	</section>
</body>
</html>
