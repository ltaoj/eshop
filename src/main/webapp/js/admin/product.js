/**
 * Created by lenovo on 2017/9/26.
 */
function addCategory() {
    var name = $("#name").val();
    var description  = $("#description").val();
    var categoryId = $("#categoryId").val();
    var json = {name: name, description: description, categoryId: categoryId};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'addCategory',
        method: 'POST',
        dataType: "json",
        data: JSON.stringify(json),
        success: function (data) {
            $("#alert").html("");
            $("#pModal").modal("hide");
            if (data.result == "success") {
                window.parent.location.reload();
            } else if (data.code == 25) {
                $("#alert").html(alert("danger", data.message));
            }
        },
        error: function () {
            $("#alert").html(alert("danger", "服务器错误"));
        }
    })
}

function deleteCategory(categoryId) {
    $.ajax({
        url: 'cancelOrder?orderId=' + orderId,
        method: 'GET',
        success: function (data) {
            console.log(data);
        }
    })
}