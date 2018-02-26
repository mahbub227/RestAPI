
<div class="panel panel-default">
<div class="panel-heading">
					<a href="${path}/form" class="btn btn-info">Create</a>
				</div>
				<div class="panel-body">

					<table id="employeeListTable"
						class="table table-bordered table-condensed table-hover table-striped">
						<thead>
							<tr>
								<th>Name</th>
								<th>Work Phone</th>
								<th>Work Email</th>
								<th>Department</th>
								<th>Job Title</th>
								<th>Manager</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${employees}"	 var="employee">
						<tr>
						<td>${employee.employeeName}</td>
						<td>${employee.workPhone}</td>
						<td>${employee.workEmail}</td>
						<td>${employee.department}</td>
						<td>${employee.jobTitle}</td>
						<td>${employee.manager}</td>
						</tr>
						</c:forEach>
						</tbody>

					</table>

				</div>
				</div>