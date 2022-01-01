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
        })
    })
})