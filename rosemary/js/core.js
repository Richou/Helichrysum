var API_URL = "https://heanoria.appspot.com/";

function renderArticle(dataObject){
	var article = '<article class="aa" data-id="' + dataObject.id + '">';
	article += '<header>' + dataObject.nom + '<span> -- ' + dataObject.genre + '</span><span class="right"><a class="d-a" href="delete-' + dataObject.id + '">Delete</a> | <a class="e-a" href="artistes.html?id=' + dataObject.id + '">Edit</a></span></header>';
	if(dataObject.albums != null){
		article += '<ul>';
		var albums = dataObject.albums;
		$(albums).each(function(i, album){
			if(album != null) article += '<li>' + album.nom + '</li>';
		});
		article += '</ul>';
	}else{
		article += "<label class='n-a'>pas d'album</label>";
	}
	article += '</article>';
	
	return article;
}

function renderAlbum(dataObject){
	var article = '<article class="aa" data-id="' + dataObject.id + '">';
	article += '<header>' + dataObject.nom + '<span class="right"><a class="d-am" href="delete-' + dataObject.id + '">Delete</a> | <a class="e-a" href="albums.html?id=' + dataObject.id + '">Edit</a></span></header>';
	if(dataObject.songs != null){
		article += '<ul>';
		var songs = dataObject.songs;
		$(songs).each(function(i, song){
			article += '<li>' + song + '</li>';
		});
		article += '</ul>';
	}else{
		article += "<label class='n-a'>pas de chanson</label>";
	}
	article += '</article>';
	
	return article;
}

function renderAlbumCheckBoxes(dataObject){
	var album = '<input type="checkbox" value="' + dataObject.id + '" id="label-' + dataObject.id + '" name="albumsBox"><label style="display:inline;" for="label-' + dataObject.id + '">' + dataObject.nom + '</label></input><br />';
	return album;
}

function getArtisteList(container){
	$.ajax({
		url: API_URL + "_ah/api/helichrysum/v1/artistes/list",
		type: "GET",
		contentType: "application/json, charset=utf-8",
		success: function(result){
			var artistes = result.items;
			container.empty();
			$(artistes).each(function(i, artiste){
				container.append(renderArticle(artiste));
			});
			attachDeleteHandler('.d-a', 'artistes');
		},
		error:function(jqXHR, textStatus, errorThrown){
			console.log(errorThrown);
		}
	});
}

function getAlbumsList(container){
	$.ajax({
		url: API_URL + "_ah/api/helichrysum/v1/albums/list",
		type: "GET",
		contentType: "application/json, charset=utf-8",
		success: function(result){
			var artistes = result.items;
			container.empty();
			$(artistes).each(function(i, artiste){
				container.append(renderAlbum(artiste));
			});
			attachDeleteHandler('.d-am', 'albums');
		},
		error:function(jqXHR, textStatus, errorThrown){
			console.log(errorThrown);
		}
	});
}

function getAlbumList(container){
	$.ajax({
		url: API_URL + "_ah/api/helichrysum/v1/albums/list",
		type: "GET",
		contentType: "application/json, charset=utf-8",
		success: function(result){
			var albums = result.items;
			$(albums).each(function(i, album){
				container.append(renderAlbumCheckBoxes(album));
			});
		},
		error:function(jqXHR, textStatus, errorThrown){
			console.log(errorThrown);
		}
	});
}

function getParam(name){
    var results = new RegExp('[\\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
       return null;
    }
    else{
       return results[1] || 0;
    }	
}

function attachDeleteHandler(classToWatch, what){
	$(classToWatch).each(function(i, delLink){
		$(delLink).on('click',function(e){
			var idToDel = $(this).attr('href').split('-')[1];
			$.ajax({
				url: API_URL + "_ah/api/helichrysum/v1/" + what + "/delete/" + idToDel,
				type: "GET",
				contentType: "application/json, charset=utf-8",
				success: function(result){
					if(what == 'artistes'){
						getArtisteList($('#list'));
					} else {
						getAlbumsList($('#list2'));
					}
				},
				error:function(jqXHR, textStatus, errorThrown){
					console.log(errorThrown);
				}
			});
			e.preventDefault();
		})
	});
}