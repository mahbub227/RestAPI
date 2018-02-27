$(function(){
	
	fetchTable();
	
});


function fetchTable(){
	var $table = $('#employeeListTable');

	if ($table.length) {


		var jsonUrl = '';
			jsonUrl = window.contextRoot + '/list';

	$table
	.DataTable({
		lengthMenu : [ [ 5, 10, -1 ],
				[ '5 Records', '10 Records', 'All' ] ],
		pageLength : 5,
		ajax : {
			url : jsonUrl,
			dataSrc : ''
		},
		columns : [
				{
					data : 'employeeName',
				mRender : function(data, type, row) {
					var str = '';
					str += '<a href="/show?id=+'
						+row.employeeId
						+'">'+data+'</a>';
					return str;
				}
				},
				{
					data : 'workPhone',
				},
				{
					data : 'workEmail',
				},
				{
					data : 'department',
				},
				{
					data : 'jobTitle',
				},
				{
					data : 'manager',
				},]

	});
}
	
}


function addForm(id){
	modifyUrl("/form?id=+"+id);
}


function show(id){
	modifyUrl("/show?id=+"+id);
}

function home(){
	modifyUrl("/");
	fetchTable();
}


function modifyUrl(url){
	$.ajax({
		type : "GET",
		url : url,
		success : function(data){
			$(".panel-default").html(data);
		}
	});
}
