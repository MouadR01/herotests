$('a').removeClass('active');
$('a:contains(Statistiques)').addClass('active');
$("#main-content").load("page/statistiques.html");

function show(page) {
	if (page == 'produit') {
		$('a').removeClass('active');
		$('a:contains(Produit)').addClass('active');
		$("#main-content").load("page/produit.html");

		event.preventDefault();
	}
	if (page == "statistiques") {
		$('a').removeClass('active');
		$('a:contains(Statistiques)').addClass('active');
		$("#main-content").load("page/statistiques.html");
		event.preventDefault();
	}
	if (page == "marques") {
		$('a').removeClass('active');
		$('a:contains(Marques)').addClass('active');
		$("#main-content").load("page/marque.html");
		event.preventDefault();
	}
	if (page == "salles") {
		$('a').removeClass('active');
		$('a:contains(Salles)').addClass('active');
		$("#main-content").load("page/salle.html");
		event.preventDefault();
	}
	if (page == "sallesV") {
		$('a').removeClass('active');
		$('a:contains(Salles)').addClass('active');
		$("#main-content").load("page/salleV.html");
		event.preventDefault();
	}
	if (page == "machines") {
		$('a').removeClass('active');
		$('a:contains(Machines)').addClass('active');
		$("#main-content").load("page/machine.html");
		event.preventDefault();
	}
		if (page == "blocs") {
		$('a').removeClass('active');
		$('a:contains(Blocs)').addClass('active');
		$("#main-content").load("page/bloc.html");
		event.preventDefault();
	}
		if (page == "crenaux") {
		$('a').removeClass('active');
		$('a:contains(Crenaux)').addClass('active');
		$("#main-content").load("page/crenaux.html");
		event.preventDefault();
	}
		if (page == "crenauxV") {
		$('a').removeClass('active');
		$('a:contains(Crenaux)').addClass('active');
		$("#main-content").load("page/crenauxV.html");
		event.preventDefault();
	}
		if (page == "users") {
		$('a').removeClass('active');
		$('a:contains(Users)').addClass('active');
		$("#main-content").load("page/user.html");
		event.preventDefault();
	}
		if (page == "crenauxSalles") {
		$('a').removeClass('active');
		$('a:contains(CrenauxSalles)').addClass('active');
		$("#main-content").load("page/crenauxSalle.html");
		event.preventDefault();
	}
}
