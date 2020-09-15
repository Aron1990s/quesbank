$(function() {
	$.ajax({
        type: "get",
        url: '../leftNavCtl/initNavByMajor',
        dataType: "json",
        success: function(result) {
            var res = eval(result.data);
            showSideMenu(res);
        }
    });

	$("#navmenu").on("click", ".liname", function(index) {
		var index = $("#navmenu .liname").index(this);
		$("#navmenu>li>.child_menu").eq(index).slideToggle();
		$("#navmenu>li>.child_menu").eq(index).parent().siblings("li").find(".child_menu").slideUp();
	});

    $("#navmenu").on("click", ".linameSub", function(index) {
        var index = $("#navmenu .linameSub").index(this);
        $("#navmenuSub>li>.child_menu").eq(index).slideToggle();
        $("#navmenuSub>li>.child_menu").eq(index).parent().siblings("li").find(".child_menu").slideUp();
    });
	

});

function showSideMenu(res) {
	for(var i = 0; i < res.length; i++) {
		var html = "";
		html += "<li>";
		html += "<a class='liname'><i class='fa fa-check-circle'></i>" + res[i].menuName + "<span class='fa fa-chevron-down'></span></a>";
		html += "<ul class='nav child_menu' id='navmenuSub'>";
		for(var k = 0; k < res[i].children.length; k++) {
			if(typeof(res[i].children[k].children) != 'undefined') {
				html += "<li class='three_menu'>";
				html += "<a class='linameSub' href='" + res[i].children[k].menuAction + "'>" + res[i].children[k].menuName + "</a>";
				html += "<ul class='nav child_menu'>";
				for(var j = 0; j < res[i].children[k].children.length; j++) {
					html += "<li>";
					html += "<a  onclick=goToQuestionList('" + res[i].children[k].children[j].menuAction + "')>" + res[i].children[k].children[j].menuName + "</a>";
					html += "</li>";
				}
				html += "</ul>";
				html += "</li>";
			} else if(typeof(res[i].children[k].children) == 'undefined'){
				html += "<li>";
				html += "<a onclick=goToQuestionList(\'" + res[i].children[k].menuAction + "\')>" + res[i].children[k].menuName + "</a>";
				html += "</li>";
			}
		}
		html += "</ul>";
		html += "</li>";
		$("#navmenu").append(html);
	};
	$("#navmenu .child_menu").eq(0).css({
		"display": "block"
	});
	$("#navmenu .child_menu").eq(0).find("li:eq(0)").addClass("current-page");

	var fram = "<iframe src='' name='myFrame' id='myIframe' width='100%' height='100%'  scrolling='auto' frameborder='0'></iframe>"
	$("#rightContent").append(fram);

	$("#navmenu .child_menu").on("click", "li", function() {
		var index = $("#navmenu .child_menu li").index(this);
		$("#navmenu .child_menu li").eq(index).parent().parent().siblings("li").find(".child_menu").slideUp();
		$("#navmenu .child_menu li").eq(index).parent().parent().siblings("li").find(".child_menu").find("li").removeClass("current-page");
		$("#navmenu .child_menu li").eq(index).addClass("current-page")
		$("#navmenu .child_menu li").eq(index).siblings().removeClass("current-page");
	});

	
	$("#navmenu").on("click", ".three_menu", function() {
		var index = $("#navmenu .three_menu").index(this);
		$("#navmenu .three_menu .child_menu").eq(index).slideDown();
	});
	
	

	$("#navmenu .three_menu").on("click", "li", function() {
		var index = $("#navmenu .three_menu li").index(this);
		$("#navmenu .three_menu li a").eq(index).css({
			"color": "beige"
		});
		$("#navmenu .three_menu li a").eq(index).parent().siblings("li").find("a").css({
			"color": "white"
		});

	});
    //
    //
	// var str = window.screen.availHeight - 170;
	// $("#rightContent").css({
	// 	"min-height": str
	// });
     //
	// var bdHeight = document.documentElement.clientHeight;
	// $("#rightContent").height(bdHeight - 65);

}