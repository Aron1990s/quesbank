var selectOptionFirstTemplate = '<option value ="" disabled selected style="display:none;">OPTIONNAME</option>';
var selectOptionTemplate = '<option value = OPTIONVALUE>OPTIONNAME</option>';
$(function () {
    getGrade();
    getMajor();
})

function getGrade() {
    $.ajax({
        cache: true,
        type: "GET",
        url: "../highPhyGrChCtl/getGradeInfo",
        async: false,
        error: function (request) {
            alert("error")
        },
        success: function (data) {
            var grades = data.grades;
            $('#gradeName').empty();
            $('#gradeName').append(selectOptionFirstTemplate.replace('OPTIONNAME', '选择年级'))
            for (var i = 0; i < grades.length; i++) {
                $('#gradeName').append(selectOptionTemplate.replace('OPTIONVALUE', grades[i].id).replace('OPTIONNAME', grades[i].grade));
            }
        }
    });
}

function changeGrade(gradeId) {
    $.ajax({
        cache: true,
        type: "GET",
        url: "../highPhyGrChCtl/getChapterInfo?gradeId=" + gradeId,
        async: false,
        error: function (request) {
            alert("error")
        },
        success: function (data) {
            var chapters = data.chapters;
            $('#chapterName').empty();
            $('#chapterSubName').empty();
            $('#chapterSubName').append('<option value ="" disabled selected style="display:none;">选择章节子项</option>')
            $('#chapterSubItemName').empty();
            $('#chapterSubItemName').append('<option value ="" disabled selected style="display:none;">选择章节知识点</option>')
            $('#chapterName').append(selectOptionFirstTemplate.replace('OPTIONNAME', '选择章节'))
            for (var i = 0; i < chapters.length; i++) {
                $('#chapterName').append(selectOptionTemplate.replace('OPTIONVALUE', chapters[i].id).replace('OPTIONNAME', chapters[i].chapter_name));
            }
        }
    });
}

function changeChapter(chapterId) {
    $.ajax({
        cache: true,
        type: "GET",
        url: "../highPhyGrChCtl/getChapterSubInfo?chapterId=" + chapterId,
        async: false,
        error: function (request) {
            alert("error")
        },
        success: function (data) {
            var chapterSubs = data.chapterSubs;
            $('#chapterSubName').empty();
            $('#chapterSubItemName').empty();
            $('#chapterSubItemName').append('<option value ="" disabled selected style="display:none;">选择章节知识点</option>')
            $('#chapterSubName').append(selectOptionFirstTemplate.replace('OPTIONNAME', '选择章节子项'))
            for (var i = 0; i < chapterSubs.length; i++) {
                $('#chapterSubName').append(selectOptionTemplate.replace('OPTIONVALUE', chapterSubs[i].id).replace('OPTIONNAME', chapterSubs[i].chapter_sub_name));
            }
        }
    });
}

function changeChapterSub(chapterSubId) {
    $.ajax({
        cache: true,
        type: "GET",
        url: "../highPhyGrChCtl/getChapterSubItemInfo?chapterSubId=" + chapterSubId,
        async: false,
        error: function (request) {
            alert("error")
        },
        success: function (data) {
            var chapterSubItems = data.chapterSubItems;
            $('#chapterSubItemName').empty();
            $('#chapterSubItemName').append('<option value ="" disabled selected style="display:none;">选择章节知识点</option>')
            for (var i = 0; i < chapterSubItems.length; i++) {
                $('#chapterSubItemName').append(selectOptionTemplate.replace('OPTIONVALUE', chapterSubItems[i].id).replace('OPTIONNAME', chapterSubItems[i].chapter_sub_item));
            }
        }
    });
}