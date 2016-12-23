function getListeActeur(){
	var requeteListeacteur = new XMLHttpRequest();
	requeteListeacteur.open("GET","deleteacteur",true);
	requeteListeEntreprises.responseType="json";
		
	requeteListeacteur.onload= function(){
		for(var i=0;i<this.response.length;i++){
			console.log("acteur : "+this.response[i].nom);
			
		}
		console.log("Liste des acteurs : " + JSON.stringify(this.response));
	}
	
	requeteListeacteur.send();
}





window.onload = function() {
	getListeacteur();
	

	
	document.getElementById("#bouton").onsubmit = function() {
		//votre code lorsque le formulaire submit
		deleteActeur();
		return false; //pour empêcher le formulaire de 				continuer le submit normal
	};