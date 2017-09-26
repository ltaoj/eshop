/**
 * Created by lenovo on 2017/9/26.
 */

function addSupplier() {
    var supplierId = $("#supplierId").val();
    var name = $("#name").val();
    var phone = $("#phone").val();
    var email = $("#email").val();
    var sex = $("#sex").val() == "男" ? 1 : 0;
    var province = $("#province").val();
    var city = $("#city").val();
    var json = {supplierId: supplierId, name: name, phone: phone, email:email, sex: sex, province: province, city: city};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'registS',
        method: 'POST',
        dataType: "json",
        data: JSON.stringify(json),
        success: function (data) {
            $("#alert").html("");
            $("#supplierModal").modal("hide");
            if (data.result == "success") {
                $("#alert").html(alert("success", data.object));
            } else if (data.code == 1) {
                $("#alert").html(alert("danger", data.message));
            }
        },
        error: function () {
            $("#alert").html(alert("danger", "服务器错误"));
        }
    })
}