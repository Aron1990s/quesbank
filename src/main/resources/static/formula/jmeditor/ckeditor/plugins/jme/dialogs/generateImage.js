$(function(){

})

function generateImg() {
    $('#jme-math').css('border','none');
    $('#jme-math .non-leaf').each(function () {
        $(this).css('margin-left','5px')
    })
    html2canvas($('#jme-math'),{
        dpi:1000,
        onrendered: function(canvas) {
            convertCanvasToImage(canvas);
        }
    })
}

function convertCanvasToImage(canvas) {
    var image = new Image();
    image.src = canvas.toDataURL("image/gif");
    image.style.width = canvas.width/11 + 'px';
    image.style.height = canvas.height/11 + 'px';
    var picture = image.src.replace('data:image/png;base64,','');
    $.ajax({
        cache : true,
        type : "POST",
        url : "/quesBank/imgUploadCtl/upload",
        async: false,
        data : {
            base64: picture
        },
        async : false,
        error : function(request) {
            alert("error")
        },
        success : function(data) {
            image.src = '/quesBank/image/'+data+'.png';
        }
    });
    $('#jme-math').empty();
    $('#jme-math').append(image);
    return image;
}