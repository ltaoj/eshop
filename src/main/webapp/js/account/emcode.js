/**
 * Created by lenovo on 2017/9/20.
 */

function sendEmcode() {
    var email = $("#email").val();
    $.ajax({
        url: 'emcode?email=' + email,
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
