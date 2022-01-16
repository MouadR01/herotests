$(document)
	.ready(
		function() {

			table = $('#tcrenauxSalle')
				.DataTable({
					ajax: {
						url: "crenauxSalles/all",
						dataSrc: ''
					},
					columns: [
						{
							data: "id"
						},
						{
							data: "date"
						},
						{
							data: "salle.type"
						},
						{
							data: "crenaux.heureDebut"
						},

						{
							data: "crenaux.heureFin"
						},

						{
							data: "user.username"
						},
						{
							"render": function() {
								return '<button type="button" class="btn btn-outline-danger supprimer">Supprimer</button>';
							}
						},
						{
							"render": function(e) {
								return '<button type="button" class="btn btn-outline-secondary valider">Valider</button>';
							}
						},
						{
							"render": function() {
								return '<button type="button" class="btn btn-outline-secondary modifier">Modifier</button>';
							}
						}]

				});

			$.ajax({
				url: '/crenaux/all',
				type: 'GET',
				success: function(data) {
					var option = '';
					data.forEach(e => {
						option += '<option value =' + e.id + '>' + e.heureDebut + '->' + e.heureFin + '</option>';
					});

					$('#crenaux').append(option);
				},

				error: function(jqXHR, textStatus,
					errorThrown) {
					console.log(textStatus);
				}


			}
			);
			$.ajax({
				url: '/salles/all',
				type: 'GET',
				success: function(data) {
					var option = '';
					data.forEach(e => {
						option += '<option value =' + e.id + '>' + e.type + '</option>';
					});

					$('#salle').append(option);
				},

				error: function(jqXHR, textStatus,
					errorThrown) {
					console.log(textStatus);
				}


			}
			);
			$.ajax({
				url: '/users/all',
				type: 'GET',
				success: function(data) {
					var option = '';
					data.forEach(e => {
						option += '<option value =' + e.id + '>' + e.username + '</option>';
					});

					$('#user').append(option);
				},

				error: function(jqXHR, textStatus,
					errorThrown) {
					console.log(textStatus);
				}


			}
			);



			$('#btn').click(
				function() {
					var date = $("#date");
					var crenaux = $("#crenaux");
					var salle = $("#salle");
					var user = $("#user");
					if ($('#btn').text() == 'Ajouter') {
						var p = {
							date: date.val(),
							crenaux: {
								id: crenaux.val()
							},
							user: {
								id: user.val()
							},
							salle: {
								id: salle.val()
							}
						};

						$.ajax({
							url: 'crenauxSalles/save',
							contentType: "application/json",
							dataType: "json",
							data: JSON.stringify(p),
							type: 'POST',
							async: false,
							success: function(data, textStatus,
								jqXHR) {
								table.ajax.reload();
							},
							error: function(jqXHR, textStatus,
								errorThrown) {
								console.log(textStatus);
							}
						});
						$("#main-content").load(
							"./page/crenauxSalle.html");
					}
				});

			$('#table-content')
				.on(
					'click',
					'.supprimer',
					function() {

						var id = $(this).closest('tr').find(
							'td').eq(0).text();
						var oldLing = $(this).closest('tr')
							.clone();
						var newLigne = '<tr style="position: relative;" class="bg-light" ><th scope="row">'
							+ id
							+ '</th><td colspan="4" style="height: 100%;">';
						newLigne += '<h4 class="d-inline-flex">Voulez vous vraiment supprimer cette marque ? </h4>';
						newLigne += '<button type="button" class="btn btn-outline-primary btn-sm confirmer" style="margin-left: 25px;">Oui</button>';
						newLigne += '<button type="button" class="btn btn-outline-danger btn-sm annuler" style="margin-left: 25px;">Non</button></td></tr>';

						$(this).closest('tr').replaceWith(
							newLigne);
						$('.annuler').click(
							function() {
								$(this).closest('tr')
									.replaceWith(
										oldLing);
							});
						$('.confirmer')
							.click(
								function(e) {
									e.preventDefault();
									$
										.ajax({
											url: 'crenauxSalles/deletee/{salle,crenaux}?creneaux=' + crenaux + '&salle=' + salle
											,
											data: {},
											type: 'DELETE',
											async: false,
											success: function(
												data,
												textStatus,
												jqXHR) {
												if (data
													.includes("error") == true) {
													$(
														"#error")
														.modal();
												} else {
													table.ajax
														.reload();
												}
											},
											error: function(
												jqXHR,
												textStatus,
												errorThrown) {
												$(
													"#error")
													.modal();
											}
										});

								});

					});

			$('#table-content').on(
				'click',
				'.valider',
				function(e) {
					var crenaux = $(this).closest('tr').find('td')
						.eq(3).text();
					var salle = $(this).closest('tr').find('td')
						.eq(1).text();
					e.preventDefault();
					$
						.ajax({
							url: 'crenauxSalles/findme/{salle,crenaux}?creneaux=' + crenaux + '&salle=' + salle
							,
							data: {},
							type: 'POST',
							async: false,
							success: function(
								data,
								textStatus,
								jqXHR) {
								if (data
									.includes("error") == true) {
									$(
										"#error")
										.modal();
								} else {
									table.ajax
										.reload();
								}
							},
							error: function(
								jqXHR,
								textStatus,
								errorThrown) {
								$(
									"#error")
									.modal();
							}
						});

				});
			$('#table-content').on(
				'click',
				'.modifier',
				function() {
					var btn = $('#btn');
					var id = $(this).closest('tr').find('td').eq(0)
						.text();
					var date = $(this).closest('tr').find('td')
						.eq(1).text();
					var crenaux = $(this).closest('tr').find('td')
						.eq(3).text();
					var salle = $(this).closest('tr').find('td')
						.eq(2).text();
					var user = $(this).closest('tr').find('td')
						.eq(4).text();


					btn.text('Modifier');
					$("#date").val(date);
					var op = $('#crenaux option').filter(function() {
						return $(this).html() == crenaux;
					}).val();
					$("#crenaux").val(op);
					var op1 = $('#user option').filter(function() {
						return $(this).html() == user;
					}).val();
					$("#user").val(op1);
					var opp = $('#salle option').filter(function() {
						return $(this).html() == salle;
					}).val();
					$("#salle").val(opp);
					$("#id").val(id);

					btn.click(function(e) {
						e.preventDefault();
						var p = {
							id: $("#id").val(),
							date: $("#date").val(),
							crenaux: {
								id: $("#crenaux").val()

							},
							user: {
								id: $("#user").val()

							},
							salle: {
								id: $("#salle").val()

							}

						};
						if ($('#btn').text() == 'Modifier') {
							$.ajax({
								url: 'crenaux/save',
								contentType: "application/json",
								dataType: "json",
								data: JSON.stringify(p),
								type: 'POST',
								async: false,
								success: function(data,
									textStatus, jqXHR) {
									table.ajax.reload();
									$("#date").val('');
									$("#crenaux").val('');
									$("#salle").val('');
									btn.text('Ajouter');
								},
								error: function(jqXHR, textStatus,
									errorThrown) {
									console.log(textStatus);
								}
							});
							$("#main-content").load(
								"./page/crenaux.html");
						}
					});
				});


		})
	;
