/**
 * Created by lenovo on 2017/9/24.
 */
/**
 * 更新用户基本信息
 */
function upUserInfo() {
    var sex = $("#sex").val() == "男" ? 1 : 0;
    var name = $("#username").val();
    var email = $("#email").val();
    var phone = $("#phone").val();
    var json = {name: name, email: email, phone: phone, sex: sex};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'upMyInfo',
        method: 'POST',
        dataType: "json",
        data: JSON.stringify(json),
        success: function (data) {
            console.log(data);
        }
    })
}

/**
 * 删除收获地址
 * @param addrId
 */
function deleteAddr(addrId) {
    $.ajax({
        url: 'delHarvAddr?addrId=' + addrId,
        method: 'GET',
        success: function (data) {
            if (data.result == "success") {
                layer.msg(data.object);
            } else if (data.code == 1) {
                layer.msg(data.message);
            }
        },
        error: function () {
            layer.msg("服务器错误");
        }
    })
}

/**
 * 修改密码
 */
function changePwd() {
    var originPassword = $("#origin_password").val();
    var password = $("#new_password").val();
    var repeatPassword = $("#required_password").val();
    var json = {originPassword: originPassword, password: password, repeatPassword: repeatPassword};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'changePwd',
        method: 'POST',
        dataType: "json",
        data: JSON.stringify(json),
        success: function (data) {
            console.log(data);
            window.parent.location.reload();
        }
    })
}