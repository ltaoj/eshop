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