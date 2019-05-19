var menu = $("#menu");
$.get({
    url: "/Effluve/header",
    dataType: 'html',
    success: function (data) {
        menu.append($(data));
    }
});