/**
 * Created by lenovo on 2017/9/22.
 */
function regist() {
    console.log("123");
    var userId = $("#user_id").val();
    var password = $("#password").val();
    var repeatPassword = $("#repeatPassword").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    var code = $("#code").val();
    var json = { signon: {userId: userId, password: password, phone: phone, email: email}, repeatPassword: repeatPassword, code: code}
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'regist',
        method: 'POST',
        dataType: "json",
        data: JSON.stringify(json),
        success: function (data) {
            console.log(data);
        }
    })
}
