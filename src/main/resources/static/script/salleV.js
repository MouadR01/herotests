$(document)
	.ready(
		function() {

			table = $('#tsalle')
				.DataTable({
					ajax: {
						url: "salles/all",
						dataSrc: ''
					},
					columns: [
						{
							data: "id"
						},
						{
							data: "code"
						},
						{
							data: "type"
						},
						{
							data: "capacite"
						},
						{
							data: "bloc.code"
						}]

				});

			$("#main-content").load(
				"./page/salleV.html");
		}
			)				

