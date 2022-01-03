$(document).ready(function () {
    $("#search").click(function () {
        var name = $("#name").val();
        console.log(name);
        $.ajax({
            type: "GET",
            url: "/employee/list?name=" + name,
            dataType: "HTML",
            success: function (data) {
                $(".employee-table").html(data);
            }
        });
    })
})

function showDelete(id) {
    $.ajax({
        type: "GET",
        url: "delete/" + id,
        dataType: "HTML",
        success: function (data) {
            $(".modal-body").html(data);
            $("#modelId").modal("show")
        }
    })
}

function actionDelete(id) {
    $.ajax({
        type: "POST",
        url: "actionDelete/" + id,
        dataType: "HTML",
        success: function (data) {
            let message = "Delete success!"
            setTimeout(function () {
                $("#modelId").modal("hide")
            }, 1000);
            $("#searchTable").html(data)
            $(".modal-body").html(message);
        }
    })
}