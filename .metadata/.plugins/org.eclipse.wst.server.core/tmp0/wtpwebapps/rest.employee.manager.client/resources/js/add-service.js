$(function() {

	$('.add-and-update').click(function(){
		var checks = [];
		$('input[name=checkbox2]:checked').each(function() {
			var id = $(this).parents('tr').children('td').eq(2).text();
			//alert(id);
			checks.push(id);
		});

		//alert("checks="+checks);
		//alert("length = "+checks.length);
		if(checks.length == 0) alert("No checkbox");
		else {
			window.open('insert-to-db-service?checks='+checks,'_self');	
			alert("Added successfully");
		};});
})