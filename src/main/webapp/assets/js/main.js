var menu = $("#menu");
$.get({
    url: "/Effluve/header",
    dataType: 'html',
    success: function (data) {
        menu.append($(data));
    }
});

$('form').on('submit', function(){
	var validate = true;
	var requiredInputs = $(this).find('input.required');
	if(requiredInputs.length > 0){
		requiredInputs.each(function(){
			var requiredInput = $(this);
			if(requiredInput.first('input').val() == ''){
				requiredInput.addClass('invalidated');
				validate = false;
			}
		});
	}
	return validate;
});