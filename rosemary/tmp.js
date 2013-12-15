				url: "https://heanoria.appspot.com/_ah/api/helichrysum/v1/artistes/list",
				type: "GET",
				contentType: "application/json, charset=utf-8",
				success: function(result){
					console.log(result.items);
				},
				error:function(jqXHR, textStatus, errorThrown){
					console.log(errorThrown);
				}
				
							var artiste = {"id":"5741031244955648","nom":"Ensiferum", "genre":"Pagan Black Metal", "albums":[{"id":"5649050225344512"}]}
			$.ajax({
				url: "https://heanoria.appspot.com/_ah/api/helichrysum/v1/artistes/create",
				dataType: 'json',
				type: "POST",
				contentType: "application/json, charset=utf-8",
				data: JSON.stringify(artiste),
				success: function(result){
					console.log(result);
				},
				error:function(jqXHR, textStatus, errorThrown){
					console.log(errorThrown);
				}
			});