/**
 * Created by lenovo on 2017/9/22.
 */
/**
 * 添加订单
 */
function addAddress() {
    var name = $("#name").val();
    var phone = $("#phone").val();
    var province = $("#province").val();
    var city = $("#city").val();
    var district = $("#district").val();
    var detailAddr = $("#detailAddr").val();
    var json = {aliasName: name, phone: phone, province: province, city: city, district: district, detailAddr: detailAddr};
    $.ajaxSetup({contentType: 'application/json'});
    $.ajax({
        url: 'addHarvAddr',
        method: 'POST',
        dataType: "json",
        data: JSON.stringify(json),
        success: function (data) {
            console.log(data);
        }
    })
}

/**
 * 删除订单
 */
function deleteAddress() {

}