window.onload = function() {
	console.log("in load function");
	loadLandingView();
}

function loadLandingView() {
	console.log("in loadlandView function");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#message').html("Not logged yet");
			console.log("Waiting for key to press");
			$('#login').on('click', processLogin);
			
		}
	}
	xhr.open("GET", "login.view");
	xhr.send();
}

function processLogin(){
	console.log("Login Key Pressed");
	let user = {
			userName: $('#user').val(), 
			password: $('#password').val()
	};
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//get response body and console.log it 
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			console.log(typeof(xhr.responseText));
			if(xhr.responseText == "null"){
				$('#message').html("Invalid user name or password");
			}else{
				var user = JSON.parse(xhr.responseText);
				
				$('#message').html("");
			}
		}
	}
	xhr.open("POST", "login");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(user));
	
}

function loadDashboard() {
	console.log("in loadDashboard function");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#message').html("Not logged yet");
			console.log("Waiting for key to press");
			$('#login').on('click', processLogin);
			
		}
	}
	xhr.open("GET", "login.view");
	xhr.send();
}


