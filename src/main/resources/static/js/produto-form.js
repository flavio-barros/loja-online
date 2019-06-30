/**
 * 
 */

$(document).ready(function () {
	$('[name=preco]').maskNumber({decimal: ',', thousands: '.'});
	
	if ($("#nomeProdutoErro").length){
		$("#nomeProduto").addClass("is-invalid");
	}
	
	if ($("#fabricanteProdutoErro").length){
		$("#fabricanteProduto").addClass("is-invalid");
	}
});

$("#nomeProduto").click(function(){
	$("#nomeProduto").removeClass("is-invalid");
});

$("#formProduto").submit(function(){
	var value = $("#precoProduto").val();
	value = value.replace(".", "");
	value = value.replace(",", ".");
	$("#precoProduto").val(value);
});