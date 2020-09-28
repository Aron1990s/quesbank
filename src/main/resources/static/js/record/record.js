function saveQuestion() {
    // var content = $('#majorSubItemNameBlock .select-picker-search-checked').html();
    // var contentList = content.split(',');
    // var majorSubItemList = ''
    // $('#majorSubItemName option').each(function () {
    //     var opt = $(this)
    //     for (var i = 0; i < contentList.length; i++) {
    //         if (opt.html() == contentList[i]){
    //             majorSubItemList += majorSubItemList == '' ? opt.val() : "," + opt.val();
    //         }
    //     }
    // })
    alert(getIdByContent('majorSubItemNameBlock','majorSubItemName'))
    return

    if ($('#question_type').val() == '' || $('#question_type').val() == null){
        layer.alert('请选择题目类型', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        return
    }
    if ($('#is_subExam').val() == '' || $('#is_subExam').val() == null){
        layer.alert('请选择是否小高考', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        return
    }
    if ($('#difficult_level').val() == '' || $('#difficult_level').val() == null){
        layer.alert('请选择题目难度', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        return
    }
    if ($('#chapterSubItemName').val() == '' || $('#chapterSubItemName').val() == null){
        layer.alert('请选择题目所属', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        return
    }
    if ($('#majorSubItemName').val() == '' || $('#majorSubItemName').val() == null){
        layer.alert('请选择题目所属知识点', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        return
    }

    var currentButton = $('#saveQuestion')
    var ableToNext = clearFormat()
    if (ableToNext == false){
        layer.alert('请将红框中的图片上传至服务器', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        return
    }
    $.ajax({
        cache: true,
        type: "POST",
        url: "/quesBank/highPhyQuesCtl/saveHighPhysicsQuestion",
        data: {
            id: $('#question_id').val(),
            question_type: $('#question_type').val(),
            is_subExam: $('#is_subExam').val(),
            question_content: JMEditor.html('questionContent'),
            grade_id: $('#gradeName').val(),
            chapter_id: $('#chapterName').val(),
            chapter_sub_id: $('#chapterSubName').val(),
            chapter_sub_item_id: $('#chapterSubItemName').val(),
            major_id: $('#majorName').val(),
            major_sub_id: $('#majorSubName').val(),
            major_sub_item_id: $('#majorSubItemName').val(),
            difficult_level: $('#difficult_level').val(),
            has_copy_right: $('#has_copy_right').val()
        },
        async: false,
        error: function (request) {
            alert("error")
        },
        success: function (data) {
            if (data.code == '1') {
                $('#question_id').val(data.questionId)
                layer.alert('保存成功', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 1})
                currentButton.removeClass('saveRecord')
                currentButton.addClass('editRecord')
                $('#saveFont').html('编辑题目')
            }else if(data.code == '2'){
                layer.alert('编辑成功', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 1})
            }

        }
    });
}

function saveSimpleAnswer() {
    if ($('#question_id').val() == '' || $('#question_id').val() == null){
        layer.alert('请先保存题目', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        return
    }
    var currentButton = $('#saveSimpleAnswer')
    var ableToNext = clearAnswerFormat()
    if (ableToNext == false){
        layer.alert('请将红框中的图片上传至服务器', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        return
    }
    $.ajax({
        cache: true,
        type: "POST",
        url: "/quesBank/highPhySimAnswerCtl/saveHighPhysicsSimpleAnswer",
        data: {
            question_id: $('#question_id').val(),
            simple_answer: JMEditor.html('questionSimpleSolve')
        },
        async: false,
        error: function (request) {
            layer.alert("error", {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        },
        success: function (data) {
            layer.alert('保存成功', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 1})
            currentButton.removeClass('saveRecord')
            currentButton.addClass('editRecord')
            $('#saveSimpleAnswerFont').html('编辑答案')
        }
    });
}

function saveStepAnswer() {
    if ($('#question_id').val() == '' || $('#question_id').val() == null){
        layer.alert('请先保存题目', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        return
    }
    var currentButton = $('#saveStepAnswer')
    var ableToNext = clearStepAnswerFormat()
    if (ableToNext == false){
        layer.alert('请将红框中的图片上传至服务器', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        return
    }
    $.ajax({
        cache: true,
        type: "POST",
        url: "/quesBank/highPhyStepAnswerCtl/saveHighPhysicsStepAnswer",
        data: {
            question_id: $('#question_id').val(),
            detail_answer: JMEditor.html('questionStepSolve')
        },
        async: false,
        error: function (request) {
            layer.alert("error", {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        },
        success: function (data) {
            layer.alert('保存成功', {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 1});
            currentButton.removeClass('saveRecord')
            currentButton.addClass('editRecord')
            $('#saveStepAnswerFont').html('编辑答案')
            // window.location.reload(true)
        }
    });
}

function clearFormat() {
    var ableToNext = true;
    $('#questionContent p,span').removeAttr('style')
    $('#questionContent img').each(function () {
        var image = $(this)
        var imageSrc = $(this)[0].src;
        image.removeAttr('data-cke-saved-src');
        if (imageSrc.indexOf('data:image/png;base64,')!=-1){
            $.ajax({
                cache : true,
                type : "POST",
                url : "/quesBank/imgUploadCtl/upload",
                async: false,
                data : {
                    base64: imageSrc.replace('data:image/png;base64,','')
                },
                async : false,
                error : function(request) {
                    layer.alert("error", {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
                },
                success : function(data) {
                    image.attr('src','/quesBank/image/'+data+'.png')
                    image.attr('data-cke-saved-src','/quesBank/image/'+data+'.png')
                }
            });
        }
        if(imageSrc.indexOf('quesBank/image') == -1){
            ableToNext = false;
            image.css('border','3px solid red');
        }
    })
    return ableToNext;
}

function clearAnswerFormat() {
    var ableToNext = true;
    $('#questionSimpleSolve p').removeAttr('style')
    $('#questionSimpleSolve img').each(function () {
        var image = $(this)
        var imageSrc = $(this)[0].src;
        image.removeAttr('data-cke-saved-src');
        if (imageSrc.indexOf('data:image/png;base64,')!=-1){
            $.ajax({
                cache : true,
                type : "POST",
                url : "/quesBank/imgUploadCtl/upload",
                async: false,
                data : {
                    base64: imageSrc.replace('data:image/png;base64,','')
                },
                async : false,
                error : function(request) {
                    layer.alert("error", {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
                },
                success : function(data) {
                    image.attr('src','/quesBank/image/'+data+'.png')
                    image.attr('data-cke-saved-src','/quesBank/image/'+data+'.png')
                }
            });
        }
        if(imageSrc.indexOf('quesBank/image') == -1){
            ableToNext = false;
            image.css('border','3px solid red');
        }
    })
    return ableToNext;
}

function clearStepAnswerFormat() {
    var ableToNext = true;
    $('#questionStepSolve p').removeAttr('style')
    $('#questionStepSolve img').each(function () {
        var image = $(this)
        var imageSrc = $(this)[0].src;
        image.removeAttr('data-cke-saved-src');
        if (imageSrc.indexOf('data:image/png;base64,')!=-1){
            $.ajax({
                cache : true,
                type : "POST",
                url : "/quesBank/imgUploadCtl/upload",
                async: false,
                data : {
                    base64: imageSrc.replace('data:image/png;base64,','')
                },
                async : false,
                error : function(request) {
                    layer.alert("error", {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
                },
                success : function(data) {
                    image.attr('src','/quesBank/image/'+data+'.png')
                    image.attr('data-cke-saved-src','/quesBank/image/'+data+'.png')
                }
            });
        }
        if(imageSrc.indexOf('quesBank/image') == -1){
            ableToNext = false;
            image.css('border','3px solid red');
        }
    })
    return ableToNext;
}

function getMajor() {
    $.ajax({
        cache: true,
        type: "GET",
        url: "../highPhyMajorCtl/getMajor",
        async: false,
        error: function (request) {
            layer.alert("error", {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        },
        success: function (data) {
            var majors = data.highPhysicsMajors;
            $('#majorName').empty();
            $('#majorName').append(selectOptionFirstTemplate.replace('OPTIONNAME', '选择父知识点'))
            for (var i = 0; i < majors.length; i++) {
                $('#majorName').append(selectOptionTemplate.replace('OPTIONVALUE', majors[i].id).replace('OPTIONNAME', majors[i].major));
            }
        }
    });
}

function changeMajor(majorId) {
    $.ajax({
        cache: true,
        type: "GET",
        url: "../highPhyMajorCtl/getMajorSub?id=" + majorId,
        async: false,
        error: function (request) {
            layer.alert("error", {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        },
        success: function (data) {
            var highPhysicsMajorSubs = data.highPhysicsMajorSubs;
            $('#majorSubName').empty();
            $('#majorSubItemName').empty();
            for (var i = 0; i < highPhysicsMajorSubs.length; i++) {
                $('#majorSubName').append(selectOptionTemplate.replace('OPTIONVALUE', highPhysicsMajorSubs[i].id).replace('OPTIONNAME', highPhysicsMajorSubs[i].major_sub_name));
            }
            clearBlock('majorSubNameBlock')
            clearBlock('majorSubItemNameBlock')
        }
    });
}

function changeMajorSub(majorSubId) {
    $.ajax({
        cache: true,
        type: "GET",
        url: "../highPhyMajorCtl/getMajorSubItem?id=" + majorSubId,
        async: false,
        error: function (request) {
            layer.alert("error", {title: ['信息', 'color:white;background-color:#65a2ff;font-weight:bold'],icon: 2})
        },
        success: function (data) {
            var highPhysicsMajorSubItems = data.highPhysicsMajorSubItems;
            $('#majorSubItemName').empty();
            // $('#majorSubItemName').append(selectOptionFirstTemplate.replace('OPTIONNAME', '选择子知识点'))
            for (var i = 0; i < highPhysicsMajorSubItems.length; i++) {
                $('#majorSubItemName').append(selectOptionTemplate.replace('OPTIONVALUE', highPhysicsMajorSubItems[i].id).replace('OPTIONNAME', highPhysicsMajorSubItems[i].major_sub_item_name));
            }
            clearBlock('majorSubItemNameBlock')
        }
    });
}

function clearBlock(blockId) {
    $('#BLOCKID .select-picker-search'.replace('BLOCKID', blockId)).remove();
    $('#BLOCKID .select-picker-options-wrp'.replace('BLOCKID', blockId)).remove();
    $("#BLOCKID".replace('BLOCKID', blockId)).unbind('click');
    $("#BLOCKID".replace('BLOCKID', blockId)).mySelect();
}

function getIdByContent(contentId, selectId) {
    var conId = '#CONID .select-picker-search-checked';
    var selId = '#SELID option';
    var content = $(conId.replace('CONID', contentId)).html();
    var contentList = content.split(',');
    var idList = ''
    $(selId.replace('SELID', selectId)).each(function () {
        var opt = $(this)
        for (var i = 0; i < contentList.length; i++) {
            if (opt.html() == contentList[i]){
                idList += idList == '' ? opt.val() : "," + opt.val();
            }
        }
    })
    return idList
}