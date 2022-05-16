var notify = {
    show: function (title, content, duration, style) {
        duration = duration || 5;
        let ne = $(`<div class="notify" style="animation:notify-show-hide ${(duration < 0 ? 5 : duration) / 2}s ease-in-out${duration < 0 ? ';' : ' 2;animation-direction:alternate;'}${style}">
                        <div class="notify-title">${title}</div>
                        <div class="notify-content">${content}</div>
                    </div>`)[0];
        $(".notify-container").append(ne);
        if (duration > 0) {
            setTimeout(function () {
                ne.remove()
            }, duration * 1000 - 50);
        }
    },
    success: function (title, content, duration) {
        this.show(title, content, duration, 'background: #13af17;');
    },
    warning: function (title, content, duration) {
        this.show(title, content, duration, 'background: #e28525;');
    },
    error: function (title, content, duration) {
        this.show(title, content, duration, 'background: #fa4a44;');
    }
};

$(function () {
    $("#province").focus(function () {
        $.get("../getProvince.do", {},
            function (data) {
                var arr = data.split(" ");
                $("#province").empty();
                $("#province").append("<option value=''>省份</option>");
                for (let i = 0; i < arr.length - 1; i++)
                    $("#province").append("<option value='" + arr[i] + "'>" + arr[i] + "</option>");
            });
    });

    $("#province").change(function () {
        const pro = $("#province").val();
        $.get("../getCity.do",
            {
                province: pro
            },
            function (data) {
                console.log(pro);
                console.log(data);
                var arr = data.split(" ");
                $("#city").empty();
                $("#city").append("<option value=''>城市</option>");
                for (let i = 0; i < arr.length - 1; i++)
                    $("#city").append("<option value='" + arr[i] + "'>" + arr[i] + "</option>");
            });
    });

    $("#finish").click(function () {
        const emailReg = /^([a-zA-Z]|\d)(\w|\-)+@[a-zA-Z\d]+\.([a-zA-Z]{2,4})$/;
        const phoneReg = /^1[3|4|5|7|8]\d{9}$/;
        if (!$('#username').val() || !$('#password').val() || !$('#re_password').val() ||
            !$('#name').val() || !$('#email').val() || !$('#phone_num').val() ||
            !$('#province').val() || !$('#city').val() || !$('#birthday').val() || !$('input[name="gender"]:checked').val())
            notify.warning("提示", "请完成所有内容！");
        else {
            if ($('#password').val() != $('#re_password').val()) notify.warning("提示", "两次密码不相同！");
            else if (!emailReg.exec($('#email').val())) notify.warning("提示", "邮箱格式错误！");
            else if (!phoneReg.exec($('#phone_num').val())) notify.warning("提示", "电话格式错误！");
            else {
                $.post("../register.do",
                    {
                        username: $('#username').val(),
                        password: $('#password').val(),
                        name: $('#name').val(),
                        email: $('#email').val(),
                        phone_num: $('#phone_num').val(),
                        province: $("#province").val(),
                        city: $("#city").val(),
                        birthday: $('#birthday').val(),
                        gender: $('input[name="gender"]:checked').val(),
                    },
                    function (data) {
                        switch (parseInt(data)) {
                            case 101:
                                notify.warning("提示", "该邮箱已被使用！");
                                break;
                            case 102:
                                notify.warning("提示", "该用户名已被使用!");
                                break;
                            case 103:
                                notify.warning("提示", "该手机号已被使用!");
                                break;
                            case 202:
                                notify.success("成功", "注册成功");
                                break;
                            case 403:
                                notify.error("错误", "注册失败");
                                break;
                            default:
                                notify.error("错误", "未知错误！");
                        }
                    });
            }
        }
    });
});