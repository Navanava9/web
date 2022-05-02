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
    $("#VCodeImg").click(function () {
        var t = new Date();
        $(this).attr("src", "../VCode.do?t=" + t);
    });

    $("#submitBtn").click(function () {
        if (!$('#username').val() || !$('#password').val() || !$("#VCode").val()) {
            notify.warning("提示", "请输入账号，密码或验证码");
        } else {
            $.post("../login.do",
                {
                    userName: $("#username").val(),
                    password: $("#password").val(),
                    VCode: $("#VCode").val()
                },
                function (data) {
                    notify.success("提示", data);
                });
        }
    });

});