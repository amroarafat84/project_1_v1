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
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			//DashBoard for manager
			if(user.type == 1){
				$("#logout").on('click', logout);
				$("#all").on('click', displayReimbTable);  //should display all reimb 
				
			//DashBoard for employee
			}else if(user.type == 2) {
				$("#logout").on('click', logout);
				$("#create").on('click', create);
				$("#all").on('click', displayReimbTable);
				displayReimbTable();
			}
		}
	}
	xhr.open("POST", "loadDashboard.view");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(user));
}

function logout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			location.reload();
			sessionStorage.clear();
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "logout.view");
	xhr.send();
}

function create(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#content').html(xhr.responseText);
			$("#submit_reimb").on('click', send_reimb);
		}
	}
	xhr.open("GET", "create.view");
	xhr.send();
}

function send_reimb(){
	let reimb = {
			amount: $('#reimb_amount').val(), 
			description: $('#reimb_description').val(), 
			type: $("#reimb_type").val()
	};
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			$('#content').html(xhr.responseText);
			displayReimbTable();
		}
	}
	xhr.open("POST", "submitReimb");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(reimb));
}

function displayReimbTable(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#content').html(xhr.responseText);
			displayAllReimbByUser();
		}
	}
	xhr.open("GET", "allReimbForUser.view");
	xhr.send();
}

function displayAllReimbByUser(){
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			let res = JSON.parse(xhr.responseText);
			$(document).ready( function () {
			    $('#table_id').DataTable({
			    	"destroy": true,
			        data: res,
			        columns: [
			            { data: 'reimbId' },
			            { data: 'reimbAmount' },
			            { data: 'reimbSubmitted' },
			            { data: 'reimbResolved' },
			            { data: 'reimbDescription' },
			            { data: 'reimbResolver' },
			            { data: 'status' },
			            { data: 'reimbType' },
			        ]
			    } );
			} );
		}
	}
	xhr.open("GET", "displayReimbByUser");
	xhr.send();
}

