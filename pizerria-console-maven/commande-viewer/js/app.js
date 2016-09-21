function test()
{
	
	$.ajax({
		url : "http://localhost:8080/pizerria-admin-web/api/rest/commande/",
		type : "GET",
		dataType : "JSON", // On désire recevoir du JSON
		success : function(data,statut){ 
			console.log(status);
			console.log(data);
			data.forEach(function(commande) {
				var time_st = commande.date_commande;
				var r = new Date(time_st);
				
				$("#myTab").append("<tr>");
				$("#myTab").append("<td>"+ commande.id+"</td>");
				$("#myTab").append("<td>"+r+"</td>");
				$("#myTab").append("<td>"+ commande.numero_commande+"</td>");
				$("#myTab").append("<td>"+ commande.status +"</td>");
				$("#myTab").append("<td>"+ commande.livreur_id.nom+"</td>");
				$("#myTab").append("<td>"+ commande.client_id.nom+"</td>");
				$("#myTab").append("</tr>");
			
			})
		}// code_html contient le HTML renvoyé
	})
};
$(document).ready(function(){
    $("button").click(function(){
        $("#myTab").slideToggle(100);
    });
});
test();