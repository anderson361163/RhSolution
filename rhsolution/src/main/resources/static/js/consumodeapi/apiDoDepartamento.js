			
		function addOption(valor) {
			variavel = valor;
		    var select = document.getElementById("listadepartamento");
		    
		    for(let i =0; i<valor.data.length;i++){

		    	var option = new Option(valor.data[i].nome, valor.data[i].id);
		    	console.log(option);
			    select.add(option);
		    }
		}
	
		function chamaTodosOsDepartamentos(){
			axios.get('/listaTodosDepartamentos').then(function (response){
				variavelcompleta = response;
				addOption(response);
				console.log(response);
			});
		}
	