$(document).ready(function () {
	if ($("#nomeSecaoErro").length){
		$("#nomeSecao").addClass("is-invalid");
	}
});

$("#nomeSecao").click(function(){
	$("#nomeSecao").removeClass("is-invalid");
});