$(function(){
	
	$("#submitEmployeeForm").submit(function(e){
		e.preventDefault();
		var frm = $("#submitEmployeeForm");
		var data = {};
		$.each(this, function(i, v){
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
		});
		saveRequestedData(frm,data);
	});
	
	
	function saveRequestedData(frm,data){
		$.ajax({
			contentType : "application/json",
			type : frm.attr("method"),
			url : frm.attr("action"),
			dataType : 'json',
			data : JSON.stringify(data),
			success:function(data){
				if(data.status=="success"){
					alert(data.message);
					window.location.href = "/";
				}
				else{
					alert(data.message);
				}
				
				
			}
		});
	}
})

