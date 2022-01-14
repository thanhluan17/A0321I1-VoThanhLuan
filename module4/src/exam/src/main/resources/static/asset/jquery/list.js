$(document).ready(function () {
    $(".btn-search").click(function () {
        var namediscount = $("#namediscount").val();
        console.log(namediscount)
        $.ajax({
            type: "GET",
            url: "/discount/list?key=" + namediscount,
            dataType: "HTML",
            success: function (data) {
                $("#searchTable").html(data);
            }
        });
    })
})

// $(document).ready(function () {
//     $(".btn-search").click(function () {
//         var namediscount = $("#namediscount").val();
//         var namestart = $("#namestart").val();
//         var nameend = $("#nameend").val();
//         console.log(namediscount)
//         console.log(namestart)
//         console.log(nameend)
//         $.ajax({
//             type: "GET",
//             url: "/discount/list?key=" + namediscount + "&start=" + namestart + "&end=" + nameend,
//             dataType: "HTML",
//             success: function (data) {
//                 $("#searchTable").html(data);
//             }
//         });
//     })
// })

$(document).ready(function () {
    $(".btnModalView").click(function () {
        $.ajax({
            type: "GET",
            url: "view/" + $(this).next().val(),
            dataType: "HTML",
            success: function (data) {
                $(".modal-body").html(data);
                $("#modelId").modal("show")
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
