window.onload = function() {
	loadLandingView();
}

function loadLandingView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
			$('#login').on('click', ()=>{
				 if(document.getElementById("user").value.length == 0  || document.getElementById("password").value.length == 0 ){
					 $('#message').html("user name or password can't be empty");
				 }else{
					 processLogin();
				 }
			});
		}
	}
	xhr.open("GET", "login.view");
	xhr.send();
}

function processLogin() {
	let user = {
		userName : $('#user').val(),
		password : $('#password').val(),
		type : "0"
	};
	
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			if (xhr.responseText == "null") {
				$('#message').html("Invalid user name or password");
			} else {
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
			// DashBoard for manager
			if (user.type == 1) {
				$("#logout").on('click', logout);
				$("#all").on('click', displayAllReimbTable);
				displayAllReimbTable();

				// DashBoard for employee
			} else if (user.type == 2) {
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

function logout() {
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

function create() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#content').html(xhr.responseText);
			// validation for create reimb
			$("#submit_reimb").on('click', send_reimb);
		}
	}
	xhr.open("GET", "create.view");
	xhr.send();
}

function send_reimb() {
	let reimb = {
		amount : $('#reimb_amount').val(),
		description : $('#reimb_description').val(),
		type : $("#reimb_type").val()
	};
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#content').html(xhr.responseText);
			displayReimbTable();
		}
	}
	xhr.open("POST", "submitReimb");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(reimb));
}

function displayReimbTable() {
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

function displayAllReimbByUser() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let res = JSON.parse(xhr.responseText);
			$(document)
					.ready(
							function() {
								var table = $('#table_id')
										.DataTable(
												{
													"destroy" : true,
													data : res,
													"order" : [ [ 2, "asc" ] ],
													columns : [
															{
																data : 'reimbAmount'
															},
															{
																data : 'reimbSubmitted',
																type : 'date',
																render : function(
																		value) {
																	return new Date(
																			value)
																			.toDateString();
																}
															},
															{
																data : 'reimbResolved',
																type : 'date',
																render : function(
																		value) {
																	if (new Date(
																			value)
																			.toDateString() == "Wed Dec 31 1969")
																		return null;
																	else
																		return new Date(
																				value)
																				.toDateString();
																}
															},
															{
																data : 'reimbDescription'
															},
															{
																data : 'res_firstName'
															},
															{
																data : 'res_lastName'
															},
															{
																data : 'res_email'
															},
															{
																data : 'status'
															},
															{
																data : 'reimbType'
															}, ]
												});

								$('#table_id tbody').on(
										'click',
										'tr',
										function() {
											var data1 = table.row(this).data();
//											alert('You clicked on ' + data1[0] + '\'s row');
										});
							});
		}
	}
	xhr.open("GET", "displayReimbByUser");
	xhr.send();
}

function displayAllReimbTable() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#content').html(xhr.responseText);
			displayAllReimbForManager();
		}
	}
	xhr.open("GET", "allReimbForManager.view");
	xhr.send();
}

function displayAllReimbForManager() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let res = JSON.parse(xhr.responseText);
			$(document)
					.ready(
							function() {
								var table = $('#table_id')
										.DataTable(
												{
													"destroy" : true,
													data : res,
													"order" : [ [ 2, "asc" ] ],
													columns : [
															{
																data : 'reimbAmount'
															},
															{
																data : 'reimbSubmitted',
																type : 'date',
																render : function(
																		value) {
																	return new Date(
																			value)
																			.toDateString();
																}
															},
															{
																data : 'reimbResolved',
																type : 'date',
																render : function(
																		value) {
																	if (new Date(
																			value)
																			.toDateString() == "Wed Dec 31 1969")
																		return null;
																	else
																		return new Date(
																				value)
																				.toDateString();
																}
															},
															{
																data : 'reimbDescription'
															},
															{
																data : 'auth_firstName'
															},
															{
																data : 'auth_lastName'
															},
															{
																data : 'auth_email'
															},
															{
																data : 'res_firstName'
															},
															{
																data : 'res_lastName'
															},
															{
																data : 'res_email'
															},
															{
																data : 'status'
															},
															{
																data : 'reimbType'
															}, ]
												});

								$('#table_id tbody').on('click', 'tr',
										function() {
											var row = table.row(this).data();
											openReimbWindow(row);
										});
							});
		}
	}
	xhr.open("GET", "displayReimbForManager");
	xhr.send();
}

function openReimbWindow(row) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#content').html(xhr.responseText);
			$('#one_reimb_amount').text(row.reimbAmount);
			$('#one_reimb_first').text(row.auth_firstName);
			$('#one_reimb_last').text(row.auth_lastName);
			$('#one_reimb_email').text(row.auth_email);
			$('#one_reimb_type').text(row.reimbType);
			$('#approved').click(function() {
				alert("Succes update reimbersement"); 
				processApproved(row);
			});
			$('#denied').click(function() {
				alert("Succes update reimbersement"); 
				processDenied(row);
			});
		}
	}
	xhr.open("GET", "editReimb.view");
	xhr.send();
}

function processApproved(row) {
	row.status = "approved";
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//$('#content').html(xhr.responseText);
			displayAllReimbTable();

		}
	}
	xhr.open("POST", "approved");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(row));
}

function processDenied(row) {
	row.status = "denied";
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//$('#content').html(xhr.responseText);
			displayAllReimbTable();

		}
	}
	xhr.open("POST", "denied");
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(JSON.stringify(row));
}
