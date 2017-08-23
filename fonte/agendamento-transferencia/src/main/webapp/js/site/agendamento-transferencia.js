function formataValor(elemento) {
	var valor =  formatarValorMonetarioOnType(elemento.value);
	elemento.value = valor;
}

function formataValorConta(numero){
	var numeroValor = numero.value;
	var tamanhoNumero = numeroValor.length;
	
	if(tamanhoNumero == 5){
		numeroValor = numeroValor + '-';
		numero.value = numeroValor;
	}
	if(tamanhoNumero == 6){
		//remove o ultimo elemento se igual a -
		var ultimoElemento = numeroValor.substr(tamanhoNumero -1,tamanhoNumero);
		if(ultimoElemento == '-'){
			numeroValor = numeroValor.substr(0,tamanhoNumero -1);
		}
	}
	if(tamanhoNumero > 7){
		//remove o ultimo caracter
		numeroValor = numeroValor.substr(0,5) + '-' + numeroValor.substr(6,1) ;
	}
	numero.value = numeroValor;
	
}


function formatarValorMonetarioOnType(valor){
	
	var number = valor;
    var rgx = /^(\d+)(\.\d+)*?(\,\d+?)*$/;
    
   	var tamanho = number.length;

   	if (!rgx.test(number)) {
    	//obter o ultimo carater
    	//remove o ultimo caracter digitado errado
		number = number.substr(0,tamanho -1);
    	return number;
    }else{

    	
    	if(tamanho == 1){
    		number =  '0,0' + number;	
    	}
    	if(tamanho == 2){
    		number =  '0,' + number;	
    	}

    	//mover uma posicao da virgula para direita
			number = number.replace(',','');
			tamanho = number.length;
    	if(tamanho >= 2){
    		
    		var primeiroCaracter = number.substr(0,1);
    		var segundoCaracter = number.substr(1,1);
    		var valorAntesVirgula = number.substr(0, tamanho - (2));
    		if(valorAntesVirgula == ''){
    			valorAntesVirgula = '0';
    		}
    		
    		var valorDepoisVirgula = number.substr(tamanho -2 , tamanho)
    		valorAntesVirgula = valorAntesVirgula.replace('.','');
    		number = valorAntesVirgula + ',' + valorDepoisVirgula;
    		if((primeiroCaracter == '0' && tamanho >= 4) || (primeiroCaracter == '0' && segundoCaracter == '0') && tamanho >= 4){
    			number = number.substr(1, tamanho);
    		}
    		valorAntesVirgula = valorAntesVirgula.replace(/\./g , '');
   			var tamanhoAntesVirgula = valorAntesVirgula.length;
    		if(tamanhoAntesVirgula > 3){
				var totalPontos = Math.floor(tamanhoAntesVirgula/3);
				var numerosAntesPonto = tamanhoAntesVirgula - (totalPontos * 3);
				var valorAntesPonto = valorAntesVirgula.substr(0, numerosAntesPonto);
				var valorDepoisPonto = valorAntesVirgula.substr(numerosAntesPonto, tamanhoAntesVirgula);
				
				var tamanhoValorDepoisPonto = valorDepoisPonto.length;
				var contadorCaracteres = 0;
				var novovalorDepoisPonto = '';
					for(var i = 0; i < tamanhoValorDepoisPonto; i=i+3){
						if(valorAntesPonto == '' && i == 0){
							novovalorDepoisPonto += valorDepoisPonto.substr(i,3) ;
						}else{
							novovalorDepoisPonto +=  '.' + valorDepoisPonto.substr(i,3) ;
						}
					}
					number = valorAntesPonto + novovalorDepoisPonto	+ ',' +valorDepoisVirgula;					
    			
    		}
    		
    	}
    	return number;
    }
}
