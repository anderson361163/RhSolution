
	
	
	//valida caracteres
	function validaNumeros(valor){
		document.getElementsByName(valor.name)[0].value = valor.value.replace(/[^\d]/g, "");
	}
	
	function validaTexto(valor){
		document.getElementsByName(valor.name)[0].value = valor.value.replace(/[^A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]/g, "");

	}
 
	function validaDinheiro(valor){
		document.getElementsByName(valor.name)[0].value = valor.value.replace(/[^\d.]/g, "");

	}	 
	
