/**
 * Created by lenovo on 2017/9/20.
 */

function sendEmcode() {
    var email = $("#email").val();
    $.ajax({
        url: 'emcode?email=' + email,
        method: 'GET',
        success: function (data) {
            console.log(data);
        }
    })
}
