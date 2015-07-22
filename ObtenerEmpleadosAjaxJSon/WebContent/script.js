var xmlHttp = null;

function iniciaObjetoRequest() {
	return new XMLHttpRequest();
}

function rellenaCaja() {
	var eleccion = document.getElementById("eleccion");
	eleccion = eleccion.options[eleccion.selectedIndex].value;
	xmlHttp = iniciaObjetoRequest();
	xmlHttp.onreadystatechange = procesarTrabajadores;
	xmlHttp.open('GET', 'getemplyoeesajax?eleccion=' + eleccion, true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
	xmlHttp.send(null);
}

function procesarTrabajadores() {
	//Obtenemos el control del TAG que contendrá la respuesta
	if (xmlHttp.readyState == 4) // ya hemos recibido respuesta del servidor
	{
		if (xmlHttp.status == 200)// y el código de la cabecera http es bueno
		{
			//alert("He recibido " + xmlHttp.responseText);
			var parser = new DOMParser();
			var xmlDoc = parser.parseFromString(xmlHttp.responseText,
					"application/xml"); //OBTENEMOS EL XML CREADO POR EL SERVLET DELA RESPUESTA.
			//OBTENEMOS LOS ELEMENTOS EMPLEADO DEL XML  (PQ SE COMO SE LLAMA PREVIAMENTE).
			var lista_empleados = xmlDoc.getElementsByTagName("empleado");
			var nelementos = lista_empleados.length; //CREAMOS UNA VARIABLE nELEMENTOS PARA LUEGO ITERAR

			var id = null;
			var nombre = null;
			
			var tablaCreada = document.getElementById("tabla"); //CREAMOS UNA TABLA CON JS.
			
			if(null != tablaCreada){ //SI NO DEVUELVE NADA LA TABLA NO EXISTE Y NO HAY QUE BORRARLA
				tablaCreada.remove()
			}
			
			//La variable que contendrá nuestro div que contendrá la tabla
			var divtabla = document.getElementById("divtabla");
			
			//CREAMOS ATTS DE LA TABLA PARA QUE QUE BONITA
			var table = document.createElement('table');
			table.setAttribute("id", "tabla");
			var trCabecera = document.createElement('tr');
			var th1 = document.createElement('th');
			var th2 = document.createElement('th');
			var titulo1 = document.createTextNode("ID EMPLEADO");
			var titulo2 = document.createTextNode("NOMBRE EMPLEADO");
			
			th1.appendChild(titulo1);
			th2.appendChild(titulo2);
			trCabecera.appendChild(th1);
			trCabecera.appendChild(th2);
			table.appendChild(trCabecera);
			
			
			//POR CADA ITERACION DEL BUCLE OBTENEMOS 
			for (var i = 0; i < nelementos; i++) {
				//OBTENEMOS EL ELEMENTO 0 del tagName del elemento i de la lista.
				id = lista_empleados[i].getElementsByTagName("empleadoid")[0].childNodes[0].data; 
				nombre = lista_empleados[i].getElementsByTagName("empleadoNom")[0].childNodes[0].data;

				//CREAMOS LOS ELEMENTOS POR CADA EMPLOYEE
				 var tr = document.createElement('tr'); 
				 var td1 = document.createElement('td');
				 var td2 = document.createElement('td');

				 tr.setAttribute("onclick", "getInfoTrabajadores("+id+");");
			
				 
				 //CREAMOS UN NODO CON EL TEXTO QUE VA A IR DENTRO DE NUESTROS TD's :·)
				 var idEmple = document.createTextNode(id);
				 var nomEmple = document.createTextNode(nombre);
				 
				 
				 td1.appendChild(idEmple);
				 td2.appendChild(nomEmple);
				 tr.appendChild(td1);
				 tr.appendChild(td2);
				 table.appendChild(tr);
			}
//				document.body.appendChild(table);
				divtabla.appendChild(table);
		} 
			else {
				alert("Ha ocurrido un error" + xmlHttp.status + ":" + xmlHttp.statusText);
			}
	}
}

function getInfoTrabajadores(entero){
	xmlHttp = iniciaObjetoRequest();
	xmlHttp.onreadystatechange = procesarInfoTrabajadores;
	xmlHttp.open('GET', 'getinfojson?trabajador=' + entero, true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
	xmlHttp.send(null);
	var divtrabajadores = document.getElementById("divtrabajadores");
}

function procesarInfoTrabajadores(){
	
	if(xmlHttp.readyState==4) //ya hemos recibido respuesta del servidor
	  {
	      if(xmlHttp.status==200)// y el código de la cabecera http es bueno
	          {
				//alert("He recibido " + xmlHttp.responseText);
				var divtrabajadores = document.getElementById("divtrabajadores");
				var trabajador = JSON.parse(xmlHttp.responseText);
				divtrabajadores.innerHTML = "<p><strong>Nombre:</strong> " + trabajador.nombre + " <strong>Apellido:</strong> " + trabajador.apellido + " <strong>Telf:</strong> " + trabajador.telefono + " <strong>correo electronico:</strong> " + trabajador.email +"</p>";
				
	          }
	      else
	      {
	          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
	      }
	
	  }
}