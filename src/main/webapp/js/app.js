window.onload = function() {
	loadLandingView();
}

function loadLandingView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#login').on('click', processLogin);
		}
	}
	xhr.open("GET", "login.view");
	xhr.send();
}

function processLogin(){
	let user = {
			userName: $('#user').val(), 
			password: $('#password').val(),
			type: "0"
	};
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			if(xhr.responseText == "null"){
				$('#message').html("Invalid user name or password");
			}else{
				var user = JSON.parse(xhr.responseText);
				console.log(user);
				loadDashboard(user);
			}
		}
	}
	xhr.open("POST", "login");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(user));
	
}

function loadDashboard(user) {
	console.log("in loadDashboard function");
	console.log("User in dashboard function is: " + user.type);
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("POST", "loadDashboard.view");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(user));
}

