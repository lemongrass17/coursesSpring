function openPopUpLessC(){
    var backPopUp = document.getElementById("popupconflessc");
    var popUp = document.getElementById("popuplessc");
    backPopUp.style.display = "inline";
    popUp.style.display = "inline";
};

function updateCourse(){
    document.getElementById("courseTitle").setAttribute("value",
        document.getElementById("courseInfoTitle").innerHTML
            .replace("'", "|"));
    document.getElementById("courseTheme").setAttribute("value",
        document.getElementById("themeOfCourse").innerHTML
            .replace("'", "|"));
    document.getElementById("courseDescription").setAttribute("value",
        document.getElementById("courseDesc").innerHTML
            .replace("'", "|"));
    document.getElementById("data_send1").submit();
};

function save_course(){
    document.getElementById("course_title_form").setAttribute("value",
             document.getElementById("edit_input_title_id").innerHTML.replace("'", "|"));
    document.getElementById("theme_form").setAttribute("value",
        document.getElementById("edit_input_text").innerHTML.replace("'", "|"));
    document.getElementById("description_form").setAttribute("value",
        document.getElementById("edit_description_id").innerHTML.replace("'", "|"));
    document.getElementById("data_send").submit();
}

function closePopUpLessC(){
    var backPopUp = document.getElementById("popupconflessc");
    var popUp = document.getElementById("popuplessc");
    backPopUp.style.display = "none";
    popUp.style.display = "none";
};

function openPopUpLessL(but){
    var backPopUp = document.getElementById("popupconflessl");
    var popUp = document.getElementById("popuplessl");

    var id = but.parentElement.childNodes.item(1).value;

    document.getElementById("deleteLess").value = id;

    backPopUp.style.display = "inline";
    popUp.style.display = "inline";
};

function closePopUpLessL(){
    var backPopUp = document.getElementById("popupconflessl");
    var popUp = document.getElementById("popuplessl");
    backPopUp.style.display = "none";
    popUp.style.display = "none";
};

function openPopUpLessT(){
    var backPopUp = document.getElementById("popupconflesst");
    var popUp = document.getElementById("popuplesst");
    backPopUp.style.display = "inline";
    popUp.style.display = "inline";
};

function closePopUpLessT(){
    var backPopUp = document.getElementById("popupconflesst");
    var popUp = document.getElementById("popuplesst");
    backPopUp.style.display = "none";
    popUp.style.display = "none";
};

function deleteCourse() {
    document.getElementById("deleteCourseForm").submit();
}

function deleteLesson() {
    var id = document.getElementById("deleteLess").value;
    document.getElementById("deleteLessonForm" + id).submit();
}

function deleteTest() {
    document.getElementById("deleteTestForm").submit();
}
