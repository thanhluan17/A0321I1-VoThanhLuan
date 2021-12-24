$(document).ready(function () {
    $("#search").click(function () {
        var word = $("#word").val();
        console.log(word);
        $.ajax({
            type: "GET",
            url: "/blog/list?word=" + word,
            dataType: "HTML",
            success: function (data) {
                $(".blog-table").html(data);
            }
        })
    })
})

$(document).ready(function () {
    $("#more-blog").click(function () {
        $.ajax({
            type: "GET",
            url: "/blog/list-more",
            dataType: "HTML",
            success: function (data) {
                $(".blog-table").html(data);
            }
        })
    })
})