$(document).ready(function () {
    var datas = [];
    $("#searchLogo").click(function () {
        $.ajax({
            type: "post",
            url: "../query.do",
            data: {info: $("#info").val()},
            dataType: "json",
            success: function (response) {
                $("#tbodyAddPoint").empty();
                $("#bAddPoint").empty();
                datas.length = 0;
                $("#result").css("display", "block");
                for (let j = 0, i = 0; i < response.length; i += 13, j++)
                    datas[j] = response.slice(i, i + 13);
                for (let i = 0; i < datas.length; i++) {
                    const info_li = "<button type=\"button\" class=\"btn btn-light\" id=\"" + (i + 1) + "\">" + (i + 1) + "</button>"
                    $("#bAddPoint").append(info_li);
                }
                for (let j = 0; j < datas[0].length; j++) {
                    const info_tbody = "<tr>\n" +
                        "        <td>" + datas[0][j].ID + "</td>\n" +
                        "        <td>" + datas[0][j].name + "</td>\n" +
                        "        <td>" + datas[0][j].gender + "</td>\n" +
                        "        <td>" + datas[0][j].province + "</td>\n" +
                        "        <td>" + datas[0][j].city + "</td>\n" +
                        "      </tr>";
                    $("#tbodyAddPoint").append(info_tbody);
                }
            }
        });
    });
    $("#bAddPoint").on("click", "button", function () {
        $("#tbodyAddPoint").empty();
        var i = $(this).attr("id") - 1;
        for (let j = 0; j < datas[i].length; j++) {
            const info_tbody = "<tr>\n" +
                "        <td>" + datas[i][j].ID + "</td>\n" +
                "        <td>" + datas[i][j].name + "</td>\n" +
                "        <td>" + datas[i][j].gender + "</td>\n" +
                "        <td>" + datas[i][j].province + "</td>\n" +
                "        <td>" + datas[i][j].city + "</td>\n" +
                "      </tr>";
            $("#tbodyAddPoint").append(info_tbody);
        }
    });
});