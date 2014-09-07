<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script src="${contextPath}/js/heanoria/controller/ArtistesController.js"></script>
	<title>Helichrysum</title>
</head>
<body>
	<section data-ng-controller="ArtistesController">
		<script type="text/ng-template" id="addArtistesPopup">
			<div class="modal-header">
           		<h3 class="modal-title">Ajouter un Artiste</h3>
        	</div>
        	<div class="modal-body">
				
        	</div>
        	<div class="modal-footer">
            	<button class="btn btn-primary" ng-click="ok()">OK</button>
            	<button class="btn btn-warning" ng-click="cancel()">Cancel</button>
        	</div>
		</script>
		<h3 class="page-header s-t">Les Artistes <a href="#" class="btn btn-info pull-right" ng-click="openPopup()">Ajouter</a></h3>
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
