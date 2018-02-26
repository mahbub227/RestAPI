	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : "/employee/list",
			success: function(result){
				$.each(result, function(i, employee){
					
					var employeeRow = '<tr>' +
										'<td>' + employee.employeeName + '</td>' +
										'<td>' + employee.workPhone + '</td>' +
										'<td>' + employee.workEmail + '</td>' +
										'<td>' + employee.department + '</td>' +
										'<td>' + employee.jobTitle + '</td>' +
										'<td>' + employee.manager + '</td>' +
									  '</tr>';
					
					$('#employeeListTable tbody').append(employeeRow);
					
		        });
				
				$( "#customerTable tbody tr:odd" ).addClass("info");
				$( "#customerTable tbody tr:even" ).addClass("success");
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});	
	}
	
	function addForm(){
		
	}





