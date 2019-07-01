/**
 * 
 */
$(document).ready(function () {
	if ($("#nomeFabricanteErro").length){
		$("#nomeFabricante").addClass("is-invalid");
	}
});

$("#nomeFabricante").click(function(){
	$("#nomeFabricante").removeClass("is-invalid");
});